/*
 * Projeto PetShop
 * 
 * Tipo 1: IRepositorioProduto
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.repositorios;

import br.ufrpe.beans.Produto;
import br.ufrpe.negocios.ControladorProduto;

/**
 * Interface do RepositorioProduto
 * 
 * Lembrete: Como o RepositorioProduto não está finalizado, a interface também não está
 * 
 * @author Diego
 *
 * @see Produto
 * @see ControladorProduto
 */
public interface IRepositorioProduto {
	
	int Size();
	void cadastrar(Produto novo);
	Produto buscar(String codigo);
	void remover(String codigo);
	void atualizarEstoque(Produto novo);
	
}
