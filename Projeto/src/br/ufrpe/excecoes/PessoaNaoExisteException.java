package br.ufrpe.excecoes;

public class PessoaNaoExisteException extends Exception{
	public PessoaNaoExisteException(){
		super("Pessoa não encontrada no sistema!");
	}
}
