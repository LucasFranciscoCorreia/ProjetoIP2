package br.ufrpe.repositorios;

import br.ufrpe.beans.Animal;
import br.ufrpe.exce�oes.AnimalJaExisteException;
import br.ufrpe.exce�oes.AnimalNaoExisteException;
import br.ufrpe.exce�oes.CodigoNaoExisteException;

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
