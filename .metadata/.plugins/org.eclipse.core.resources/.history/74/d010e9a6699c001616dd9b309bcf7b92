package br.ufrpe.repositorios;

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
