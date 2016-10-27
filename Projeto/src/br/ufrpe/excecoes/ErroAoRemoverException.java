package br.ufrpe.excecoes;

public class ErroAoRemoverException extends Exception{
	public ErroAoRemoverException(){
		super("Falha ao remover!");
	}
}
