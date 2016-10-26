package br.ufrpe.test;

import br.ufrpe.beans.Produto;
import br.ufrpe.negocios.ControladorProduto;
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
		ControladorProduto controladorProduto = new ControladorProduto(RepositorioProduto.getInstance());
		
		System.out.println("--------------------------------------");
		System.out.println("Cadastrar: ");
		controladorProduto.cadastrar(a);
		controladorProduto.cadastrar(b);
		controladorProduto.cadastrar(c);
		System.out.println("----------------------------------------");
		System.out.println("Remover: ");
		controladorProduto.remover("1234-5");
		System.out.println("----------------------------------------");
		
	}	
}