package br.ufrpe.repositorios;

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
