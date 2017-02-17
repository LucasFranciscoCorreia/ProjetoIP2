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
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Interface do RepositorioAnimal
 * 
 * @author Raissa Camelo srtacamelo
 * 
 * @see Animal
 * @see RepositorioAnimal
 * @exception ObjetcJaExisteException
 * @exception ObjectNaoExisteException
 * @exception CodigoNaoExisteException
 *
 */
public interface IRepositorioAnimal {
	
	int buscarIndice(Animal bus);
	int buscarIndice(String codigo) throws CodigoNaoExisteException;
	int size();
	boolean remover(Animal antigo) throws ObjectNaoExisteException;
	boolean atualizar(Animal antigo, Animal novo) throws ObjectNaoExisteException, ObjectJaExisteException;
	boolean remover(String codigo)throws CodigoNaoExisteException;
	void adicionar(Animal novo)throws ObjectJaExisteException;
	Animal getPet(int i);
	Animal buscar(String codigo) throws CodigoNaoExisteException;
	Animal recuperar(String cpf, String raca);	
	void salvarNoArquivo();
}
