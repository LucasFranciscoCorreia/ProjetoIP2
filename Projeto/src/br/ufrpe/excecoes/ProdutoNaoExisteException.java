package br.ufrpe.excecoes;

public class ProdutoNaoExisteException extends Exception{
	public ProdutoNaoExisteException(){
		super("Produto não encontrada no sistema! Tente Novamente");
	}
}
