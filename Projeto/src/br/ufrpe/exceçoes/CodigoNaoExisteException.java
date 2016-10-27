package br.ufrpe.exce�oes;

public class CodigoNaoExisteException extends Exception{
	
	private String codigo;
	
	public CodigoNaoExisteException(String codigo, String m){
		super(m);
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}
