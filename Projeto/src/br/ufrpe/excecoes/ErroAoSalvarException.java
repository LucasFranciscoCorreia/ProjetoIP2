package br.ufrpe.excecoes;

public class ErroAoSalvarException extends Exception{
	private Object ob;
	
	public ErroAoSalvarException(Object ob){
		super("Falha ao cadastrar!");
		this.ob = ob;
	}
}
