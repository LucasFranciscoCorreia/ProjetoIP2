/*
 * Projeto PetShop
 * 
 * Tipo 1: IndiceNaoEncontradoException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.excecoes;

import br.ufrpe.beans.Cliente;

public class IndiceNaoEncontradoException extends Exception {
	private Cliente c;
	private int indice;
	public IndiceNaoEncontradoException(int i){
		super("Nao foi encontrado nenhum cliente cujo indice é de " + i);
		indice = i;
	}
	public int getIndice(){
		return indice;
	}
}
