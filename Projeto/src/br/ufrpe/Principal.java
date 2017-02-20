package br.ufrpe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Remedio;
import br.ufrpe.excecoes.CaracterInvalidoException;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.ControladorAnimal;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.negocios.ControladorProduto;
import br.ufrpe.repositorios.RepositorioAnimal;
import br.ufrpe.repositorios.RepositorioPessoa;
import br.ufrpe.repositorios.RepositorioProduto;

public class Principal {
	@SuppressWarnings("finally")
	private static LocalDate getData(Scanner scanner){
		LocalDate data = null;
		try{			
			String d = scanner.nextLine();
			DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			data = LocalDate.parse(d, DATE_FORMAT);
		}catch(DateTimeParseException e){
			System.out.print("Digite uma data correspondente ao formato \"dia-m�s-ano\": ");
			data = getData(scanner);
		}finally{
			return data;
		}
	}
	@SuppressWarnings("finally")
	public static char getChar(Scanner scanner){
		String i = null;
		try{
			i = scanner.nextLine();
			if(i.length() > 1 || i.length() == 0){
				throw new CaracterInvalidoException(i.charAt(0));
			}
		}catch(CaracterInvalidoException e){
			System.out.print("Digite um numero:");
			i = ""+getChar(scanner);
		}finally{
			return i.charAt(0);			
		}
	}
	@SuppressWarnings("finally")
	private static short getShort(Scanner scanner){
		short i = 0;
		try{
			i = Short.parseShort(scanner.nextLine());	
		}catch(NumberFormatException e){
			System.out.print("Digite um numero valido: ");
			i = getShort(scanner);
		}finally{
			return i;			
		}
	}
	
	@SuppressWarnings("finally")
	private static int getInt(Scanner scanner){
		int i = 0;
		try{
			i = Integer.parseInt(scanner.nextLine());	
		}catch(NumberFormatException e){
			System.out.print("Digite um numero: ");
			i = getInt(scanner);
		}finally{
			return i;			
		}
	}
	
	@SuppressWarnings("finally")
	private static double getDouble(Scanner scanner){
		double i = 0;
		try{
			i = Double.parseDouble(scanner.nextLine());	
		}catch(NumberFormatException e){
			System.out.print("Digite um numero");
			i = getDouble(scanner);
		}finally{
			return i;			
		}
	}

	private static void menu(Scanner scanner, ControladorAnimal animalControlador, 
			ControladorProduto produtoControlador,ControladorPessoa pessoaControlador) 
					throws ObjectNaoExisteException, ObjectJaExisteException, 
					ErroAoRemoverException, ErroAoSalvarException, ErroAoAtualizarException{
		char op;
		do {
			System.out.print("########################## MENU ##########################\n");
			System.out.print("\t1.PetShop\n"
					+ "\t2.Cliente\n"
					+ "\t3.Animal\n"
					+ "\t4.Produto\n"
					+ "\t5.Funcionario\n"
					+ "\t6.Pessoa\n"
					+ "\t7.Sair");
			System.out.println("\n#######################################################\n");
			System.out.print("Opcao: ");
			op = getChar(scanner);
			switch (op) {
			case '2':
				menuCliente(scanner, animalControlador, pessoaControlador);
				break;
			case '3':
				menuAnimal(scanner, pessoaControlador, animalControlador);
				break;
			case '4':
				menuProduto(scanner, produtoControlador);
				break;
			case '5':
				menuFuncionario(scanner, pessoaControlador);
				break;
			case '6':
				menuPessoa(scanner, pessoaControlador);
				break;
			case '7':
				pessoaControlador.salvarNoArquivo();
				animalControlador.salvarNoArquivo();
				produtoControlador.salvarNoArquivo();
				System.exit(0);
				break;
			case '1':
				menuPetShop(scanner);
				break;
			default:
				System.out.println("\n\n----------Opcao Invalida----------\n");
				break;
			}
		} while (op != 5);
	}

