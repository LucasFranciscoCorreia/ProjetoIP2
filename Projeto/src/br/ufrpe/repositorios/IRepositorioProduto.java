/*
 * Projeto PetShop
 * 
 * Tipo 1: IRepositorioProduto
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.repositorios;

import br.ufrpe.beans.Produto;

public interface IRepositorioProduto {
	
	public int Size();
	public void cadastrar(Produto novo);
	public Produto buscar(String codigo);
	public void remover(String codigo);
	public void atualizarEstoque(Produto novo);
	
}
