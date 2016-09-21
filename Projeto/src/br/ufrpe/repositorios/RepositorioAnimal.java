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
	public void adicionar(Animal novo){
		rep.add(novo);
	}
	public Animal buscar(Animal bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == bus){
				return rep.get(i);
			}
		}
		return null;
	}
	public int buscarI(Animal bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == bus){
				return i;
			}
		}
		return -1;
	}
	public void remover(Animal antigo){
		int i = buscarI(antigo);
		if(i != -1){
			rep.remove(i);			
		}else{
			System.out.println("Animal nao encontrado");
		}
	}
	public void atualizar(Animal antigo, Animal novo){
		remover(antigo);
		adicionar(novo);
	}
}