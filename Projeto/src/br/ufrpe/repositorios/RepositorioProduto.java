package br.ufrpe.repositorios;

import java.util.ArrayList;

import br.ufrpe.beans.Produto;
/* weeee */
public class RepositorioProduto {
	private  ArrayList<Produto> rep;
	private static RepositorioProduto instance;
	
	private RepositorioProduto(){
		rep = new ArrayList<>();
	}
	
	public static synchronized RepositorioProduto getInstance(){
		if(instance == null){
			
			instance = new RepositorioProduto();
		}
		
		return instance;
	}
	
	public int Size(){
		return rep.size();
	}
	public void adicionar(Produto novo){
		rep.add(novo);
	}
	public Produto buscar(Produto bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == bus){
				return rep.get(i);
			}
		}
		return null;
	}
	public Produto buscar(int i){
		return rep.get(i);
	}
	public Produto buscar(String codigo){
		for(int i = 0 ; i < rep.size(); i++){
			if(rep.get(i).getCodigo().equals(codigo)){
				return rep.get(i);
			}
		}
		
		return null;
	}
	private int buscarI(Produto bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == bus){
				return i;
			}
		}
		return -1;
	}
	public void remover(Produto antigo){
		int i = buscarI(antigo);
		if(i != -1){
			rep.remove(antigo);
		}
	}
	public void atualizar(Produto antigo, Produto novo){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == antigo){
				rep.remove(i);
				rep.add(novo);
				break;
			}
		}
	}
}
