package br.ufrpe.test;

import java.time.LocalDateTime;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.repositorios.RepositorioFuncionario;

public class testFuncionario {
	public static void main(String[] args) {
		Endereco end1 = new Endereco();
		LocalDateTime entrada = LocalDateTime.now();
		RepositorioFuncionario repositorio = RepositorioFuncionario.getInstanciado();
		
		Funcionario f1 = new Funcionario("Lucas", "101.575.184-93", end1, 3499f, entrada, "Balconista");
		Funcionario f2 = new Funcionario("Lucas", "101.575.184-93", end1, 3499f, entrada, "Balconista");
		Funcionario f3 = new Funcionario("Fernanda", "103.364.574-56", end1, 7845f, entrada, "Gerente");
		Funcionario f4 = new Funcionario("Raissa", "563.642.624-78", end1, 8799f, entrada, "Recepcionista");
		
		System.out.println("************Equals************\n");
		System.out.println("Equals f1 e f2: " + f1.equals(f2));
		System.out.println("equals f1 e f3: " + f1.equals(f3));
		
		System.out.println("\n\n************Adicionar ao Repositorio************\n");
		System.out.println("f1 adicionar = " + repositorio.cadastrar(f1));
		System.out.println("f2 adicionar = " + repositorio.cadastrar(f2));
		System.out.println("f3 adicionar = " + repositorio.cadastrar(f3));
		System.out.println("f4 adicionar = " + repositorio.cadastrar(f4));
		
		System.out.println("\n\n************Atualização************\n");
		
		f1.setCargo("Veterinario");
		f1.setSalario(8499f);
		System.out.println("f1 atualizado = " + repositorio.atualizar(f1));
		
		System.out.println("\n\n************Imprimir todos os cadastrados************\n");
		for (int i = 0; i < repositorio.Size(); i++) {
			System.out.println(repositorio.buscar(i) + "\n");
		}
		
		System.out.println("\n\n************Remover************\n");
		System.out.println("Remover f1 = " + repositorio.remover("101.575.184-93"));
		
		System.out.println("\n\n************Imprimir todos os cadastrados************\n");
		for(int i = 0; i < repositorio.Size(); i++){
			System.out.println(repositorio.buscar(i) + "\n");
		}
	}
}