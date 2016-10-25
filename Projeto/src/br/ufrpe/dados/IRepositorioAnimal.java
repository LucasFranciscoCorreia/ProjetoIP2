package br.ufrpe.dados;

import br.ufrpe.beans.Animal;
import br.ufrpe.repositorios.AnimalNaoExisteException;

public interface IRepositorioAnimal {
	
	 boolean adicionar(Animal novo);
	 int buscarIndice(Animal bus) throws AnimalNaoExisteException;
	 Animal getPet(int i);
	 boolean remover(Animal antigo) throws AnimalNaoExisteException;
	 boolean atualizar(Animal antigo, Animal novo);
	 Animal buscar(String codigo);
	 boolean remover(String codigo);
	 Animal recuperar(String cpf, String raca);
	 int size();
	
	
	
}
