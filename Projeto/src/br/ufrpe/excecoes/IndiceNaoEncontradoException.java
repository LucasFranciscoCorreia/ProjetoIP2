/*
 * Projeto PetShop
 * 
 * Tipo 1: IndiceNaoEncontradoException
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.excecoes;

import br.ufrpe.beans.Cliente;

public class IndiceNaoEncontradoException extends Exception {
	private Cliente c;
	private int indice;
	public IndiceNaoEncontradoException(int i){
		super("Nao foi encontrado nenhum cliente cujo indice Ã© de " + i);
		indice = i;
	}
	public int getIndice(){
		return indice;
	}
}
