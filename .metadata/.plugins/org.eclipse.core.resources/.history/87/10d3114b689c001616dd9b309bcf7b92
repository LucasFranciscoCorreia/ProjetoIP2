package br.ufrpe.negocios;

import br.ufrpe.beans.Animal;
import br.ufrpe.exceçoes.AnimalJaExisteException;
import br.ufrpe.exceçoes.AnimalNaoExisteException;
import br.ufrpe.exceçoes.CodigoNaoExisteException;

public interface IControladorAnimal {
	
	void cadastrar(Animal novo)throws AnimalJaExisteException;
	void remover(String codigo)throws CodigoNaoExisteException;
	void atualizar(Animal novo, Animal antigo) throws AnimalJaExisteException, AnimalNaoExisteException;
	Animal buscar(String codigo)throws CodigoNaoExisteException;
}
