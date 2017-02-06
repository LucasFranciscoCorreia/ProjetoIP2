package br.ufrpe.excecoes;

public class ProdutoJaCadastradoException extends Exception{
	public ProdutoJaCadastradoException(){
		super("Produto já cadastrado no sistema!");
	}
}