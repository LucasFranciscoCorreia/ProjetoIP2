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
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ObjectoJaExisteException;
import br.ufrpe.excecoes.ObjectoNaoExisteException;

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
	
	int buscarIndice(Animal bus) throws ObjectoJaExisteException;
	int buscarIndice(String codigo) throws CodigoNaoExisteException;
	int size();
	boolean remover(Animal antigo) throws ObjectoNaoExisteException;
	boolean atualizar(Animal antigo, Animal novo) throws ObjectoNaoExisteException, ObjectoJaExisteException;
	boolean remover(String codigo)throws CodigoNaoExisteException;
	void adicionar(Animal novo)throws ObjectoJaExisteException;
	Animal getPet(int i);
	Animal buscar(String codigo) throws CodigoNaoExisteException;
	Animal recuperar(String cpf, String raca);	
	void salvarNoArquivo();
}
