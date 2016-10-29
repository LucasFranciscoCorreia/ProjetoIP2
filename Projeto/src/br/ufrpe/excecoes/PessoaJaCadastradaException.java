package br.ufrpe.excecoes;

public class PessoaJaCadastradaException extends Exception{
	public PessoaJaCadastradaException(){
		super("Pessoa já cadastrada no sistema!");
	}
}
