package br.ufrpe.dados;

import br.ufrpe.beans.Animal;
import br.ufrpe.repositorios.AnimalJaExisteException;
import br.ufrpe.repositorios.AnimalNaoExisteException;
import br.ufrpe.repositorios.CodigoNaoExisteException;

public interface IControladorAnimal {
	
	void cadastrar(Animal novo)throws AnimalJaExisteException;
	void remover(String codigo)throws CodigoNaoExisteException;
	void atualizar(Animal novo, Animal antigo) throws AnimalJaExisteException, AnimalNaoExisteException;
	Animal buscar(String codigo)throws CodigoNaoExisteException;
}
