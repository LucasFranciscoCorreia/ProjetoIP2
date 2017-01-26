/*
 * Projeto PetShop
 * 
 * Tipo 1: IRepositorioAnimal
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.repositorios;

import br.ufrpe.beans.Animal;
import br.ufrpe.excecoes.AnimalJaExisteException;
import br.ufrpe.excecoes.AnimalNaoExisteException;
import br.ufrpe.excecoes.CodigoNaoExisteException;

public interface IRepositorioAnimal {
	
	 void adicionar(Animal novo)throws AnimalJaExisteException;
	 int buscarIndice(Animal bus) throws AnimalNaoExisteException;
	 int buscarIndice(String codigo) throws CodigoNaoExisteException;
	 Animal getPet(int i);
	 boolean remover(Animal antigo) throws AnimalNaoExisteException;
	 boolean atualizar(Animal antigo, Animal novo) throws AnimalNaoExisteException, AnimalJaExisteException;
	 Animal buscar(String codigo) throws CodigoNaoExisteException;
	 boolean remover(String codigo)throws CodigoNaoExisteException;
	 Animal recuperar(String cpf, String raca);
	 int size();
	
	
	
}
