package br.ufrpe.repositorios;

import java.util.ArrayList;
import br.ufrpe.beans.Produto;

public class RepositorioProduto {
	private  ArrayList<Produto> repositorio;
	private static RepositorioProduto unicInstanc;
	
	private RepositorioProduto(){
		 repositorio = new ArrayList<>();
	}
	
	public static synchronized RepositorioProduto getInstanciado(){
		if(unicInstanc == null){
			unicInstanc = new RepositorioProduto();
		}
		
		return unicInstanc;
	}
	
	public int Size(){
		return repositorio.size();
	}
	
	private int buscarI(String bus){
		for(int i = 0; i < repositorio.size();i++){
			if(repositorio.get(i).getCodigo().equals(bus)){
				return i;
			}
		}
		return -1;
	}
	
	public void cadastrar(Produto novo){
		repositorio.add(novo);
	}
	
	public Produto buscar(String codigo){
		int i = buscarI(codigo);
		
		if(i != -1){
			return repositorio.get(i);			
		}else{return null;}
	}
	
	public void remover(String codigo){
		int i = buscarI(codigo);
		
		repositorio.remove(i);
	}
	
	public void atualizarEstoque(Produto novo){
		int i = buscarI(novo.getCodigo());
	
		repositorio.get(i).setEstoque(novo.getEstoque());
		repositorio.get(i).setPreco(novo.getPreco());
	}
}
