/*
 * Projeto PetShop
 * 
 * Tipo 1: AnimalJaExisteException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

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
