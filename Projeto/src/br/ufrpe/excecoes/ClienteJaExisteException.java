/*
 * Projeto PetShop
 * 
 * Tipo 1: ClienteJaExisteException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;

import br.ufrpe.beans.Cliente;

public class ClienteJaExisteException extends Exception {
	Cliente c;
	public ClienteJaExisteException(Cliente e) {
		super("Cliente informado ja estÃ¡ cadastrado no sistema");
		c = e;
	}
	public Cliente getClienteExistente(){
		return c;
	}
}
