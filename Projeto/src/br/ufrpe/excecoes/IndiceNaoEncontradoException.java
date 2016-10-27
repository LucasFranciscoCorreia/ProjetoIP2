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
