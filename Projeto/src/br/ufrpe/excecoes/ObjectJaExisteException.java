package br.ufrpe.excecoes;

public class ObjectJaExisteException extends Exception{
	
	public ObjectJaExisteException (){
		super("Já existe no sistema!!");
	}
}
