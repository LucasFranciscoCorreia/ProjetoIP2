package br.ufrpe.repositorios;

import java.util.ArrayList;
import br.ufrpe.beans.Produtos;
/* weeee */
public class RepositorioProduto {
	private  ArrayList<Produtos> rep;
	
	public RepositorioProduto(){
		 rep = new ArrayList<>();
	}
	public int Size(){
		return rep.size();
	}
	public boolean adicionar(Produtos novo){
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
	public Produtos buscar(Produtos bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == bus){
				return rep.get(i);
			}
		}
		return null;
	}
	public Produtos buscar(int i){
		return rep.get(i);
	}
	public Produtos buscar(String codigo){
		for(int i = 0 ; i < rep.size(); i++){
			if(rep.get(i).getCodigo().equals(codigo)){
				return rep.get(i);
			}
		}
		
		return null;
	}
	private int buscarI(Produtos bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == bus){
				return i;
			}
		}
		return -1;
	}
	public boolean remover(Produtos antigo){
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
	public boolean atualizar(Produtos antigo, Produtos novo){
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
