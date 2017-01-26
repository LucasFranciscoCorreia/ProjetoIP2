/*
 * Projeto PetShop
 * 
 * Tipo 1: ClienteNaoExisteException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;

public class ClienteNaoExisteException extends Exception {
	
	private String cpf;
	public ClienteNaoExisteException(String cpf){
		super("Nao existe um cliente no sistema cujo cpf seja de numero \"" + cpf + "\"");
		this.cpf = cpf;
	}
	public String getCPF(){
		return cpf;
	}
}
