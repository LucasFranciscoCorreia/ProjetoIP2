package br.ufrpe.test;

import br.ufrpe.beans.Produtos;
import br.ufrpe.repositorios.RepositorioProduto;

public class testProduto {
	public static void main(String[] args) {
		Produtos a = new Produtos(2.4f, "predinisona", "medicamento", "1234-5", 243);
		Produtos b = new Produtos(2.4f, "predinisona", "medicamento", "1234-5", 243);
		System.out.println(a.equals(b));
		b.setPreco(3.9f);
		System.out.println(a.equals(b));
		b.setTipo("Animal");
		System.out.println(a.equals(b));		
		System.out.println();
		RepositorioProduto rep1 = new RepositorioProduto();
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
		}
		rep1.adicionar(a);
		rep1.adicionar(b);
		System.out.println("----------------------------------------");
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
		}
		System.out.println("----------------------------------------");
		rep1.remover(a);
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
		}
		System.out.println("----------------------------------------");
		rep1.atualizar(b, a);
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
		}
		System.out.println("----------------------------------------");
	}	
}