package br.ufrpe.excecoes;

public class ObjectoJaExisteException extends Exception{
	
	public ObjectoJaExisteException (){
		super("Já existe no sistema!!");
	}
}
