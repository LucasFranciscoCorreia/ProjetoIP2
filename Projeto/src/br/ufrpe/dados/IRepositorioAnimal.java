package br.ufrpe.dados;

import br.ufrpe.beans.Animal;

public interface IRepositorioAnimal {
	
	 boolean adicionar(Animal novo);
	 int buscarIndice(Animal bus);
	 Animal getPet(int i);
	 boolean remover(Animal antigo);
	 boolean atualizar(Animal antigo, Animal novo);
	 Animal buscar(String codigo);
	 boolean remover(String codigo);
	 Animal recuperar(String cpf, String raca);
	 int Size();
	
	
	
}
