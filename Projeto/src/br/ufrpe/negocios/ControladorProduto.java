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
			if(repositorioProduto.buscar(produto.getCodigo()) == null){
						
			}else{throw new ObjectJaExisteException();}}
			catch (ObjectNaoExisteException e) {
				System.out.println("\t*****Produto cadastrado com sucesso*****");
				repositorioProduto.cadastrar(produto); }			
			
		}else{throw new ErroAoSalvarException(produto);}
	}
	
	public void remover(String codigo) throws ObjectNaoExisteException, ErroAoRemoverException{
		if(codigo != null){
			
				if(repositorioProduto.buscar(codigo) != null){
				repositorioProduto.remover(codigo);
				System.out.println("\t*****Produto removido com sucesso*****");
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
				System.out.println("\t*****Produto atualizado com sucesso*****");
			   }
			
			
		}else{throw new ErroAoAtualizarException();}
	}
	
	public String listarProduto(){
		ArrayList<Produto> produtos = repositorioProduto.listarProduto();
		if(repositorioProduto.Size() == 0){
			return "Nao existem produtos cadastrados no sistema!";
		}else{
			String resultado = "";
			for(int i = 0; i < repositorioProduto.Size(); i++){
				resultado += produtos.get(i).toString() + "\n\n";
			}
			return resultado;
		}
	}
	
	
}
