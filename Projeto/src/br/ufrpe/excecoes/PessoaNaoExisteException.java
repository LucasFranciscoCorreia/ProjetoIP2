package br.ufrpe.excecoes;

public class PessoaNaoExisteException extends Exception{
	public PessoaNaoExisteException(){
		super("Pessoa n�o encontrada no sistema!");
	}
}
