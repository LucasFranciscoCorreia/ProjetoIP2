package br.ufrpe.test;

import java.time.LocalDate;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.beans.Endereco;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.PessoaJaCadastradaException;
import br.ufrpe.excecoes.PessoaNaoExisteException;
import br.ufrpe.negocios.ControladorPessoa;
import br.ufrpe.repositorios.RepositorioPessoa;

public class testCliente {
	public static void main(String[] args) {
		LocalDate aniversario = LocalDate.of(1996, 7, 26);
		Endereco end = new Endereco();
		ControladorPessoa clienteControlador = new ControladorPessoa(RepositorioPessoa.getInstance());
		Pessoa c1 = new Cliente("101.575.184-93", aniversario, "Lucas", end);
		Pessoa  c2 = new Cliente("101.575.184-93", aniversario, "Lucas", end);
		aniversario = LocalDate.now();
		Pessoa c3 = new Cliente("103.364.574-56", aniversario,  "Maria", end);

		System.out.println("**Equals**");
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
		System.out.println();

		System.out.println("**Cadastrar**");
		System.out.println();
		try {
			clienteControlador.cadastrar(c1);
		} catch (PessoaNaoExisteException | ErroAoSalvarException | PessoaJaCadastradaException e) {
			System.out.println(e.getMessage());
		}
		try {
			clienteControlador.cadastrar(c2);
		} catch (PessoaNaoExisteException | ErroAoSalvarException | PessoaJaCadastradaException e) {
			System.out.println(e.getMessage());
		}
		try {
			clienteControlador.cadastrar(c3);
		} catch (PessoaNaoExisteException | ErroAoSalvarException | PessoaJaCadastradaException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("**Apresentar**");

		try {
			clienteControlador.buscar("101.575.184-93");
		} catch (PessoaNaoExisteException e) {
			System.out.println(e.getMessage());
		}
		try {
			clienteControlador.buscar("1232152354");
		} catch (PessoaNaoExisteException e) {
			System.out.println(e.getMessage());
		}


		System.out.println("**Remover**");
		try {
			clienteControlador.remover("101.575.184-93");
		} catch (PessoaNaoExisteException | ErroAoRemoverException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
		try {
			clienteControlador.remover("1234123");
		} catch (PessoaNaoExisteException | ErroAoRemoverException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("**apresentar**");

		try {
			clienteControlador.buscar("101.575.184-93");
		} catch (PessoaNaoExisteException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

		System.out.println("**Atualizar**");

		c2 = new Cliente("563.642.624-78", aniversario, "Raissa", end);
		System.out.println();
		try {
			clienteControlador.buscar("563.642.624-78");
		} catch (PessoaNaoExisteException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();

	}
}
