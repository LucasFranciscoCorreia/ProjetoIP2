/*
 * Projeto PetShop
 * 
 * Tipo 1: FuncionarioNaoExisteException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
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