	private static void menuPetShop(Scanner scanner) {
		
	}
	private static void menuPessoa(Scanner scanner, ControladorPessoa pessoaControlador) throws ObjectNaoExisteException {
		char op;
		do{
			System.out.print("########################## MENU ##########################\n");
			System.out.print("\t1.Pesquisar\n"
					+ "\t2.Listar\n"
					+ "\t3.Sair");
			System.out.println("\n#######################################################\n");
			System.out.print("Opcao: ");
			op = getChar(scanner);
			switch (op) {
			case '1':
				System.out.println("Digite o cpf: ");
				String cpf = scanner.nextLine();
				pesquisarPessoa(cpf, pessoaControlador);
				break;
			case '2':
				listarPessoa(pessoaControlador);
				break;
			case '3':
				break;
			default:
				System.out.println("Op��o Invalida");
				break;
			}
		}while(op != '3');
	}

	private static void listarPessoa(ControladorPessoa pessoaControlador) {
		ArrayList<Funcionario> array= pessoaControlador.listarFuncionario();
		System.out.println(array.size());
		for(int i = 0; i < array.size();i++){
			System.out.println(array.get(i));
		}
	}

	private static void pesquisarPessoa(String cpf, ControladorPessoa pessoaControlador) throws ObjectNaoExisteException{
		try{
			Pessoa pessoa = pessoaControlador.buscar(cpf);
			System.out.println(pessoa.toString());
		}catch(ObjectNaoExisteException E){
			System.out.println(E.getMessage());
		}
	}

	private static void menuFuncionario(Scanner scanner, ControladorPessoa pessoaControlador) throws ObjectNaoExisteException,
	ErroAoRemoverException, ErroAoSalvarException, ErroAoAtualizarException, ObjectJaExisteException{
		char op2;
		do{
			System.out.println("\n########################## Funcionario ##########################");
			System.out.print("\t1.Cadastrar\n"
					+ "\t2.Remover\n"
					+ "\t3.Atualizar\n"
					+ "\t4.Pesquisar\n"
					+ "\t5.Sair");
			System.out.println("\n#################################################################\n");

			System.out.print("Opcao: ");
			op2 = getChar(scanner);

			switch (op2){
			case '1':
				cadastrarFuncionario(scanner, pessoaControlador);
				break;

			case '2':
				removerFuncionario(scanner, pessoaControlador);
				break;

			case '3':
				atualizarFuncionario(scanner, pessoaControlador);
				break;

			case '4':
				pesquisarFuncionario(scanner, pessoaControlador);
				break;
			case '5':
				break;
			default:
				System.out.println("\n\n----------Opcao Invalida----------\n");
				break;

			}
		}while(op2 != '5');
	}

	private static void pesquisarFuncionario(Scanner scanner, ControladorPessoa pessoaControlador)
		throws ObjectNaoExisteException{
		String cpf;
		try{
			System.out.println("Informe o cpf: ");
			cpf = scanner.nextLine();
			
			Pessoa funcionario = pessoaControlador.buscar(cpf); 
			System.out.println("\n\n" + ((Funcionario) funcionario) + "\n");			
		}catch(IllegalArgumentException | ObjectNaoExisteException I){
			System.out.println(I.getMessage());
		}
	}

	private static void atualizarFuncionario(Scanner scanner, ControladorPessoa pessoaControlador) 
			throws ErroAoAtualizarException, ObjectNaoExisteException{
		char op3;
		String cpf;
		Pessoa funcionario;
		try{
			System.out.print("Informe o CPF: ");
			cpf = scanner.nextLine();
			
			Pessoa testeDeVerificacao = pessoaControlador.buscar(cpf);
			
			funcionario = new Funcionario(cpf);
			
			System.out.print("\n1.Atualizar Endereco\n"
					+ "2.Atualizar Cargo\n"
					+ "3.Atualizar Salario\n"
					+ "\nOpcao: ");
			op3 = getChar(scanner);

			switch(op3){
			case '1':
				atualizarEnderecoFuncionario(scanner, pessoaControlador, funcionario);
				break;
			case '2':
				atualizarCargoFuncionario(scanner, pessoaControlador, funcionario);
				break;
			case '3':
				atualizarSalarioFuncionario(scanner, pessoaControlador, funcionario);
				break;
			default:
				System.out.println("\n\n----------Opcao Invalida----------\n");
				break;							
			}			
		}catch(IllegalArgumentException | ObjectNaoExisteException E){
			System.out.println(E.getMessage());
		}
	}

