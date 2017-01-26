/*
 * Projeto PetShop
 * 
 * Tipo 1: IRepositorioAnimal
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.repositorios;

import br.ufrpe.beans.Animal;
import br.ufrpe.excecoes.AnimalJaExisteException;
import br.ufrpe.excecoes.AnimalNaoExisteException;
import br.ufrpe.excecoes.CodigoNaoExisteException;

/**
 * Interface do RepositorioAnimal
 * 
 * @author Raissa Camelo
 * 
 * @see Animal
 * @see RepositorioAnimal
 * @exception AnimalJaExisteException
 * @exception AnimalNaoExisteException
 * @exception CodigoNaoExisteException
 *
 */
public interface IRepositorioAnimal {
	
	int buscarIndice(Animal bus) throws AnimalNaoExisteException;
	int buscarIndice(String codigo) throws CodigoNaoExisteException;
	int size();
	boolean remover(Animal antigo) throws AnimalNaoExisteException;
	boolean atualizar(Animal antigo, Animal novo) throws AnimalNaoExisteException, AnimalJaExisteException;
	boolean remover(String codigo)throws CodigoNaoExisteException;
	void adicionar(Animal novo)throws AnimalJaExisteException;
	Animal getPet(int i);
	Animal buscar(String codigo) throws CodigoNaoExisteException;
	Animal recuperar(String cpf, String raca);	
}
