/*
 * Projeto PetShop
 * 
 * Tipo 1: FuncionarioJaExisteException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;

import br.ufrpe.beans.Funcionario;

public class FuncionarioJaExisteException extends Exception{
	Funcionario funcionario;
	
	public FuncionarioJaExisteException(Funcionario f){
		super("CPF " + f.getCpf() + " ja � cadastrado no sistema!");
		funcionario = f;
	}
}
