package br.ufrpe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.ufrpe.beans.*;
import br.ufrpe.repositorios.*;

public class Principal {
	public static void main(String[] args) {
		int op = 0, op2 = 0, op3 = 0;
		String cpf, nome, sobrenome, data, tipo, codigo;
		String rua, complemento, cidadeUF, cep;
		String raca, especie;
		float peso, h;
		short numero;
		Endereco end;
		Scanner scanner = new Scanner(System.in);
		
		RepositorioCliente clienteRepositorio = RepositorioCliente.getInstance();
		RepositorioAnimal animalRepositorio = RepositorioAnimal.getInstance();
		RepositorioProduto produtoRepositorio = new RepositorioProduto();
		RepositorioFuncionario funcionarioRepositorio = RepositorioFuncionario.getInstanciado();
		
		
		do {
			
			System.out.print("########################## MENU ##########################\n");
			System.out.print("\t1.Cliente\n"
					+ "\t2.Animal\n"
					+ "\t3.Produto\n"
					+ "\t4.Funcionario\n"
					+ "\t5.Sair");
			System.out.println("\n#######################################################\n");
			System.out.println("Opcao: ");
			op = scanner.nextInt();
			
			switch (op) {
			case 1:
				do{
					System.out.println("\n########################## Cliente ##########################");
					System.out.print("\t1.Cadastrar\n"
							+ "\t2.Remover\n"
							+ "\t3.Atualizar\n"
							+ "\t4.Pesquisar\n"
							+ "\t5.Sair");
					System.out.println("\n#############################################################\n");
					System.out.println("Opcao: ");
					op2 = scanner.nextInt();
					
					switch (op2) {
					case 1:
						Cliente cliente;
						/*
						 * Cliente:
						 */
						System.out.print("\nDigite o nome do cliente: ");
						nome = scanner.next();
						System.out.print("Digite o sobrenome do cliente: ");
						sobrenome = scanner.next();
						System.out.print("Digite o CPF: ");
						cpf = scanner.next();
						System.out.print("Digite a data de nascimento do cliente (dd-mm-aaaa): ");
						data = scanner.next();
						
						DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
						LocalDate aniversario = LocalDate.parse(data, DATE_FORMAT);
						/*
						 * Endereco:
						 */
						System.out.print("Digite o nome da rua: ");
						scanner.next();
						rua = scanner.nextLine();
						System.out.print("Digite o complemento: ");
						complemento = scanner.nextLine();
						System.out.print("Digite o numero da casa: ");
						numero = scanner.nextShort();
						System.out.print("Digite o cep: ");
						cep = scanner.next();
						System.out.print("Digite a cidade-UF: ");
						cidadeUF = scanner.nextLine();
	
						end = new Endereco(rua, complemento, numero, cep, cidadeUF);
						cliente = new Cliente(cpf, aniversario, nome, sobrenome, end);
	
						System.out.print("Deseja cadastrar um PET agora? "
								+ "\n\t1.Sim"
								+ "\n\t2.N�o");
						op3 = scanner.nextInt();
	
						if (op3 == 1) {
							System.out.print("Quantos pets deseja adicionar?");
							op3 = scanner.nextInt();
	
							Animal[] pets = new Animal[op3];
	
							for (int j = 0; j < pets.length; j++) {
								System.out.print("Digite a ra�a: ");
								scanner.next();
								raca = scanner.nextLine();
								System.out.print("Digite a especie: ");
								especie = scanner.nextLine();
								System.out.print("Digite o peso do animal: ");
								peso = scanner.nextFloat();
								System.out.print("Digite a altura do animal: ");
								h = scanner.nextFloat();
								System.out.print("Digite o nome do pet: ");
								String nomePet = scanner.nextLine();
								Animal novo = new Animal(true, especie, raca, cliente, peso, h, nomePet);
								animalRepositorio.adicionar(novo);
								cliente.addPet(novo);
							}
						}
						if(clienteRepositorio.buscar(cpf) == null){
							clienteRepositorio.cadastrar(cliente);
							System.out.println("Cliente cadastrado\n");
						}else{
							System.out.println("Erro!! Cliente ja � cadastrado no sistema\n");
						}
						break;
						
					case 2:
						System.out.println("Digite o cpf do cliente: ");
						cpf = scanner.nextLine();
					
						Cliente cliente2 = clienteRepositorio.buscar(cpf);
						
						if (cliente2 != null) {
							clienteRepositorio.remover(cliente2);
							System.out.println("Cliente removido com sucesso\n");
						} else {
							System.out.println("Cliente n�o encontrado\n");
						}
						break;
					case 3:
						/*
						 * Incompleto!!!
						 */
						
						System.out.println("Digite o cpf do cliente: ");
						cpf = scanner.nextLine();
						
						Cliente cliente3  = clienteRepositorio.buscar(cpf);
						
						if(cliente3 != null){
							System.out.println("\t1.Adicionar pets a um cliente\n"
									+ "\t2.Alterar pets do cliente\n"
									+ "\t3.Mudar endereco\n"
									+ "\t4.Sair");
							op3 = scanner.nextInt();
							
							switch(op3){
							case 1:
								System.out.print("Quantos pets deseja adicionar?");
								int op4 = scanner.nextInt();
	
								Animal[] pets = new Animal[op4];
	
								for (int j = 0; j < pets.length; j++) {
									System.out.print("Digite a ra�a: ");
									raca = scanner.nextLine();
									System.out.print("Digite a especie: ");
									especie = scanner.nextLine();
									System.out.print("Digite o peso do animal: ");
									peso = scanner.nextFloat();
									System.out.print("Digite a altura do animal: ");
									h = scanner.nextFloat();
									System.out.print("Digite o nome do pet: ");
									String nomePet = scanner.nextLine();
									Animal novo = new Animal(true, especie, raca, cliente3, peso, h, nomePet);
	
									animalRepositorio.adicionar(novo);
									cliente3.addPet(novo);
								}
								clienteRepositorio.remover(cliente3);
								clienteRepositorio.cadastrar(cliente3);
								break;
							case 2:
								/*
								 * Falta receber o animal do cliente: (incompleto)
								 */
								break;
							case 3:
								System.out.print("Digite o nome da rua: ");
								rua = scanner.nextLine();
								System.out.print("Digite o complemento: ");
								complemento = scanner.next();
								System.out.print("Digite o numero da casa: ");
								numero = scanner.nextShort();
								System.out.print("Digite o cep: ");
								cep = scanner.next();
								System.out.print("Digite a cidade-UF: ");
								cidadeUF = scanner.nextLine();
	
								end = new Endereco(rua, complemento, numero, cep, cidadeUF);
								cliente3.setEnd(end);
								
								clienteRepositorio.remover(cliente3);
								clienteRepositorio.cadastrar(cliente3);
								break;
							default:
								System.out.println("Op��o invalida\n");
								break;
							}
						}else{System.out.println("Cliente n�o encontrado\n");}
						break;
					
					case 4: 
						System.out.print("Informe o CPF: ");
						scanner.next();
						cpf = scanner.nextLine();
						
						System.out.println(clienteRepositorio.buscar(cpf).toString());
						break;
					default:
						System.out.println("Op��o Invalida\n");
						break;
					}
				}while(op2 != 5);
				break;
			case 2:
				do{
					/*
					 * Incompleto, precisa de um codigo para o animal!!
					 */
					System.out.println("\n########################## Animal ##########################");
					System.out.print("\t1.Cadastrar\n"
							+ "\t2.Remover\n"
							+ "\t3.Atualizar\n"
							+ "\t4.Pesquisar\n"
							+ "\t5.Sair");
					System.out.println("\n############################################################\n");
					System.out.print("Opcao: ");
					op2 = scanner.nextInt();
					
					switch(op2){
					case 1:
						System.out.println("Cadastrar dono: ");
						System.out.println("\t1.Sim"
								+ "\n\t2.Nao"
								+ "\n\nOpcao: ");
						op3 = scanner.nextInt();
						
						if(op3 == 1){
							System.out.print("Informe o cpf: ");
							String cpfD = scanner.nextLine();
							
							Cliente dono = clienteRepositorio.buscar(cpfD);
							
							System.out.println("Digite a raca: ");
							raca = scanner.nextLine();
							System.out.print("Digite a especie: ");
							especie = scanner.nextLine();
							System.out.print("Digite o peso do animal: ");
							peso = scanner.nextFloat();
							System.out.print("Digite a altura do animal: ");
							h = scanner.nextFloat();
							System.out.print("Digite o nome do pet: ");
							String nomePet = scanner.nextLine();
							Animal novo = new Animal(true, especie, raca, dono, peso, h, nomePet);
							animalRepositorio.adicionar(novo);
						}else if(op3 == 2){
							System.out.println("Digite a raca: ");
							raca = scanner.nextLine();
							System.out.print("Digite a especie: ");
							especie = scanner.nextLine();
							System.out.print("Digite o peso do animal: ");
							peso = scanner.nextFloat();
							System.out.print("Digite a altura do animal: ");
							h = scanner.nextFloat();
							System.out.print("Digite o nome do animal: ");
							String nomePet = scanner.nextLine();
							Animal novo = new Animal(true, especie, raca, null, peso, h, nomePet);
							animalRepositorio.adicionar(novo);
						}else{
							System.out.println("Op��o invalida\n");
						}
						break;
					case 2:
						/*
						 * Incompleto(Remover)
						 */
						break;
					case 3:
						/*
						 * Incompleto(Atualizar)
						 */
						break;
					case 4:
						/*
						 * Incompleto(Pesquisar)
						 */
						break;
					default:
						System.out.println("Op��o Invalida\n");
						break;
					}
				}while(op2 != 5);
				break;
			case 3:
				int estoque;
				float preco;
				do{
					System.out.println("\n########################## Produto ##########################");
					System.out.print("\t1.Cadastrar\n"
							+ "\t2.Remover\n"
							+ "\t3.Atualizar\n"
							+ "\t4.Pesquisar\n"
							+ "\t5.Sair");
					System.out.println("\n#############################################################\n");
					System.out.println("Opcao: ");
					op2 = scanner.nextInt();
					
					Produto produto;
					
					switch (op2){
					case 1:
						System.out.println("\nInforme o nome: ");
						nome = scanner.nextLine();
						scanner.next();
						System.out.println("Informe o tipo: ");
						tipo = scanner.nextLine();
						scanner.next();
						System.out.println("Informe o codigo: ");
						codigo = scanner.nextLine();
						scanner.next();
						System.out.println("Informe o preco: ");
						preco = scanner.nextFloat();
						System.out.println("Informe a quantidade em estoque: ");
						estoque = scanner.nextInt();
						
						produto = new Produto(preco, nome, tipo, codigo, estoque);
						
						if(produtoRepositorio.buscar(codigo) == null){
							produtoRepositorio.adicionar(produto);
							System.out.println("\n----------Produto cadastrado com sucesso----------\n");
						}else{System.out.println("\n----------Erro!! Produto nao se encontra no sistema----------\n");}
						break;
					case 2:
						System.out.println("Informe o c�digo: ");
						codigo = scanner.nextLine();
						scanner.next();
						
						produto = produtoRepositorio.buscar(codigo);
						if(produto != null){
							produtoRepositorio.remover(produto);
							System.out.println("\n----------Produto removido com sucesso----------\n");
						}else{System.out.println("\n----------Produto nao existe----------\n");}
						break;
					case 3:
						System.out.println("Informe o codigo: ");
						codigo = scanner.nextLine();
						scanner.next();
						
						produto = produtoRepositorio.buscar(codigo);
								
						if(produto != null){
							nome = produto.getNome();
							tipo = produto.getTipo();
							System.out.println("Informe o pre�o: ");
							preco = scanner.nextFloat();
							System.out.println("Informe a quantidade em estoque: ");
							estoque = scanner.nextInt();
							
							Produto produtoNovo = new Produto(preco, nome, tipo, codigo, estoque);
							produtoRepositorio.atualizar(produto, produtoNovo);
							System.out.println("\n----------Produto atualizado----------\n");
						}else{System.out.println("\n----------Produto n�o existe----------\n");}
						break;
					case 4:
						/*
						 * Erro!!!
						 */
						System.out.println("Informe o c�digo: ");
						codigo = scanner.nextLine();
						scanner.next();
						
						produto = produtoRepositorio.buscar(codigo);
						if(produto != null){
							System.out.println("\n" + produto + "\n");
						}else{System.out.println("\n----------Produto nao existe----------\n");}
						break;
					default:
						System.out.println("\n----------Opcao Invalida----------");
						break;
					}
				}while(op2 != 5);
				break;
			case 4:
				double salario;
				String cargo, dataEntrada;
				Funcionario funcionario;
				
				do{
					System.out.println("\n########################## Funcionario ##########################");
					System.out.print("\t1.Cadastrar\n"
							+ "\t2.Remover\n"
							+ "\t3.Atualizar\n"
							+ "\t4.Pesquisar\n"
							+ "\t5.Sair");
					System.out.println("\n#################################################################\n");
					System.out.println("Opcao: ");
					op2 = scanner.nextInt();
					
					switch (op2){
					case 1:
						System.out.print("\nInforme o nome: ");
						nome = scanner.next();
						System.out.print("Informe o CPF: ");
						cpf = scanner.next();
						System.out.print("Informe o salario: ");
						salario = scanner.nextDouble();
						System.out.print("Informe o cargo: ");
						cargo = scanner.nextLine();
						scanner.next();
						System.out.print("Informe a entrada (dd-mm-aaaa): ");
						String entradaf = scanner.next();
						LocalDate entrada = LocalDate.now();
						
						//Esperando criar classe de cadastro
						//dataEntrada = scanner.next();
						
//						DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy/hh:mm");
//						LocalDate entrada = LocalDate.parse(dataEntrada, DATE_FORMAT);	
					
						System.out.print("Digite o nome da rua: ");
						scanner.next();
						rua = scanner.nextLine();
						System.out.print("Digite o complemento: ");
						complemento = scanner.next();
						System.out.print("Digite o numero da casa: ");
						numero = scanner.nextShort();
						System.out.print("Digite o cep: ");
						cep = scanner.next();
						System.out.print("Digite a cidade-UF: ");
						scanner.next();
						cidadeUF = scanner.nextLine();
	
						end = new Endereco(rua, complemento, numero, cep, cidadeUF);
						funcionario = new Funcionario(nome, cpf, end, salario, entrada, cargo);
						
						if(funcionarioRepositorio.cadastrar(funcionario)){
							System.out.println("\n\n----------Funcionario cadastrado com sucesso----------\n");
						}else{System.out.println("\n\n----------Funcionario ja cadastrado no sistema----------\n");}
						break;
					case 2:
						System.out.print("Informe o CPF: ");
						scanner.next();
						cpf = scanner.nextLine();
						
						if(funcionarioRepositorio.remover(cpf)){
							System.out.println("\n\n----------Funcionario removido com sucesso----------\n");
							break;
						}else{System.out.println("\n\n----------Funcionario nao encontrado----------\n");}
						break;
					case 3:
						/*
						 * Com problema!!!!
						 */
						System.out.print("Informe o CPF: ");
						scanner.next();
						cpf = scanner.nextLine();
						
						funcionario = funcionarioRepositorio.buscar(cpf);
						
						//Nao esta entrando
						if(funcionario != null){
							System.out.print("\n1.Atualizar endereco\n"
									+ "2.Atualizar Cargo\n"
									+ "3.Atualizar Salario\n"
									+ "\nOpcao: ");
							op3 = scanner.nextInt();
							
							switch(op3){
							case 1:
								System.out.print("Digite o nome da rua: ");
								rua = scanner.nextLine();
								System.out.print("Digite o complemento: ");
								complemento = scanner.next();
								System.out.print("Digite o numero da casa: ");
								numero = scanner.nextShort();
								System.out.print("Digite o cep: ");
								cep = scanner.next();
								System.out.print("Digite a cidade-UF: ");
								cidadeUF = scanner.nextLine();
	
								end = new Endereco(rua, complemento, numero, cep, cidadeUF);
								
								funcionario.setEndereco(end);
								break;
							case 2:
								System.out.println("Informe o cargo: ");
								cargo = scanner.nextLine();
								
								funcionario.setCargo(cargo);
								break;
							case 3:
								System.out.println("Informe o salario: ");
								salario = scanner.nextDouble();
								
								funcionario.setSalario(salario);
								break;
							default:
								System.out.println("\n\n----------Opcao Invalida----------\n");
								break;							
							}
							
							funcionarioRepositorio.atualizar(funcionario);
						}else{System.out.println("\n\n----------Funcionario nao encontrado----------\n");}
						break;
					case 4:
						/*
						 * Com problema!!!!!
						 */
						System.out.println("Informe o cpf: ");
						scanner.next();
						cpf = scanner.nextLine();
						
						//Passa direto para o else
						if(funcionarioRepositorio.buscar(cpf) != null){
							System.out.println("\n\n" + funcionarioRepositorio.buscar(cpf).toString() + "\n");
						}else{
							System.out.println("\n\n----------Funcionario nao cadastrado----------\n");
						}
						
						break;
					default:
						System.out.println("\n\n----------Opcao Invalida----------\n");
						break;
					}
				}while(op2 != 5);
				break;
			default:
				System.out.println("\n\n----------Opcao Invalida----------\n");
				break;
			}
		} while (op != 5);
	}
}
