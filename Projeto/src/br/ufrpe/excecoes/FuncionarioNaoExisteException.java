package br.ufrpe.excecoes;

import br.ufrpe.beans.Funcionario;

public class FuncionarioNaoExisteException extends Exception{
	Funcionario funcionario;
	String cpf;
	
	public FuncionarioNaoExisteException(String cpf){
		super("CPF de numero " + cpf + " nao cadastrado no sistema!");
		this.cpf = cpf;
	}
}
