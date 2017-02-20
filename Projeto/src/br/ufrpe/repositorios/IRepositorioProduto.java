/*
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

import java.util.ArrayList;

import br.ufrpe.beans.Produto;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.negocios.ControladorProduto;

/**
 * Interface do RepositorioProduto
 * 
 * Lembrete: Como o RepositorioProduto n�o est� finalizado, a interface tamb�m n�o est�
 * 
 * @author Diego
 * @author Raissa
 * @see Produto
 * @see ControladorProduto
 */
public interface IRepositorioProduto {
	
	int Size();
	void cadastrar(Produto novo) throws ErroAoSalvarException, ObjectJaExisteException;
	Produto buscar(String codigo) throws ObjectNaoExisteException;
	void remover(String codigo) throws ErroAoRemoverException;
	void atualizar(Produto novo) throws ObjectNaoExisteException, ErroAoAtualizarException;
	public Produto buscarP(Produto produto) throws ObjectNaoExisteException;
	public int buscarProduto(Produto produto);
	ArrayList<Produto> listarProduto();
	public void alterarDoEstoque(Produto produto, int quantidade) throws ObjectNaoExisteException;
	void salvarNoArquivo();
	String gerarCodigo();
	
}