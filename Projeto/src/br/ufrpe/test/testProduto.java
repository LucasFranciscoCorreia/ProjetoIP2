package br.ufrpe.test;

import br.ufrpe.beans.Produto;
import br.ufrpe.repositorios.RepositorioProduto;

public class testProduto {
	public static void main(String[] args) {
		Produto a = new Produto(2.4f, "predinisona", "medicamento", "1234-5", 243);
		Produto b = new Produto(2.4f, "predinisona", "medicamento", "1234-5", 243);
		Produto c = new Produto(2.4f, "predinisona", "medicamento", "1234-7", 243);
		System.out.println("----------------------------------------");
		System.out.println("equals: \n");
		System.out.println(a.equals(b));
		b.setPreco(3.9f);
		System.out.println(a.equals(b));
		b.setTipo("Animal");
		System.out.println(a.equals(c));		
		System.out.println();
		RepositorioProduto rep1 = new RepositorioProduto();
		
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
		}
		System.out.println("--------------------------------------");
		System.out.println("Cadastrar: ");
		System.out.println(rep1.adicionar(a));
		System.out.println(rep1.adicionar(b));
		System.out.println(rep1.adicionar(c));
		System.out.println("----------------------------------------");
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
			System.out.println();
		}
		System.out.println("----------------------------------------");
		System.out.println("Remover: ");
		System.out.println(rep1.remover(a));
		System.out.println();
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
		}
		System.out.println("----------------------------------------");
		System.out.println("Atualizar: ");
		System.out.println(rep1.atualizar(c,a));
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
		}
		System.out.println("----------------------------------------");
	}	
}