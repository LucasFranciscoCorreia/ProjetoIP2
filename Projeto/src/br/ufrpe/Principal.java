package br.ufrpe;

import java.time.LocalDate;
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
		int op = 0;
		Scanner scanner = new Scanner(System.in);
		RepositorioCliente clientes = RepositorioCliente.getInstance();
		RepositorioAnimal animais = RepositorioAnimal.getInstance();
		RepositorioProduto produtos = RepositorioProduto.getInstance();
		RepositorioFuncionario funcionarios = RepositorioFuncionario.getInstanciado();
		do {
			System.out.print("1.Cliente\n2.Animal\n3.Produto\n4.Funcionario\n5.Sair\nOpcao: ");
			op = scanner.nextInt();
			switch (op) {
			case 1:
				System.out.print("1.Cadastrar\n2.Remover\n3.Atualizar\n4.Pesquisar\n5.Sair\nOpcao: ");
				int op2 = scanner.nextInt();
				switch (op2) {
				case 1:
					System.out.print("Deseja adicionar o endereco do cliente\n1.Sim\n2.Nao\nOpcao: ");
					int op3 = scanner.nextInt();
					Cliente cliente;
					if (op3 == 1) {
						Endereco end;
						System.out.print("Digite o nome do cliente: ");
						String nome = scanner.next();
						System.out.print("Digite o sobrenome do cliente: ");
						String sobrenome = scanner.next();
						System.out.print("Digite o CPF: ");
						String cpf = scanner.next();
						System.out.print("Digite a data de nascimento do cliente: ");
						String data = scanner.nextLine();
						LocalDate aniversario;
						int dia = 0, mes = 0, ano = 0;
						String aux = "";
						int cont = 0, i = 0;
						;
						while (cont < 3) {
							char[] aux2 = data.toCharArray();
							while (aux2[i] != '/') {
								aux += aux2;
							}
							if (cont == 0) {
								dia = Integer.parseInt(aux);
								aux = "";
							} else if (cont == 1) {
								mes = Integer.parseInt(aux);
								aux = "";
							} else {
								ano = Integer.parseInt(aux);
							}
						}
						aniversario = LocalDate.of(ano, mes, dia);
						System.out.print("Digite o nome da rua: ");
						String rua = scanner.nextLine();
						System.out.print("Digite o complemento: ");
						String complemento = scanner.nextLine();
						System.out.println("Digite o numero da casa: ");
						short numero = scanner.nextShort();
						System.out.print("Digite o cep: ");
						String cep = scanner.nextLine();
						System.out.print("Digite a cidade-UF: ");
						String cidadeUF = scanner.nextLine();
						end = new Endereco(rua, complemento, numero, cep, cidadeUF);
						cliente = new Cliente(cpf, aniversario, nome, sobrenome, end);
						System.out.println("Deseja cadastrar um PET agora? \n1.Sim\n2.Não");
						op3 = scanner.nextInt();
						if (op3 == 1) {
							System.out.println("Quantos pets deseja adicionar?");
							op3 = scanner.nextInt();
							Animal[] pets = new Animal[op3];
							for (int j = 0; j < pets.length; j++) {
								System.out.println("Digite a raça: ");
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
						clientes.cadastrar(cliente);
					}
					break;
				case 2:
					System.out.println("Digite o cpf do cliente: ");
					String cpf = scanner.nextLine();
					Cliente c = clientes.buscar(cpf);
					if (c != null) {
						clientes.remover(c);
					} else {
						System.out.println("Cliente nao encontrado");
					}
					break;
				case 3:
					System.out.println("1.Adicionar pets a um cliente\n2.Adicionar pets a loja\n3.Mudar endereco\n4.Sair");
					op3 = scanner.nextInt();
					break;
				default:
					break;
				}
				break;

			default:
				break;
			}
		} while (op != 5);
	}
}
