/*
 * Projeto PetShop
 * 
 * Tipo 1: ClienteJaExisteException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;

import br.ufrpe.beans.Cliente;

public class ClienteJaExisteException extends Exception {
	Cliente c;
	public ClienteJaExisteException(Cliente e) {
		super("Cliente informado ja está cadastrado no sistema");
		c = e;
	}
	public Cliente getClienteExistente(){
		return c;
	}
}
