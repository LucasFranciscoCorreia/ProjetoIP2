package br.ufrpe.excecoes;

import br.ufrpe.beans.Funcionario;

public class FuncionarioJaExisteException extends Exception{
	Funcionario funcionario;
	
	public FuncionarioJaExisteException(Funcionario f){
		super("CPF " + f.getCpf() + " ja � cadastrado no sistema!");
		funcionario = f;
	}
}
