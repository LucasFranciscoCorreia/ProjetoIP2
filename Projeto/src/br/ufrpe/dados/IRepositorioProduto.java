package br.ufrpe.dados;

import br.ufrpe.beans.Produto;

public interface IRepositorioProduto {
	
	public int Size();
	public void cadastrar(Produto novo);
	public Produto buscar(String codigo);
	public void remover(String codigo);
	public void atualizarEstoque(Produto novo);
	
}
