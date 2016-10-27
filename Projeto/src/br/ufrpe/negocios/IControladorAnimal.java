package br.ufrpe.negocios;

import br.ufrpe.beans.Animal;
import br.ufrpe.exce�oes.AnimalJaExisteException;
import br.ufrpe.exce�oes.AnimalNaoExisteException;
import br.ufrpe.exce�oes.CodigoNaoExisteException;

public interface IControladorAnimal {
	
	void cadastrar(Animal novo)throws AnimalJaExisteException;
	void remover(String codigo)throws CodigoNaoExisteException;
	void atualizar(Animal novo, Animal antigo) throws AnimalJaExisteException, AnimalNaoExisteException;
	Animal buscar(String codigo)throws CodigoNaoExisteException;
}
