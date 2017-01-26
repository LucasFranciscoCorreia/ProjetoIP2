/*
 * Projeto PetShop
 * 
 * Tipo 1: CodigoNaoExisteException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.excecoes;

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
