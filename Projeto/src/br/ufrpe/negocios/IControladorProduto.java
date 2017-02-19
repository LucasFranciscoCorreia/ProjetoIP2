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

import java.util.ArrayList;

import br.ufrpe.beans.Produto;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

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
	
	void cadastrar(Produto produto) throws ObjectJaExisteException, ErroAoSalvarException;
	void remover(String codigo) throws ObjectNaoExisteException, ErroAoRemoverException;
	ArrayList<Produto> listarProduto();
	Produto pesquisar(String codigo) throws ObjectNaoExisteException;
	void atualizar(Produto produto) throws ObjectNaoExisteException, ErroAoAtualizarException;
	void salvarNoArquivo();
	String gerarCodigo();
}
