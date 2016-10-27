package br.ufrpe.negocios;

import br.ufrpe.beans.Produto;

public interface IControladorProduto {
	
	void cadastrar(Produto produto);
	void remover(String codigo);
	Produto pesquisar(String codigo);
	void atualizar(Produto produto);
}
