package br.ufrpe.negocios;

import br.ufrpe.repositorios.IRepositorioProduto;
import br.ufrpe.beans.Produto;

public class ControladorProduto implements IControladorProduto{
	private IRepositorioProduto repositorioProduto;
	
	public ControladorProduto(IRepositorioProduto instance){
		repositorioProduto = instance;
	}
	
	public void cadastrar(Produto produto){
		if(produto != null){
			if(repositorioProduto.buscar(produto.getCodigo()) == null){
				repositorioProduto.cadastrar(produto);
				System.out.println("\t*****Produto cadastrado com sucesso*****");
			}else{System.out.println("\t*****Produto ja cadastrado*****");}
		}else{System.out.println("\t*****Entrada Invalida*****");}
	}
	
	public void remover(String codigo){
		if(codigo != null){
			if(repositorioProduto.buscar(codigo) != null){
				repositorioProduto.remover(codigo);
				System.out.println("\t*****Produto removido com sucesso*****");
			}else{System.out.println("\t*****Produto nao encontrado*****");}
		}else{System.out.println("\t*****Entrada Invalida*****");}
	}
	
	public Produto pesquisar(String codigo){
		if(codigo != null){
			if(repositorioProduto.buscar(codigo) != null){
				return repositorioProduto.buscar(codigo);
			}else{System.out.println("\t*****Produto nao encontrado*****");}
		}else{System.out.println("\t*****Entrada Invalida*****");}
		return null;
	}
	
	public void atualizar(Produto produto){
		if(produto != null){
			String codigo = produto.getCodigo();
			if(repositorioProduto.buscar(codigo) != null){
				repositorioProduto.atualizarEstoque(produto);
				System.out.println("\t*****Produto atualizado com sucesso*****");
			}else{System.out.println("\t*****Produto nao encontrado*****");}
		}else{System.out.println("\t*****Entrada Invalida*****");}
	}
}
