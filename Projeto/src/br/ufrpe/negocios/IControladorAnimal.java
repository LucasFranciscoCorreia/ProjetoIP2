/*
 * Projeto PetShop
 * 
 * Tipo 1: IControladorAnimal
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.negocios;

import br.ufrpe.beans.Animal;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Esta � a interface do ControladorAnimal
 * 
 * @author Raissa Camelo
 * 
 * @see Animal
 * @see ControladorAnimal
 * @exception AnimalJaExisteException
 * @exception AnimalNaoExisteException
 * @exception CodigoNaoExisteException
 */
public interface IControladorAnimal {
	
	void cadastrar(Animal novo)throws ObjectJaExisteException;
	void remover(String codigo)throws CodigoNaoExisteException;
	void atualizar(Animal novo, Animal antigo) throws ObjectJaExisteException, ObjectNaoExisteException;
	Animal buscar(String codigo)throws CodigoNaoExisteException;
	void salvarNoArquivo();
}
