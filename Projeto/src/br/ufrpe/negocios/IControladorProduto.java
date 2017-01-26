/*
 * Projeto PetShop
 * 
 * Tipo 1: IControladorProduto
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
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
