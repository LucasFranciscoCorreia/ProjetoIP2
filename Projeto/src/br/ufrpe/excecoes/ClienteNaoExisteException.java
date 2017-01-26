/*
 * Projeto PetShop
 * 
 * Tipo 1: ClienteNaoExisteException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
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
