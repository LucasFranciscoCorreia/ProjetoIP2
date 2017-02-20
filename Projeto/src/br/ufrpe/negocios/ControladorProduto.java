/*
 * Projeto PetShop
 * 
 * Tipo: ControladorProduto
 * Tipo 2: IControladorProduto, descri��o: interface
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
import br.ufrpe.repositorios.IRepositorioProduto;

public class ControladorProduto implements IControladorProduto{
	private IRepositorioProduto repositorioProduto;

	public ControladorProduto(IRepositorioProduto instance){
		repositorioProduto = instance;
	}

	public void salvarNoArquivo(){
		repositorioProduto.salvarNoArquivo();
	}

	public void cadastrar(Produto produto) throws ObjectJaExisteException, ErroAoSalvarException{	
		if(produto != null){
			try {
				produto.setCodigo(repositorioProduto.gerarCodigo());	
				if(repositorioProduto.buscar(produto.getCodigo()) == null){

				}else{throw new ObjectJaExisteException();}}
			catch (ObjectNaoExisteException e) {
				repositorioProduto.cadastrar(produto); }			

		}else{throw new ErroAoSalvarException(produto);}
	}

	public void remover(String codigo) throws ObjectNaoExisteException, ErroAoRemoverException{
		if(codigo != null){

			if(repositorioProduto.buscar(codigo) != null){
				repositorioProduto.remover(codigo);
			}


		}else{throw new ErroAoRemoverException();}
	}


	public Produto pesquisar(String codigo) throws ObjectNaoExisteException{
		if(codigo != null){

			if(repositorioProduto.buscar(codigo) != null){
				return repositorioProduto.buscar(codigo);
			}
		}else{throw new ObjectNaoExisteException();}
		return null;
	}

	public void atualizar(Produto produto) throws ObjectNaoExisteException, ErroAoAtualizarException{
		if(produto != null){
			String codigo = produto.getCodigo();

			if(repositorioProduto.buscar(codigo) != null){
				repositorioProduto.atualizar(produto);
			}


		}else{throw new ErroAoAtualizarException();}
	}

	public ArrayList<Produto> listarProduto(){
		return repositorioProduto.listarProduto();
	}

	public String gerarCodigo(){
		return repositorioProduto.gerarCodigo();
	}


}
