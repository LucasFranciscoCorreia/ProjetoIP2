package br.ufrpe.test;

import java.time.LocalDate;
import java.util.Scanner;

import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.negocios.ControladorFuncionario;
import br.ufrpe.repositorios.RepositorioFuncionario;

public class testFuncionario {
	public static void main(String[] args) {
		Endereco end1 = new Endereco();
		LocalDate entrada = LocalDate.now();
		ControladorFuncionario controlador = new ControladorFuncionario(RepositorioFuncionario.getInstance());
		
		Funcionario f1 = new Funcionario("Lucas", "101.575.184-93", end1, 3499.5, entrada, "Balconista");
		Funcionario f2 = new Funcionario("Lucas", "101.575.184-93", end1, 3499.5, entrada, "Balconista");
		Funcionario f3 = new Funcionario("Fernanda", "103.364.574-56", end1, 7845.5, entrada, "Gerente");
		Funcionario f4 = new Funcionario("Raissa", "563.642.624-78", end1, 8799.5, entrada, "Recepcionista");
		
		System.out.println("************Equals************\n");
		System.out.println("Equals f1 e f2: " + f1.equals(f2));
		System.out.println("equals f1 e f3: " + f1.equals(f3));
		
		System.out.println("\n\n************Adicionar ao Repositorio************\n");
		controlador.cadastrar(f1);
		controlador.cadastrar(f2);
		controlador.cadastrar(f3);
		controlador.cadastrar(f4);
		
		System.out.println("\n\n************Atualiza��o************\n");
		
		f1.setCargo("Veterinario");
		f1.setSalario(8499f);
		controlador.atualizar(f1);
		
//		System.out.println("\n\n************Imprimir todos os cadastrados************\n");
//		System.out.printl
//		
//		System.out.println("\n\n************Remover************\n");
//		controlador.remover("101.575.184-93");
//		
//		System.out.println("\n\n************Imprimir todos os cadastrados************\n");
//		controlador.listarFuncionarios();
	}
}