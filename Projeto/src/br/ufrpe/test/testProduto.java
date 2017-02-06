package br.ufrpe.test;

import java.time.LocalDate;

import br.ufrpe.beans.Acessorio;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Remedio;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ProdutoJaCadastradoException;
import br.ufrpe.excecoes.ProdutoNaoExisteException;
import br.ufrpe.negocios.ControladorProduto;
import br.ufrpe.repositorios.RepositorioProduto;

public class testProduto {
	public static void main(String[] args) {
		
		LocalDate agora = LocalDate.now();
		Produto a = new Remedio(2.4f, "predinisona", "medicamento", "1234-5", 243,"asd","dsa");
		Produto b = new Remedio(2.4f, "predinisona", "medicamento", "1234-5", 243,"asd","dsa");
		Produto c = new Acessorio(2.4f, "Alve", "Coleira", "1234-7", 243,"Verde", 150, agora.plusYears(3));
		System.out.println("----------------------------------------");
		System.out.println("equals: \n");
		System.out.println(a.equals(b));
		b.setPreco(3.9f);
		System.out.println(a.equals(b));
		b.setTipo("Animal");
		System.out.println(a.equals(c));		
		System.out.println();
		ControladorProduto controladorProduto = new ControladorProduto(RepositorioProduto.getInstance());
		System.out.println(c);
		
		System.out.println("--------------------------------------");
		System.out.println("Cadastrar: ");
		try{
		controladorProduto.cadastrar(a);
		controladorProduto.cadastrar(b);
		controladorProduto.cadastrar(c);
		}
		catch(ErroAoSalvarException | ProdutoJaCadastradoException e){
			
		}
		System.out.println("----------------------------------------");
		System.out.println("Remover: ");
		try {
			controladorProduto.remover("1234-5");
		} catch (ProdutoNaoExisteException | ErroAoRemoverException e) {
			
		}
		System.out.println("----------------------------------------");
		
	}	
}