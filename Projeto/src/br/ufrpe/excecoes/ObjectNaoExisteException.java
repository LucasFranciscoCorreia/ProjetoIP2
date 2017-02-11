package br.ufrpe.excecoes;

public class ObjectNaoExisteException extends Exception{
	
	public ObjectNaoExisteException (){
		super("Não foi possivel localizar no sistema!!!");
	}

}
