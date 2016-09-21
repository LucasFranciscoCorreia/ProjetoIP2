package br.ufrpe.repositorios;
import java.util.ArrayList;

import br.ufrpe.beans.Animal;
public class RepositorioAnimal {
	ArrayList<Animal> rep;
	public RepositorioAnimal(){
		rep = new ArrayList<>();
	}
	public RepositorioAnimal(ArrayList<Animal> outro){
		rep = outro;
	}
	public RepositorioAnimal(Animal outro){
		rep = new ArrayList<>();
		rep.add(outro);
	}
	public RepositorioAnimal(Animal[] outros){
		rep = new ArrayList<>();
		for(int i = 0; i < outros.length;i++){
			rep.add(outros[i]);
		}
	}
	public int Size(){
		return rep.size();
	}
	public void adicionar(Animal novo){
		rep.add(novo);
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
	public void remover(Animal antigo){
		int i = buscar(antigo);
		if(i != -1){
			rep.remove(i);			
		}else{
			System.out.println("Animal nao encontrado");
		}
	}
	public void atualizar(Animal antigo, Animal novo){
		int i = this.buscar(antigo);
		if(i != -1){
			remover(antigo);
			adicionar(novo);			
		}
	}
}
