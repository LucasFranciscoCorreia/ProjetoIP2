package br.ufrpe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.beans.Produto;
import br.ufrpe.negocios.ControladorAnimal;
import br.ufrpe.negocios.ControladorCliente;
import br.ufrpe.negocios.ControladorFuncionario;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.negocios.ControladorProduto;

public class Principal {

	private static void menu(Scanner scanner, ControladorCliente clienteControlador,
			ControladorAnimal animalControlador, ControladorProduto produtoControlador,
			ControladorFuncionario funcionarioControlador, ControladorPessoa pessoaControlador) {
		char op;
		do {
			System.out.print("########################## MENU ##########################\n");
			System.out.print("\t1.Cliente\n"
					+ "\t2.Animal\n"
					+ "\t3.Produto\n"
					+ "\t4.Funcionario\n"
					+ "\t5.Pessoa\n"
					+ "\t6.Sair");
			System.out.println("\n#######################################################\n");
			System.out.println("Opcao: ");
			op = scanner.nextLine().charAt(0);
			switch (op) {
			case '1':
				menuCliente(scanner, clienteControlador, animalControlador, pessoaControlador);
				break;
			case '2':
				menuAnimal(scanner, clienteControlador, animalControlador);
				break;
			case '3':
				menuProduto(scanner, produtoControlador);
				break;
			case '4':
				menuFuncionario(scanner, funcionarioControlador, pessoaControlador);
				break;
			case '5':
				menuPessoa(scanner, pessoaControlador);
				break;
			case '6':
				System.exit(0);
				break;
			default:
				System.out.println("\n\n----------Opcao Invalida----------\n");
				break;
			}
		} while (op != 5);
	}

