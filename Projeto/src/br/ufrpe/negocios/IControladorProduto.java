/*
 * Projeto PetShop
 * 
 * Tipo 1: IControladorProduto
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.negocios;

import br.ufrpe.beans.Produto;

public interface IControladorProduto {
	
	void cadastrar(Produto produto);
	void remover(String codigo);
	Produto pesquisar(String codigo);
	void atualizar(Produto produto);
}
