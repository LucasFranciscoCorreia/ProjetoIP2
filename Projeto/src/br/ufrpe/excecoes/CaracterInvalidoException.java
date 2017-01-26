/*
 * Projeto PetShop
 * 
 * Tipo 1: CaracterInvalidoException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;
public class CaracterInvalidoException extends Exception {
	private char c;
	public CaracterInvalidoException(char c) {
		super("Caracter nao Ã© valido");
		this.c = c;
	}
}
