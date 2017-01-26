/*
 * Projeto PetShop
 * 
 * Tipo 1: ErroAoAtualizarException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;

public class ErroAoAtualizarException extends Exception{
	
	public ErroAoAtualizarException() {
		super("Impossivel Atualizar!");
	}
}
