package br.ufrpe.excecoes;

import br.ufrpe.beans.Animal;

public class AnimalJaExisteException extends Exception{
	
	private Animal animalJaExistente;
	
	public AnimalJaExisteException(Animal animalJaExistente, String m){
		super(m);
		this.animalJaExistente = animalJaExistente;
	}
	
	public Animal getAnimal(){
		return this.animalJaExistente;
	}
}
