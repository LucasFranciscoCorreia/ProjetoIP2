package br.ufrpe.excecoes;

public class ObjectoNaoExisteException extends Exception{
	
	public ObjectoNaoExisteException (){
		super("Não foi possivel localizar no sistema!!!");
	}

}
