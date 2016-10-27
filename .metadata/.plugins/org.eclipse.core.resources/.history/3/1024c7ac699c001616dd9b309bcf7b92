package br.ufrpe.repositorios;

import br.ufrpe.beans.Funcionario;

public class FuncionarioJaExisteException extends Exception{
	Funcionario funcionario;
	
	public FuncionarioJaExisteException(Funcionario f){
		super("CPF " + f.getCpf() + " ja é cadastrado no sistema!");
		funcionario = f;
	}
}
