package br.ufrpe.repositorios;
import java.util.ArrayList;

import br.ufrpe.beans.Animal;
public class RepositorioAnimal {
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
	private int buscar(Animal bus){
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
		int i = buscar(antigo);
		if(i != -1){
			lixeira.add(antigo);
			rep.remove(i);		
			ok = true;
		}
		return ok;
	}
	public boolean atualizar(Animal antigo, Animal novo){
		boolean ok = false;
		int i = this.buscar(antigo);
		if(i != -1){
			ok = true;
			this.remover(antigo);
			adicionar(novo);	
		}
		return ok;
	}
	public Animal recuperar(String cpf, String raca){
		for (int i = 0; i < lixeira.size(); i++) {
			if (lixeira.get(i).getDonoCPF().equals(cpf) && lixeira.get(i).getRaca().equals(raca)) {
				return lixeira.get(i);
			}
		}
		return null;
	}
}
