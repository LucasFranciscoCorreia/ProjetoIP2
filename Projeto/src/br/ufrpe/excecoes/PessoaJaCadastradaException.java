package br.ufrpe.excecoes;

public class PessoaJaCadastradaException extends Exception{
	public PessoaJaCadastradaException(){
		super("Pessoa j� cadastrada no sistema!");
	}
}
