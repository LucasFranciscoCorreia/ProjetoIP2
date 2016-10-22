package br.ufrpe.dados;

import br.ufrpe.beans.Animal;

public interface IControladorAnimal {
	
	void cadastrar(Animal novo);
	void remover(String codigo);
	void atualizar(Animal novo, Animal antigo);
	Animal buscar(String codigo);
}