	private static void atualizarSalarioFuncionario(Scanner scanner, ControladorPessoa pessoaControlador,
			Pessoa funcionario) throws ObjectNaoExisteException, ErroAoAtualizarException{
		double salario;
		try{
			System.out.println("Informe o salario: ");
			salario = Double.parseDouble(scanner.nextLine());
			((Funcionario) funcionario).setSalario(salario);
			
			pessoaControlador.atualizar(funcionario);
		}catch(IllegalArgumentException | ObjectNaoExisteException | ErroAoAtualizarException E){
			System.out.println(E.getMessage());
		}
	}

	private static void atualizarCargoFuncionario(Scanner scanner, ControladorPessoa pessoaControlador,
			Pessoa funcionario) throws ObjectNaoExisteException, ErroAoAtualizarException{
		String cargo;
		try{
			System.out.println("Informe o cargo: ");
			cargo = scanner.nextLine();							
			((Funcionario) funcionario).setCargo(cargo);
			
			pessoaControlador.atualizar(funcionario);
		}catch(IllegalArgumentException | ObjectNaoExisteException | ErroAoAtualizarException E){
			System.out.println(E.getMessage());
		}
	}

	private static void atualizarEnderecoFuncionario(Scanner scanner, ControladorPessoa pessoaControlador, 
			Pessoa funcionario) throws ErroAoAtualizarException, ObjectNaoExisteException{
		String rua;
		String complemento;
		String cidadeUF;
		String cep;
		short numero;
		Endereco end;
		System.out.print("Digite o nome da rua: ");
		rua = scanner.nextLine();
		System.out.print("Digite o complemento: ");
		complemento = scanner.nextLine();
		System.out.print("Digite o numero da casa: ");
		numero = getShort(scanner);
		System.out.print("Digite o cep: ");
		cep = scanner.nextLine();
		System.out.print("Digite a cidade-UF: ");
		cidadeUF = scanner.nextLine();

		try{
			end = new Endereco(rua, complemento, numero, cep, cidadeUF);
			((Funcionario) funcionario).setEnd(end);
			pessoaControlador.atualizar(funcionario);
		}catch(IllegalArgumentException | ObjectNaoExisteException | ErroAoAtualizarException E){
			System.out.println(E.getMessage());
		}
	}

	private static void removerFuncionario(Scanner scanner, ControladorPessoa pessoaControlador) 
			throws ErroAoRemoverException, ObjectNaoExisteException{
		String cpf;
		try{
			System.out.print("Informe o CPF: ");
			cpf = scanner.nextLine();
			
			pessoaControlador.remover(cpf);
			System.out.println("Pessoa removida com sucesso!");
		}catch(ErroAoRemoverException | IllegalArgumentException | ObjectNaoExisteException E){
			System.out.println(E.getMessage());
		}

	}

	private static void cadastrarFuncionario(Scanner scanner, 
			ControladorPessoa pessoaControlador) throws ErroAoSalvarException, ObjectNaoExisteException, ObjectJaExisteException {
		String cpf;
		String nome;
		String rua;
		String complemento;
		String cidadeUF;
		String cep;
		short numero;
		Endereco end;
		double salario;
		String cargo;
		Pessoa funcionario;
		
		System.out.print("\nInforme o nome: ");
		nome = scanner.nextLine();
		System.out.print("Informe o CPF: ");
		cpf = scanner.nextLine();
		System.out.print("Informe o salario: ");
		salario = getDouble(scanner);
		System.out.print("Informe o cargo: ");
		cargo = scanner.nextLine();
		System.out.print("Informe a data de aniversario (dd-mm-aaaa): ");
		LocalDate entrada = getData(scanner);

		System.out.print("Digite o nome da rua: ");
		rua = scanner.nextLine();
		System.out.print("Digite o complemento: ");
		complemento = scanner.nextLine();
		System.out.print("Digite o numero da casa: ");
		numero = getShort(scanner);
		System.out.print("Digite o cep: ");
		cep = scanner.nextLine();
		System.out.print("Digite a cidade-UF: ");
		cidadeUF = scanner.nextLine();

		try{
			end = new Endereco(rua, complemento, numero, cep, cidadeUF);
			funcionario = new Funcionario(nome, cpf, end, salario, entrada, cargo);	
			
			pessoaControlador.cadastrar((Funcionario) funcionario);
			System.out.println("Pessoa cadastrada com sucesso!");
		}catch(ErroAoSalvarException | IllegalArgumentException | ObjectJaExisteException E){
			System.out.println(E.getMessage());
		}
	}

