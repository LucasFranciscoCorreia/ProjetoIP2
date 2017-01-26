/*
 * Projeto PetShop
 * 
 * Tipo 1: AnimalNaoExisteException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
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
