/*
 * Projeto PetShop
 * 
 * Tipo 1: IControladorAnimal
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.negocios;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Produto;
import br.ufrpe.excecoes.AnimalNaoExisteException;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.AnimalJaExisteException;

/**
 * Esta é a interface do ControladorAnimal
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
	
	void cadastrar(Animal novo)throws AnimalJaExisteException, AnimalJaExisteException;
	void remover(String codigo)throws CodigoNaoExisteException;
	void atualizar(Animal novo, Animal antigo) throws AnimalJaExisteException, AnimalNaoExisteException;
	Animal buscar(String codigo)throws CodigoNaoExisteException;
}
