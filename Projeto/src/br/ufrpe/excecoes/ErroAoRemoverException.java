/*
 * Projeto PetShop
 * 
 * Tipo 1: ErroAoRemoverException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes;

public class ErroAoRemoverException extends Exception{
	public ErroAoRemoverException(){
		super("Falha ao remover!");
	}
}
