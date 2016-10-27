package br.ufrpe.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.exce�oes.ClienteInvalidoException;
import br.ufrpe.exce�oes.ClienteJaExisteException;
import br.ufrpe.exce�oes.ClienteNaoEncontradoException;
import br.ufrpe.exce�oes.ClienteNaoExisteException;
import br.ufrpe.exce�oes.ParametroInvalidoException;
import br.ufrpe.negocios.ControladorCliente;
import br.ufrpe.repositorios.RepositorioCliente;
public class testCliente {
	@SuppressWarnings("finally")
	public static LocalDate getData(){
		Scanner scanner = new Scanner(System.in);
		LocalDate aniversario = null;
		try{			
			String data = scanner.nextLine();
			DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			aniversario = LocalDate.parse(data, DATE_FORMAT);
		}catch(DateTimeParseException e){
			System.out.println("Digite uma data correspondente ao formato \"dia-mês-ano\"");
			aniversario = getData();
		}finally{
			return aniversario;
		}
	}
	public static void main(String[] args) {
		LocalDate i = getData();
		System.out.println(i);
		LocalDate aniversario = LocalDate.of(1996, 7, 26);
		Endereco end = new Endereco();
		ControladorCliente clienteControlador = new ControladorCliente(RepositorioCliente.getInstance());
		Cliente c1 = new Cliente("101.575.184-93", aniversario, "Lucas", end);
		Cliente c2 = new Cliente("101.575.184-93", aniversario, "Lucas", end);
		aniversario = LocalDate.now();
		Cliente c3 = new Cliente("103.364.574-56", aniversario,  "Maria", end);

		System.out.println("**Equals**");
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println();

		System.out.println("**Cadastrar**");
		System.out.println();
		try {
			clienteControlador.cadastrar(c1);
		} catch (ClienteJaExisteException | ClienteInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			clienteControlador.cadastrar(c2);
		} catch (ClienteJaExisteException | ClienteInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			clienteControlador.cadastrar(c3);
		} catch (ClienteJaExisteException | ClienteInvalidoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("**Apresentar**");

		try {
			clienteControlador.buscar("101.575.184-93");
		} catch (ClienteNaoEncontradoException | ParametroInvalidoException e) {
			System.out.println(e.getMessage());
		}
		try {
			clienteControlador.buscar("1232152354");
		} catch (ClienteNaoEncontradoException | ParametroInvalidoException e) {
			System.out.println(e.getMessage());
		}


		System.out.println("**Remover**");
		try {
			clienteControlador.remover("101.575.184-93");
		} catch (ClienteNaoExisteException | ClienteNaoEncontradoException | ClienteInvalidoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		try {
			clienteControlador.remover("1234123");
		} catch (ClienteNaoExisteException | ClienteNaoEncontradoException | ClienteInvalidoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("**apresentar**");

		try {
			clienteControlador.buscar("101.575.184-93");
		} catch (ClienteNaoEncontradoException | ParametroInvalidoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("**Atualizar**");

		c2 = new Cliente("563.642.624-78", aniversario, "Raissa", end);
		System.out.println();
		try {
			clienteControlador.buscar("563.642.624-78");
		} catch (ClienteNaoEncontradoException | ParametroInvalidoException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

	}
}
