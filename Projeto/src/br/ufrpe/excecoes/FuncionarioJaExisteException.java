/*
 * Projeto PetShop
 * 
 * Tipo 1: FuncionarioJaExisteException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;

import br.ufrpe.beans.Funcionario;

public class FuncionarioJaExisteException extends Exception{
	Funcionario funcionario;
	
	public FuncionarioJaExisteException(Funcionario f){
		super("CPF " + f.getCpf() + " ja ï¿½ cadastrado no sistema!");
		funcionario = f;
	}
}
