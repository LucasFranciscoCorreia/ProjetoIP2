package br.ufrpe.negocios;

import br.ufrpe.beans.Animal;
import br.ufrpe.excecoes.AnimalNaoExisteException;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.AnimalJaExisteException;

public interface IControladorAnimal {
	
	void cadastrar(Animal novo)throws AnimalJaExisteException, AnimalJaExisteException;
	void remover(String codigo)throws CodigoNaoExisteException;
	void atualizar(Animal novo, Animal antigo) throws AnimalJaExisteException, AnimalNaoExisteException;
	Animal buscar(String codigo)throws CodigoNaoExisteException;
}