	private static void menuPessoa(Scanner scanner, ControladorPessoa pessoaControlador) {
		char op;
		do{
			System.out.print("########################## MENU ##########################\n");
			System.out.print("\t1.Pesquisar\n"
					+ "\t2.Listar\n"
					+ "\t3.Sair");
			System.out.println("\n#######################################################\n");
			System.out.println("Opcao: ");
			op = scanner.nextLine().charAt(0);
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
				System.out.println("Opção Invalida");
				break;
			}
		}while(op != '3');
	}

	private static void listarPessoa(ControladorPessoa pessoaControlador) {
		pessoaControlador.listar();
	}

	private static void pesquisarPessoa(String cpf, ControladorPessoa pessoaControlador) {
		Pessoa p = pessoaControlador.buscarPessoa(cpf);
		if (p != null) {
			System.out.println(p);
		}else{
			System.out.println("Pessoa nao encontrada");
		}
	}

	private static void menuFuncionario(Scanner scanner, ControladorFuncionario funcionarioControlador, ControladorPessoa pessoaControlador) {
		char op2;
		do{
			System.out.println("\n########################## Funcionario ##########################");
			System.out.print("\t1.Cadastrar\n"
					+ "\t2.Remover\n"
					+ "\t3.Atualizar\n"
					+ "\t4.Pesquisar\n"
					+ "\t5.Sair");
			System.out.println("\n#################################################################\n");

			System.out.println("Opcao: ");
			op2 = scanner.nextLine().charAt(0);

			switch (op2){
			case '1':
				cadastrarFuncionario(scanner, funcionarioControlador, pessoaControlador);
				break;

			case '2':
				removerFuncionario(scanner, funcionarioControlador, pessoaControlador);
				break;

			case '3':
				atualizarFuncionario(scanner, funcionarioControlador);
				break;

			case '4':
				pesquisarFuncionario(scanner, funcionarioControlador);
				break;
			case '5':
				break;
			default:
				System.out.println("\n\n----------Opcao Invalida----------\n");
				break;

			}
		}while(op2 != '5');
	}

	private static void pesquisarFuncionario(Scanner scanner, ControladorFuncionario funcionarioControlador) {
		String cpf;
		/*
		 * Funcionario
		 */
		System.out.println("Informe o cpf: ");
		cpf = scanner.nextLine();
		Funcionario f =funcionarioControlador.pesquisar(cpf); 
		if(f != null){
			System.out.println("\n\n" + f + "\n");
		}
	}

	private static void atualizarFuncionario(Scanner scanner, ControladorFuncionario funcionarioControlador) {
		char op3;
		String cpf;
		Funcionario funcionario;
		/*
		 * Atualizar
		 */
		System.out.print("Informe o CPF: ");
		cpf = scanner.nextLine();

		funcionario = funcionarioControlador.pesquisar(cpf);

		if(funcionario != null){
			System.out.print("\n1.Atualizar Endereco\n"
					+ "2.Atualizar Cargo\n"
					+ "3.Atualizar Salario\n"
					+ "\nOpcao: ");
			op3 = scanner.nextLine().charAt(0);

			switch(op3){
			case '1':
				atualizarEnderecoFuncionario(scanner, funcionarioControlador, funcionario);
				break;
			case '2':
				atualizarCargoFuncionario(scanner, funcionarioControlador, funcionario);

				break;
			case '3':
				atualizarSalarioFuncionario(scanner, funcionarioControlador, funcionario);
				break;
			default:
				System.out.println("\n\n----------Opcao Invalida----------\n");
				break;							
			}					
			funcionarioControlador.atualizar(funcionario);
		}
	}

	private static void atualizarSalarioFuncionario(Scanner scanner, ControladorFuncionario funcionarioControlador,
			Funcionario funcionario) {
		double salario;
		System.out.println("Informe o salario: ");
		salario = Double.parseDouble(scanner.nextLine());
		funcionario.setSalario(salario);
		funcionarioControlador.atualizar(funcionario);
	}

	private static void atualizarCargoFuncionario(Scanner scanner, ControladorFuncionario funcionarioControlador,
			Funcionario funcionario) {
		String cargo;
		System.out.println("Informe o cargo: ");
		cargo = scanner.nextLine();							
		funcionario.setCargo(cargo);
		funcionarioControlador.atualizar(funcionario);
	}

	private static void atualizarEnderecoFuncionario(Scanner scanner, ControladorFuncionario funcionarioControlador,
			Funcionario funcionario) {
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
		numero = Short.parseShort(scanner.nextLine());
		System.out.print("Digite o cep: ");
		cep = scanner.nextLine();
		System.out.print("Digite a cidade-UF: ");
		cidadeUF = scanner.nextLine();

		end = new Endereco(rua, complemento, numero, cep, cidadeUF);

		funcionario.setEnd(end);
		funcionarioControlador.atualizar(funcionario);
	}

	private static void removerFuncionario(Scanner scanner, ControladorFuncionario funcionarioControlador, ControladorPessoa pessoaControlador) {
		String cpf;
		System.out.print("Informe o CPF: ");
		cpf = scanner.nextLine();
		boolean ok = funcionarioControlador.remover(cpf);
		if (ok) {
			pessoaControlador.removerPessoa(cpf);
		}
	}

	private static void cadastrarFuncionario(Scanner scanner, ControladorFuncionario funcionarioControlador, ControladorPessoa pessoaControlador) {
		String cpf;
		String nome;
		String data;
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
		salario = Double.parseDouble(scanner.nextLine());
		System.out.print("Informe o cargo: ");
		cargo = scanner.nextLine();
		System.out.print("Informe a data de aniversario (dd-mm-aaaa): ");
		data = scanner.nextLine();

		DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate entrada = LocalDate.parse(data, DATE_FORMAT);

		System.out.print("Digite o nome da rua: ");
		rua = scanner.nextLine();
		System.out.print("Digite o complemento: ");
		complemento = scanner.nextLine();
		System.out.print("Digite o numero da casa: ");
		numero = Short.parseShort(scanner.nextLine());
		System.out.print("Digite o cep: ");
		cep = scanner.nextLine();
		System.out.print("Digite a cidade-UF: ");
		cidadeUF = scanner.nextLine();

		end = new Endereco(rua, complemento, numero, cep, cidadeUF);
		funcionario = new Funcionario(nome, cpf, end, salario, entrada, cargo);	
		funcionarioControlador.cadastrar((Funcionario) funcionario);
		pessoaControlador.cadastrarPessoa(funcionario);
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
			System.out.println("Opcao: ");
			op2 = scanner.nextLine().charAt(0);

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
		produto = produtoControlador.pesquisar(codigo);
		if(produto != null){
			System.out.println("\n" + produto + "\n");
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
		produto = produtoControlador.pesquisar(codigo);
		if(produto != null){
			nome = produto.getNome();
			System.out.println(nome);
			tipo = produto.getTipo();
			System.out.println(tipo);
			System.out.println("Informe o preco: ");
			preco = Float.parseFloat(scanner.nextLine());
			System.out.println("Informe a quantidade em estoque: ");
			estoque = Integer.parseInt(scanner.nextLine());

			Produto produtoNovo = new Produto(preco, nome, tipo, codigo, estoque);
			produtoControlador.atualizar(produtoNovo);
		}else{System.out.println("\n----------Produto nao existe----------\n");}
	}

	private static void removerProduto(Scanner scanner, ControladorProduto produtoControlador) {
		String codigo;
		/*
		 * Remover
		 */
		System.out.println("Informe o codigo: ");
		codigo = scanner.nextLine();				

		produtoControlador.remover(codigo);
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
		estoque = Integer.parseInt(scanner.nextLine());


		produto = new Produto(preco, nome, tipo, codigo, estoque);

		produtoControlador.cadastrar(produto);;
	}

	private static void menuAnimal(Scanner scanner, ControladorCliente clienteControlador,
			ControladorAnimal animalControlador) {
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
			op2 = scanner.nextLine().charAt(0);

			switch(op2){
			case '1':
				cadastrarAnimal(scanner, clienteControlador, animalControlador);
				break;
			case '2':
				removerAnimal(scanner, animalControlador);
				break;
			case '3':
				atualizarAnimal(scanner, clienteControlador, animalControlador);
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
		Animal a = animalControlador.buscar(codigo);
		if (a != null) {
			System.out.println(a);
		}
	}

	private static void atualizarAnimal(Scanner scanner, ControladorCliente clienteControlador,
			ControladorAnimal animalControlador) {
		char op3;
		String cpf;
		String codigo;
		float peso;
		float h;
		System.out.println("Digite o codigo do animal: ");
		codigo = scanner.nextLine();
		Animal a = animalControlador.buscar(codigo);
		if (a != null) {
			System.out.print("\t1.Adicionar novo dono\n"
					+ "\t2.Remover dono\n"
					+ "\t3.Mudar estatisticas\n"
					+ "\t4.Sair\nOpcao: ");
			op3 = scanner.nextLine().charAt(0);
			if (op3 == '1') {
				if (a.getDonoCPF() == null) {
					System.out.print("Digite o cpf do cliente: ");
					cpf = scanner.nextLine();
					Cliente c = (Cliente) clienteControlador.buscar(cpf);
					if (c != null) {
						a.setDono(c);
					}else{
						System.out.println("Cliente nao encontrado");
					}
				}else{
					System.out.println("Pet ja pertence a alguém");
				}
			}else if (op3 == '2') {
				System.out.println("Digite o codigo do animal:");
				codigo = scanner.nextLine();
				a = animalControlador.buscar(codigo);
				if (a != null) {
					if (a.getDonoCPF() == null) {
						System.out.println("Animal ja nao possui dono");
					}else{
						a.setDono(null);
					}
				}else{
					System.out.println("Animal nao encontrado");
				}
			}else if(op3 == '3'){
				System.out.println("Digite o codigo do animal: ");
				codigo = scanner.nextLine();
				a = animalControlador.buscar(codigo);
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

	private static void removerAnimal(Scanner scanner, ControladorAnimal animalControlador) {
		String codigo;
		System.out.print("Digite o codigo do animal: ");
		codigo = scanner.nextLine();
		animalControlador.remover(codigo);
	}

	private static void cadastrarAnimal(Scanner scanner, ControladorCliente clienteControlador,
			ControladorAnimal animalControlador) {
		char op3;
		String raca;
		String especie;
		float peso;
		float h;
		System.out.println("Cadastrar dono: ");
		System.out.print("\t1.Sim"
				+ "\n\t2.Nao"
				+ "\n\nOpcao: ");
		op3 = scanner.nextLine().charAt(0);

		if(op3 == '1'){
			System.out.print("Informe o cpf: ");
			String cpfD = scanner.nextLine();

			Cliente dono = (Cliente) clienteControlador.buscar(cpfD);
			if (dono != null) {
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
				animalControlador.cadastrar(novo);
			}else{
				System.out.println("Cliente nao encontrado");
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
			animalControlador.cadastrar(novo);
		}else{
			System.out.println("Opcao invalida\n");
		}
	}

	private static void menuCliente(Scanner scanner, ControladorCliente clienteControlador,
			ControladorAnimal animalControlador, ControladorPessoa pessoaControlador) {
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
			op2 = scanner.nextLine().charAt(0);

			switch (op2) {
			case '1':
				cadastrarCliente(scanner, clienteControlador, animalControlador, pessoaControlador);
				break;

			case '2':
				removerCliente(scanner, clienteControlador, pessoaControlador);					
				break;
			case '3':
				atualizarCliente(scanner, clienteControlador, animalControlador);
				break;

			case '4': 
				pesquisarCliente(scanner, clienteControlador);
				break;

			case '5':
				listarClientes(clienteControlador);
				break;

			case '6': 

				break;
			default:
				System.out.println("Opcao Invalida\n");
				break;
			}
		}while(op2 != '6');
	}

	private static void listarClientes(ControladorCliente clienteControlador) {
		clienteControlador.listar();
	}

	private static void pesquisarCliente(Scanner scanner, ControladorCliente clienteControlador) {
		String cpf;
		System.out.print("Informe o CPF: ");
		cpf = scanner.nextLine();
		Cliente c =(Cliente) clienteControlador.buscar(cpf);
		if (c!= null) {
			System.out.println(c);
		}
	}

	private static void atualizarCliente(Scanner scanner, ControladorCliente clienteControlador,
			ControladorAnimal animalControlador) {
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

		Cliente cliente  = clienteControlador.buscar(cpf);

		if(cliente != null){
			System.out.print("\t1.Adicionar pets a um cliente\n"
					+ "\t2.Atualizar pets do cliente\n"
					+ "\t3.Mudar endereco\n"
					+ "\t4.Sair\nOpcao: ");
			op3 = scanner.nextLine().charAt(0);
			switch(op3){
			case '1':
				System.out.print("Quantos pets deseja adicionar?");
				char op4 = scanner.nextLine().charAt(0); 
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

					animalControlador.cadastrar(novo);
					cliente.addPet(novo);
				}
				clienteControlador.atualizar(cliente);
				break;
			case '2':
				break;
			case '3':
				System.out.print("Digite o nome da rua: ");
				rua = scanner.nextLine();
				System.out.print("Digite o complemento: ");
				complemento = scanner.nextLine();
				System.out.print("Digite o numero da casa: ");
				numero = Short.parseShort(scanner.nextLine());
				System.out.print("Digite o cep: ");
				cep = scanner.nextLine();
				System.out.print("Digite a cidade-UF: ");
				cidadeUF = scanner.nextLine();

				end = new Endereco(rua, complemento, numero, cep, cidadeUF);
				cliente.setEnd(end);
				clienteControlador.atualizar(cliente);
				break;
			default:
				System.out.println("Opcao invalida\n");
				break;
			}
		}else{System.out.println("Cliente nao encontrado\n");}
	}

	private static void removerCliente(Scanner scanner, ControladorCliente clienteControlador, ControladorPessoa pessoaControlador) {
		String cpf;
		System.out.print("Digite o cpf do cliente: ");
		cpf = scanner.nextLine();
		boolean ok = clienteControlador.remover(cpf);
		if (ok) {
			pessoaControlador.removerPessoa(cpf);		
		}
	}

	private static void cadastrarCliente(Scanner scanner, ControladorCliente clienteControlador,
			ControladorAnimal animalControlador, ControladorPessoa pessoaControlador) {
		char op3;
		String cpf;
		String nome;
		String data;
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
		data = scanner.nextLine();

		DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate aniversario = LocalDate.parse(data, DATE_FORMAT);
		/*
		 * Endereco:
		 */
		System.out.print("Digite o nome da rua: ");
		rua = scanner.nextLine();
		System.out.print("Digite o complemento: ");
		complemento = scanner.nextLine();
		System.out.print("Digite o numero da casa: ");
		String linha = scanner.nextLine();
		numero = Short.parseShort(linha);
		System.out.print("Digite o cep: ");
		cep = scanner.nextLine();
		System.out.print("Digite a cidade-UF: ");
		cidadeUF = scanner.nextLine();

		end = new Endereco(rua, complemento, numero, cep, cidadeUF);
		cliente = new Cliente(cpf, aniversario, nome,end);
		System.out.println(cliente);

		System.out.print("Deseja cadastrar um PET agora? "
				+ "\n\t1.Sim"
				+ "\n\t2.Nao\nOpcao: ");
		op3 = scanner.nextLine().charAt(0);

		if (op3 == '1') {
			System.out.print("Quantos pets deseja adicionar?: ");
			op3 = scanner.nextLine().charAt(0);

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

				System.out.print("Digite o c�digo do pet");
				String codigoPet = scanner.nextLine();
				Animal novo = new Animal(true, especie, raca, (Cliente) cliente, peso, h, nomePet,codigoPet);
				animalControlador.cadastrar(novo);
				((Cliente) cliente).addPet(novo);
			}
		}
		clienteControlador.cadastrar((Cliente) cliente);
		pessoaControlador.cadastrarPessoa(cliente);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ControladorCliente clienteControlador = new ControladorCliente();
		ControladorAnimal animalControlador = new ControladorAnimal();
		ControladorProduto produtoControlador = new ControladorProduto();
		ControladorFuncionario funcionarioControlador = new ControladorFuncionario();
		ControladorPessoa pessoaControlador = new ControladorPessoa();

		menu(scanner, clienteControlador, animalControlador, produtoControlador, funcionarioControlador,pessoaControlador);
		scanner.close();
	}
}