	private static void menuProduto(Scanner scanner, ControladorProduto produtoControlador) {
		char op2;
		/*
		 * Menu Produto
		 */
		do{
			System.out.println("\n########################## Produto ##########################");
			System.out.print("\t1.Cadastrar\n"
					+ "\t2.Remover\n"
					+ "\t3.Atualizar\n"
					+ "\t4.Pesquisar\n"
					+ "\t5.Sair");
			System.out.println("\n#############################################################\n");
			System.out.print("Opcao: ");
			op2 = getChar(scanner);

			switch (op2){
			case '1':
				cadastrarProduto(scanner, produtoControlador);
				break;
			case '2':
				removerProduto(scanner, produtoControlador);
				break;
			case '3':
				atualizarProduto(scanner, produtoControlador);
				break;
			case '4':
				pesquisarProduto(scanner, produtoControlador);
				break;
			case '5':	
				break;
			default:
				System.out.println("\n----------Opcao Invalida----------");
				produtoControlador.salvarNoArquivo();
				break;
			}

		}while(op2 != '5');
	}

	private static void pesquisarProduto(Scanner scanner, ControladorProduto produtoControlador) {
		String codigo;
		Produto produto;
		/*
		 * Pesquisar
		 */
		System.out.println("Informe o codigo: ");
		codigo = scanner.nextLine();			
		try {
			produto = produtoControlador.pesquisar(codigo);
			if(produto != null){
				System.out.println("\n" + produto + "\n");
			}
		} catch (ObjectNaoExisteException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void atualizarProduto(Scanner scanner, ControladorProduto produtoControlador) {
		String nome;
		String tipo;
		String codigo;
		int estoque;
		float preco;
		Produto produto;
		/*
		 * Atualizar
		 */

		System.out.println("Informe o codigo: ");
		codigo = scanner.nextLine();						
		try {
			produto = produtoControlador.pesquisar(codigo);
			if(produto != null){
				nome = produto.getNome();
				System.out.println(nome);
				tipo = produto.getTipo();
				System.out.println(tipo);
				System.out.println("Informe o preco: ");
				preco = Float.parseFloat(scanner.nextLine());
				System.out.println("Informe a quantidade em estoque: ");
				estoque = getInt(scanner);

				Produto produtoNovo = new Remedio(preco, nome, tipo, estoque,"dsa");
				produtoControlador.atualizar(produtoNovo);
			}
		} catch (ObjectNaoExisteException | ErroAoAtualizarException e) {
	        System.out.println(e.getMessage());
		}
		
	}

	private static void removerProduto(Scanner scanner, ControladorProduto produtoControlador) {
		String codigo;
		/*
		 * Remover
		 */
		System.out.println("Informe o codigo: ");
		codigo = scanner.nextLine();				

		try {
			produtoControlador.remover(codigo);
		} catch (ObjectNaoExisteException | ErroAoRemoverException e) {
          System.out.println(e.getMessage());
		}
	}

	private static void cadastrarProduto(Scanner scanner, ControladorProduto produtoControlador) {
		String nome;
		String tipo;
		String codigo;
		int estoque;
		float preco;
		Produto produto;
		/*
		 * Cadastrar
		 */
		System.out.println("\nInforme o nome: ");
		nome = scanner.nextLine();
		System.out.println("Informe o tipo: ");
		tipo = scanner.nextLine();
		System.out.println("Informe o codigo: ");
		codigo = scanner.nextLine();
		System.out.println("Informe o preco: ");
		preco = Float.parseFloat(scanner.nextLine());
		System.out.println("Informe a quantidade em estoque: ");
		estoque = getInt(scanner);


		produto = new Remedio(preco, nome, tipo, estoque,"dsa");

		try {
			produtoControlador.cadastrar(produto);
		} catch (ObjectJaExisteException | ErroAoSalvarException e) {
			System.out.println(e.getMessage());
		};
	}

	private static void menuAnimal(Scanner scanner, ControladorPessoa pessoaControlador,
			ControladorAnimal animalControlador) throws ObjectNaoExisteException {
		char op2;
		do{
			/*
			 * Incompleto, precisa de um codigo para o animal!!
			 */
			System.out.println("\n########################## Animal ##########################");
			System.out.print("\t1.Cadastrar\n"
					+ "\t2.Remover\n"
					+ "\t3.Atualizar\n"
					+ "\t4.Pesquisar\n"
					+ "\t5.Listar\n"
					+ "\t6.Sair");
			System.out.println("\n############################################################\n");
			System.out.print("Opcao: ");
			op2 = getChar(scanner);

			switch(op2){
			case '1':
				cadastrarAnimal(scanner, pessoaControlador, animalControlador);
				break;
			case '2':
				removerAnimal(scanner, animalControlador);
				break;
			case '3':
				atualizarAnimal(scanner, pessoaControlador, animalControlador);
				break;
			case '4':
				pesquisarAnimal(scanner, animalControlador);
				break;
			case '5':
				break;
			default:
				System.out.println("Opcao Invalida\n");
				break;
			}
		}while(op2 != '5');
	}
	private static void pesquisarAnimal(Scanner scanner, ControladorAnimal animalControlador) {
		String codigo;
		System.out.print("Digite o codigo do animal: ");
		codigo = scanner.nextLine();
		try{
			Animal a = animalControlador.buscar(codigo);
			System.out.println("Animal codigo: "+a.getCodigo());
			System.out.println("Raca: "+a.getRaca());
			System.out.println("Nome: "+a.getNome());
			System.out.println("Dono: "+a.getDonoNome());
			System.out.println("CPF: "+a.getDonoCPF());
		}
		catch(CodigoNaoExisteException e){
			System.out.println(e.getMessage());
		}
		// O que isso faz?
	}

	private static void atualizarAnimal(Scanner scanner, ControladorPessoa pessoaControlador,
			ControladorAnimal animalControlador) throws ObjectNaoExisteException{
		char op3;
		String cpf;
		String codigo;
		float peso;
		float h;
		System.out.println("Digite o codigo do animal: ");
		codigo = scanner.nextLine();
		Animal a = null;
		try {
			a = animalControlador.buscar(codigo);
		} catch (CodigoNaoExisteException e2) {
		System.out.println(e2.getMessage());
		}
		if (a != null) {
			System.out.print("\t1.Adicionar novo dono\n"
					+ "\t2.Remover dono\n"
					+ "\t3.Mudar estatisticas\n"
					+ "\t4.Sair\nOpcao: ");
			op3 = scanner.nextLine().charAt(0);
			if (op3 == '1') {
				if (a.getDonoCPF() == null) {
					try{
						System.out.print("Digite o cpf do cliente: ");
						cpf = scanner.nextLine();
						Pessoa c = pessoaControlador.buscar(cpf);
						a.setDono((Cliente) c);
					}catch(ObjectNaoExisteException | IllegalArgumentException E){
						System.out.println(E.getMessage());
					}
				}else{
					System.out.println("Pet ja pertence a algu�m");
				}
			}else if (op3 == '2') {
				System.out.println("Digite o codigo do animal:");
				codigo = scanner.nextLine();
				try {
					a = animalControlador.buscar(codigo);
				} catch (CodigoNaoExisteException e1) {
				System.out.println(e1.getMessage());
				}
				if (a != null) {
					if (a.getDonoCPF() == null) {
						System.out.println("Animal ja nao possui dono");
					}else{
						System.out.println("Animal nao encontrado");
					}
				}else if(op3 == '3'){
					System.out.println("Digite o codigo do animal: ");
					codigo = scanner.nextLine();
					try {
						a = animalControlador.buscar(codigo);
					} catch (CodigoNaoExisteException e) {
						System.out.println(e.getMessage());
					}
					System.out.println(a);
					if (a != null) {
						System.out.println("Digite o peso do animal: ");									
						peso = Float.parseFloat(scanner.nextLine());
						System.out.println("Digite a altura do animal: ");
						h= Float.parseFloat(scanner.nextLine());
						a.setTamanho(h);
						a.setPeso(peso);
					}
				}
			}else{
				System.out.println("Codigo invalido");
			}

		}

	}

	private static void removerAnimal(Scanner scanner, ControladorAnimal animalControlador) {
		String codigo;
		System.out.print("Digite o codigo do animal: ");
		codigo = scanner.nextLine();
		try{
			animalControlador.remover(codigo);
		}
		catch(CodigoNaoExisteException e){
			System.out.println(e.getMessage());
		}
	}

	private static void cadastrarAnimal(Scanner scanner, ControladorPessoa pessoaControlador, 
			ControladorAnimal animalControlador) throws ObjectNaoExisteException{
		char op3;
		String raca;
		String especie;
		float peso;
		float h;
		System.out.println("Cadastrar dono: ");
		System.out.print("\t1.Sim"
				+ "\n\t2.Nao"
				+ "\n\nOpcao: ");
		op3 = getChar(scanner);

		if(op3 == '1'){

			System.out.print("Informe o cpf: ");
			String cpfD = scanner.nextLine();

			try{
				Pessoa dono = pessoaControlador.buscar(cpfD);
				System.out.println("Digite a raca: ");
				raca = scanner.nextLine();
				System.out.print("Digite a especie: ");
				especie = scanner.nextLine();
				System.out.print("Digite o peso do animal: ");
				peso = Float.parseFloat(scanner.nextLine());
				System.out.print("Digite a altura do animal: ");
				h = Float.parseFloat(scanner.nextLine());
				System.out.print("Digite o nome do pet: ");
				String nomePet = scanner.nextLine();
				System.out.println("Digite o codigo do pet");
				String codigoPet = scanner.nextLine();
				
				Animal novo = new Animal(true, especie, raca, dono, peso, h, nomePet,codigoPet);
				try {
					animalControlador.cadastrar(novo);
				} catch (ObjectJaExisteException e) {
					System.out.println(e.getMessage());
				}
			}catch(ObjectNaoExisteException | IllegalArgumentException I){
				System.out.println(I.getMessage());
			}
			
		}else if(op3 == '2'){
			System.out.print("Digite a raca: ");
			raca = scanner.nextLine();
			System.out.print("Digite a especie: ");
			especie = scanner.nextLine();
			System.out.print("Digite o peso do animal: ");
			peso = Float.parseFloat(scanner.nextLine());
			System.out.print("Digite a altura do animal: ");
			h = Float.parseFloat(scanner.nextLine());
			System.out.print("Digite o nome do animal: ");
			String nomePet = scanner.nextLine();
			System.out.print("Digite o codigo do pet: ");
			String codigoPet = scanner.nextLine();
			
			Animal novo = new Animal(true, especie, raca, null, peso, h, nomePet,codigoPet);
			try{
				animalControlador.cadastrar(novo);
			}
			catch(ObjectJaExisteException e){
				System.out.println(e.getMessage());
			}
		}

	}

	private static void menuCliente(Scanner scanner, ControladorAnimal animalControlador, 
			ControladorPessoa pessoaControlador) throws ErroAoRemoverException, ErroAoSalvarException,
			ObjectNaoExisteException, ObjectJaExisteException, ErroAoAtualizarException{
		char op2;
		do{
			System.out.println("\n########################## Cliente ##########################");
			System.out.print("\t1.Cadastrar\n"
					+ "\t2.Remover\n"
					+ "\t3.Atualizar\n"
					+ "\t4.Pesquisar\n"
					+ "\t5.Listar\n"
					+ "\t6.Sair");
			System.out.println("\n#############################################################\n");
			System.out.print("Opcao: ");
			op2 = getChar(scanner);

			switch (op2) {
			case '1':
				cadastrarCliente(scanner, animalControlador, pessoaControlador);
				break;

			case '2':
				removerCliente(scanner, pessoaControlador);	
				break;
			case '3':
				atualizarCliente(scanner, pessoaControlador, animalControlador);
				break;

			case '4': 
				pesquisarCliente(scanner, pessoaControlador);
				break;

			case '5':
				listarClientes(pessoaControlador);
				break;

			case '6': 
				break;
			default:
				System.out.println("Opcao Invalida\n");
				break;
			}
		}while(op2 != '6');
	}

	private static void listarClientes(ControladorPessoa pessoaControlador) {
		System.out.println(pessoaControlador.listarCLiente());
	}

	private static void pesquisarCliente(Scanner scanner, ControladorPessoa pessoaControlador) 
		throws ObjectNaoExisteException{
		String cpf;
		System.out.print("Informe o CPF: ");
		cpf = scanner.nextLine();
		try{
			Pessoa cliente = pessoaControlador.buscar(cpf);			
			System.out.println(((Cliente) cliente).toString());
		}catch(ObjectNaoExisteException | IllegalArgumentException E){
			System.out.println(E.getMessage());
		}
	}

	private static void atualizarCliente(Scanner scanner, ControladorPessoa pessoaControlador,
			ControladorAnimal animalControlador) throws ObjectNaoExisteException, ErroAoAtualizarException{
		char op3;
		String cpf;
		String rua;
		String complemento;
		String cidadeUF;
		String cep;
		String raca;
		String especie;
		float peso;
		float h;
		short numero;
		
		Endereco end;
		
		System.out.print("Digite o cpf do cliente: ");
		cpf = scanner.nextLine();

		try{
			Pessoa cliente  = pessoaControlador.buscar(cpf);
			
			System.out.print("\t1.Adicionar pets a um cliente\n"
					+ "\t2.Atualizar pets do cliente\n"
					+ "\t3.Mudar endereco\n"
					+ "\t4.Sair\nOpcao: ");
			op3 = getChar(scanner);
			switch(op3){
			case '1':
				System.out.print("Quantos pets deseja adicionar?");
				char op4 = getChar(scanner);
				for (int j = 0; j < Integer.parseInt(Character.toString(op4)); j++) {
					System.out.print("Digite a raca: ");
					raca = scanner.nextLine();
					System.out.print("Digite a especie: ");
					especie = scanner.nextLine();
					System.out.print("Digite o peso do animal: ");
					peso = Float.parseFloat(scanner.nextLine());
					System.out.print("Digite a altura do animal: ");
					h = Float.parseFloat(scanner.nextLine());
					System.out.print("Digite o nome do pet: ");
					String nomePet = scanner.nextLine();
					System.out.println("Digite o codigo do pet");
					String codigoPet = scanner.nextLine();
					Animal novo = new Animal(true, especie, raca, cliente, peso, h, nomePet,codigoPet);

					try {
						animalControlador.cadastrar(novo);
					} catch (ObjectJaExisteException e) {
						System.out.println(e.getMessage());
					}
					((Cliente) cliente).addPet(novo);
				}
				try{
					pessoaControlador.atualizar(cliente);
				}catch(ErroAoAtualizarException | IllegalArgumentException E){
					System.out.println(E.getMessage());
				}
				break;
			case '2':
				break;
			case '3':
				System.out.print("Digite o nome da rua: ");
				rua = scanner.nextLine();
				System.out.print("Digite o complemento: ");
				complemento = scanner.nextLine();
				System.out.print("Digite o numero da casa: ");
				numero = getShort(scanner);
				System.out.print("Digite o cep: ");
				cep = scanner.nextLine();
				System.out.print("Digite a cidade-UF: ");
				cidadeUF = scanner.nextLine();

				end = new Endereco(rua, complemento, numero, cep, cidadeUF);
				((Cliente) cliente).setEnd(end);
				try{
					pessoaControlador.atualizar(cliente);					
				}catch(ErroAoAtualizarException | IllegalArgumentException E){
					System.out.println(E.getMessage());
				}
				break;
			default:
				System.out.println("Opcao invalida\n");
				break;
			}
		}catch(ObjectNaoExisteException | IllegalArgumentException E){
			System.out.println(E.getMessage());
		}
	}

	private static void removerCliente(Scanner scanner, ControladorPessoa pessoaControlador)
		throws ObjectNaoExisteException, ErroAoRemoverException{
		String cpf;
		try{
			System.out.print("Digite o cpf do cliente: ");
			cpf = scanner.nextLine();
			pessoaControlador.remover(cpf);
		}catch(IllegalArgumentException | ObjectNaoExisteException | ErroAoRemoverException E){
			System.out.println(E.getMessage());
		}
	}

	private static void cadastrarCliente(Scanner scanner,ControladorAnimal animalControlador, 
			ControladorPessoa pessoaControlador) throws ObjectNaoExisteException, ObjectJaExisteException, ErroAoSalvarException {
		char op3;
		String cpf;
		String nome;
		LocalDate data;
		String rua;
		String complemento;
		String cidadeUF;
		String cep;
		String raca;
		String especie;
		float peso;
		float h;
		short numero;
		
		Endereco end;
		Pessoa cliente;
		
		System.out.print("\nDigite o nome do cliente: ");
		nome = scanner.nextLine();
		System.out.print("Digite o CPF: ");
		cpf = scanner.nextLine();
		System.out.print("Digite a data de nascimento do cliente (dd-mm-aaaa): ");
		data = getData(scanner);
	
		System.out.print("Digite o nome da rua: ");
		rua = scanner.nextLine();
		System.out.print("Digite o complemento: ");
		complemento = scanner.nextLine();
		System.out.print("Digite o numero da casa: ");
		numero = getShort(scanner);
		System.out.print("Digite o cep: ");
		cep = scanner.nextLine();
		System.out.print("Digite a cidade-UF: ");
		cidadeUF = scanner.nextLine();

		end = new Endereco(rua, complemento, numero, cep, cidadeUF);
		cliente = new Cliente(cpf, data, nome,end);
		System.out.println("\n" + cliente);

		System.out.print("Deseja cadastrar um PET agora? "
				+ "\n\t1.Sim"
				+ "\n\t2.Nao\nOpcao: ");
		op3 = getChar(scanner);

		if (op3 == '1') {
			System.out.print("Quantos pets deseja adicionar?: ");
			op3 = getChar(scanner);

			Animal[] pets = new Animal[Integer.parseInt(Character.toString(op3))];
			for (int j = 0; j < pets.length; j++) {
				System.out.print("Digite a raca: ");
				raca = scanner.nextLine();
				System.out.print("Digite a especie: ");
				especie = scanner.nextLine();
				System.out.print("Digite o peso do animal: ");
				peso = Float.parseFloat(scanner.nextLine());								
				System.out.print("Digite a altura do animal: ");
				h = Float.parseFloat(scanner.nextLine());
				System.out.print("Digite o nome do pet: ");
				String nomePet = scanner.nextLine();

				System.out.print("Digite o codigo do pet");
				String codigoPet = scanner.nextLine();
		
				Animal novo = new Animal(true, especie, raca, (Cliente) cliente, peso, h, nomePet,codigoPet);
				try {
					animalControlador.cadastrar(novo);
				} catch (ObjectJaExisteException e) {
					System.out.println(e.getMessage());
				}
				
				((Cliente) cliente).addPet(novo);
			}
		}
		try{
			pessoaControlador.cadastrar(cliente);
		}catch(IllegalArgumentException | ErroAoSalvarException | ObjectJaExisteException E){
			System.out.println(E.getMessage());
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		ControladorAnimal animalControlador = new ControladorAnimal(RepositorioAnimal.getInstance());
		ControladorProduto produtoControlador = new ControladorProduto(RepositorioProduto.getInstance());
		ControladorPessoa pessoaControlador = new ControladorPessoa(RepositorioPessoa.getInstance());
		boolean ok = true;
		/*do{
			ok = login(pessoaControlador, scanner);
		}while(ok);*/
		menu(scanner, animalControlador, produtoControlador, pessoaControlador);		
		scanner.close();
	}
	private static boolean login(ControladorPessoa pessoaControlador, Scanner scanner) {
		System.out.print("Digite o login: ");
		String login = scanner.nextLine();
		System.out.print("Digite a senha: ");
		int senha = getInt(scanner);
		boolean ok = pessoaControlador.login(login, senha);
		if(ok == true){
			System.out.println("Bem vindo " + login);
		}else{
			System.out.println("Login invalido");
		}
		return !ok;
	}
}