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
