/*
 * Projeto PetShop
 * 
 * Tipo 1: CodigoNaoExisteException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
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
