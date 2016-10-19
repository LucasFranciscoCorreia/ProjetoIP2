package br.ufrpe.repositorios;
import java.util.ArrayList;
import br.ufrpe.dados.IRepositorioAnimal;

import br.ufrpe.beans.Animal;
public class RepositorioAnimal implements IRepositorioAnimal {
	private ArrayList<Animal> rep;
	private ArrayList<Animal> lixeira;
	private static RepositorioAnimal repo;
	
	private RepositorioAnimal(){
		rep = new ArrayList<>();
		lixeira = new ArrayList<>();
	}
	
	public static RepositorioAnimal getInstance(){
		if (repo == null) {
			repo = new RepositorioAnimal();
		}
		return repo;
	}
	public int Size(){
		return rep.size();
	}
	public boolean adicionar(Animal novo){
		boolean ok = false;
		if (novo != null) {
			ok = true;
			for (int i = 0; i < rep.size(); i++) {
				if (rep.get(i).equals(novo)) {
					ok = false;
				}
			}
			if (ok) {
				rep.add(novo);		
				for (int i = 0; i < lixeira.size(); i++) {
					if (lixeira.get(i).equals(novo)) {
						lixeira.remove(novo);
					}
				}
			}
		}
		return ok;
	}
	public int buscarIndice(Animal bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i).equals(bus)){
				return i;
			}
		}
		return -1;
	}
	public Animal getPet(int i){
		if(i >=0 && i < rep.size()){
			return this.rep.get(i);			
		}
		return null;
	}
	public boolean remover(Animal antigo){
		boolean ok = false;
		int i = buscarIndice(antigo);
		if(i != -1){
			lixeira.add(antigo);
			rep.remove(i);		
			ok = true;
		}
		return ok;
	}
	public boolean atualizar(Animal antigo, Animal novo){
		boolean ok = false;
		int i = this.buscarIndice(antigo);
		if(i != -1){
			ok = true;
			this.remover(antigo);
			adicionar(novo);	
		}
		return ok;
	}
	public Animal buscar(String codigo){
		Animal a;
		for(int i = 0; i< rep.size(); i++){
			a= rep.get(i);
			if(a.getCodigo() != null && a.getCodigo().equals(codigo)){
		       return a;
			}
		}
		return null;
	}
	private int buscarI(String codigo){
        int result = -1;
		
		for(int i = 0; i< rep.size(); i++){
			if(rep.get(i).getCodigo().equals(codigo)){
		       result = i;
			}
		}
		return result;
	}
	public boolean remover(String codigo){
		
		boolean result = false;
		if(codigo != null){
			int busca = this.buscarI(codigo);
			if(busca != -1){
				rep.remove(rep.get(busca));
				result = true;
			}
		}
		return result;
	}
	
	public Animal recuperar(String cpf, String raca){
		for (int i = 0; i < lixeira.size(); i++) {
			if (lixeira.get(i).getDonoCPF().equals(cpf) && lixeira.get(i).getRaca().equals(raca)) {
				return lixeira.get(i);
			}
		}
		return null;
	}
	
	public String toString(){
		String animais="";
		for (Animal s: this.rep){
			animais += s+"\n";
		}
		return animais;
	}
}
