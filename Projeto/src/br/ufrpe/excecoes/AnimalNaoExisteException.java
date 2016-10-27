package br.ufrpe.excecoes;
import br.ufrpe.beans.Animal;

public class AnimalNaoExisteException extends Exception{
	
	public Animal animalNaoExistente;
	
	public AnimalNaoExisteException(Animal animalNaoExistente, String m){
		super(m);
		this.animalNaoExistente = animalNaoExistente;
		
	}
	public Animal getAnimal(){
		return this.animalNaoExistente;
	}

}
