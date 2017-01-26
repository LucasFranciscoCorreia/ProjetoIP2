/*
 * Projeto PetShop
 * 
 * Tipo 1: AnimalNaoExisteException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

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
