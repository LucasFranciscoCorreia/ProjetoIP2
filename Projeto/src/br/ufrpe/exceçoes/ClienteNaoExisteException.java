package br.ufrpe.exceçoes;

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
