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
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectoJaExisteException;
import br.ufrpe.excecoes.ObjectoNaoExisteException;

/**
 * Interface do ControladorProduto
 * 
 * Lembrete: Como o ControladorProduto não está finalizado, a interface também  não está
 * 
 * @author Diego
 *
 * @see Produto
 * @see ControladorProduto
 */
public interface IControladorProduto {
	
	void cadastrar(Produto produto) throws ObjectoJaExisteException, ErroAoSalvarException;
	void remover(String codigo) throws ObjectoNaoExisteException, ErroAoRemoverException;
	Produto pesquisar(String codigo) throws ObjectoNaoExisteException;
	void atualizar(Produto produto) throws ObjectoNaoExisteException, ErroAoAtualizarException;
}
