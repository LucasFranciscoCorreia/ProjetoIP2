package br.ufrpe.repositorios;

import java.util.ArrayList;

import br.ufrpe.beans.Produto;
public class RepositorioProduto {
	private  ArrayList<Produto> rep;
	
	public RepositorioProduto(){
		 rep = new ArrayList<>();
	}
	public int Size(){
		return rep.size();
	}
	public boolean adicionar(Produto novo){
		boolean ok = true;
		for (int i = 0; i < rep.size(); i++) {
			if (rep.get(i).equals(novo)) {
				ok = false;
			}
		}
		if (ok) {
			rep.add(novo);
		}
		return ok;
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
				return buscar(i);
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
	public boolean remover(Produto antigo){
		boolean ok = false;
		int i = buscarI(antigo);
		if(i != -1){
			rep.remove(antigo);
			ok = true;
		}else{
			System.out.println("Produto nao encontrado");
		}
		return ok;
	}
	public boolean atualizar(Produto antigo, Produto novo){
		boolean ok = false;
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i).equals(antigo)){
				this.remover(antigo);
				rep.add(novo);
				ok = true;
			}
		}
		return ok;
	}
}
