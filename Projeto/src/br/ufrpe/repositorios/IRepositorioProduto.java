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
import br.ufrpe.negocios.ControladorProduto;

/**
 * Interface do RepositorioProduto
 * 
 * Lembrete: Como o RepositorioProduto n�o est� finalizado, a interface tamb�m n�o est�
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
