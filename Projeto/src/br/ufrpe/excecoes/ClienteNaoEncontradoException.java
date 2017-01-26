/*
 * Projeto PetShop
 * 
 * Tipo 1: ClienteNaoEncontradoException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.excecoes;

import br.ufrpe.beans.Cliente;

public class ClienteNaoEncontradoException extends Exception {
	
	private String cpf;
	public ClienteNaoEncontradoException(String cpf){
		super("Nao foi encontrado nenhum cliente com CPF o numero \"" + cpf + "\"");
		this.cpf = cpf;
	}
	public String getCpfNotFound(){
		return this.cpf;
	}
}
