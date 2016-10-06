package br.ufrpe;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.repositorios.RepositorioAnimal;
import br.ufrpe.repositorios.RepositorioCliente;
import br.ufrpe.repositorios.RepositorioFuncionario;
import br.ufrpe.repositorios.RepositorioProduto;

public class Principal {
	public static void main(String[] args) {
		int op = 0, op2 = 0, op3 = 0;
		Scanner scanner = new Scanner(System.in);
		
		RepositorioCliente clientes = RepositorioCliente.getInstance();
		RepositorioAnimal animais = RepositorioAnimal.getInstance();
		RepositorioProduto produtos = RepositorioProduto.getInstance();
		RepositorioFuncionario funcionarios = RepositorioFuncionario.getInstanciado();
		
		
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
					Endereco end;

					/*
					 * Cliente:
					 */
					System.out.print("\nDigite o nome do cliente: ");
					String nome = scanner.next();
					System.out.print("Digite o sobrenome do cliente: ");
					String sobrenome = scanner.next();
					System.out.print("Digite o CPF: ");
					String cpf = scanner.next();
					System.out.print("Digite a data de nascimento do cliente (dd-mm-aaaa): ");
					String data = scanner.next();
					
					DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate aniversario = LocalDate.parse(data, DATE_FORMAT);		
					

                    scanner.next();
					/*
					 * Endere�o:
					 */
					System.out.print("Digite o nome da rua: ");
					String rua = scanner.nextLine();
					System.out.print("Digite o complemento: ");
					String complemento = scanner.next();
					System.out.println("Digite o numero da casa: ");
					short numero = scanner.nextShort();
					System.out.print("Digite o cep: ");
					String cep = scanner.next();
					System.out.print("Digite a cidade-UF: ");
					String cidadeUF = scanner.nextLine();

					end = new Endereco(rua, complemento, numero, cep, cidadeUF);
					cliente = new Cliente(cpf, aniversario, nome, sobrenome, end);

					System.out.println("Deseja cadastrar um PET agora? \n\t1.Sim\n\t2.N�o");
					op3 = scanner.nextInt();

					if (op3 == 1) {
						System.out.println("Quantos pets deseja adicionar?");
						op3 = scanner.nextInt();

						Animal[] pets = new Animal[op3];

						for (int j = 0; j < pets.length; j++) {
							System.out.println("Digite a ra�a: ");
							String raca = scanner.nextLine();
							System.out.print("Digite a especie: ");
							String especie = scanner.nextLine();
							System.out.println("Digite o peso do animal: ");
							float peso = scanner.nextFloat();
							System.out.println("Digite a altura do animal: ");
							float h = scanner.nextFloat();

							Animal novo = new Animal(true, especie, raca, cliente, peso, h);

							animais.adicionar(novo);
							cliente.addPet(novo);
						}
					}
					
					System.out.println("Cliente cadastrado/n");
					clientes.cadastrar(cliente);
					break;
				case 2:
					System.out.println("Digite o cpf do cliente: ");
					String cpfR = scanner.nextLine();
					
					Cliente c = clientes.buscar(cpfR);
					
					if (c != null) {
						clientes.remover(c);
						System.out.println("Cliente removido\n");
					} else {
						System.out.println("Cliente nao encontrado\n");
					}
					break;
				case 3:
					/*
					 * Incompleto!!!
					 */
					System.out.println("\t1.Adicionar pets a um cliente\n"
							+ "\t2.Adicionar pets a loja\n"
							+ "\t3.Mudar endereco\n"
							+ "\t4.Sair");
					op3 = scanner.nextInt();
					
					break;
				
				case 4: 
					System.out.println("Informe o CPF: ");
					String cpfB = scanner.nextLine();
					
					System.out.println(clientes.buscar(cpfB).toString());
					break;
				default:
					System.out.println("Op��o Invalida\n");
					break;
				}
				break;
			case 2:
				/*
				 * Incompleto, precisa de um codigo para o animal!!!
				 */
				System.out.println("\n########################## Animal ##########################");
				System.out.print("\t1.Cadastrar\n"
						+ "\t2.Remover\n"
						+ "\t3.Atualizar\n"
						+ "\t4.Pesquisar\n"
						+ "\t5.Sair");
				System.out.println("\n############################################################\n");
				System.out.println("Opcao: ");
				op2 = scanner.nextInt();
				
				switch(op2){
				case 1:
					System.out.println("Cadastrar dono: ");
					System.out.println("\t1.Sim"
							+ "\n\t2.N�o"
							+ "\n\nOp��o: ");
					op3 = scanner.nextInt();
					
					if(op3 == 1){
						System.out.println("Informe o cpf: ");
						String cpfD = scanner.nextLine();
						
						Cliente dono = clientes.buscar(cpfD);
						
						System.out.println("Digite a ra�a: ");
						String raca = scanner.nextLine();
						System.out.print("Digite a especie: ");
						String especie = scanner.nextLine();
						System.out.println("Digite o peso do animal: ");
						float peso = scanner.nextFloat();
						System.out.println("Digite a altura do animal: ");
						float h = scanner.nextFloat();

						Animal novo = new Animal(true, especie, raca, dono, peso, h);
						animais.adicionar(novo);
					}else if(op3 == 2){
						System.out.println("Digite a ra�a: ");
						String raca = scanner.nextLine();
						System.out.print("Digite a especie: ");
						String especie = scanner.nextLine();
						System.out.println("Digite o peso do animal: ");
						float peso = scanner.nextFloat();
						System.out.println("Digite a altura do animal: ");
						float h = scanner.nextFloat();

						Animal novo = new Animal(true, especie, raca, null, peso, h);
						animais.adicionar(novo);
					}else{
						System.out.println("Op��o invalida\n");
					}
					
				}
			
			case 3:
				System.out.println("\n########################## Produto ##########################");
				System.out.print("\t1.Cadastrar\n"
						+ "\t2.Remover\n"
						+ "\t3.Atualizar\n"
						+ "\t4.Pesquisar\n"
						+ "\t5.Sair");
				System.out.println("\n#############################################################\n");
				System.out.println("Opcao: ");
				op2 = scanner.nextInt();
			
			case 4:
				System.out.println("\n########################## Funcionario ##########################");
				System.out.print("\t1.Cadastrar\n"
						+ "\t2.Remover\n"
						+ "\t3.Atualizar\n"
						+ "\t4.Pesquisar\n"
						+ "\t5.Sair");
				System.out.println("\n#################################################################\n");
				System.out.println("Opcao: ");
				op2 = scanner.nextInt();
			default:
				break;
			}
		} while (op != 5);
	}
}
