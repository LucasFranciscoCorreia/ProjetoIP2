/*
 * Projeto PetShop
 * 
 * Tipo 1: ClienteInvalidoException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;

import br.ufrpe.beans.Cliente;

public class ClienteInvalidoException extends Exception {
	private Cliente c;
	private String cpf;
	public ClienteInvalidoException(Cliente e) {
		super("Parametro para o cadastro de Cliente invalido");
		c = e;
	}
	public ClienteInvalidoException(String cpf) {
		super("Parametro para a remoção do cliente invalido");
		this.cpf = cpf;
	}
	public Cliente getCliente(){
		return c;
	}
	public String getCpf(){
		if(c != null){
			return c.getCpf();
		}else{
			return cpf;
		}
	}
}
