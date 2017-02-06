/*
 * Projeto PetShop
 * 
 * Tipo 1: RepositorioProduto
 * Tipo 2: IRepositorioProduto, descri��p: interface
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.repositorios;

import java.util.ArrayList;

import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Produto;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ProdutoJaCadastradoException;
import br.ufrpe.excecoes.ProdutoNaoExisteException;

/**
 * Este repositorio armazena dados sobre os produtos existentes na loja.
 * 
 * Lembrete: Repositorio incompleto, n�o foi feito a implementa��o de exce��es
 * 
 * @author Diego
 * 
 * @see Produto
 * @see IRepositorioProduto
 */
public class RepositorioProduto implements IRepositorioProduto {
	private  ArrayList<Produto> repositorio;
	private static IRepositorioProduto unicInstanc;
	
	private RepositorioProduto(){
		 repositorio = new ArrayList<>();
	}
	
	public static IRepositorioProduto getInstance(){
		if(unicInstanc == null){
			unicInstanc = new RepositorioProduto();
		}
		
		return unicInstanc;
	}
	
	public int Size(){
		return repositorio.size();
	}
	
	private int buscarI(String bus){
		for(int i = 0; i < repositorio.size();i++){
			if(repositorio.get(i).getCodigo().equals(bus)){
				return i;
			}
		}
		return -1;
	}
	
	public void cadastrar(Produto novo) throws ErroAoSalvarException, ProdutoJaCadastradoException{
		
			boolean ok = true;
			for(int i=0; i<this.repositorio.size();i++){
				if(this.repositorio.get(i).equals(novo)){
					ok = false;
					break;
				}
			}
			
				if(!ok){
					throw new ProdutoJaCadastradoException();
				}
				else if (!this.repositorio.add(novo)) {
					throw new ErroAoSalvarException(novo);
				}
										
	}
	
	public Produto buscar(String codigo) throws ProdutoNaoExisteException {
		
		int i = buscarI(codigo);
		
		if(i != -1){
			return repositorio.get(i);			
		}else{throw new ProdutoNaoExisteException();}
	  
	}
	
	public void remover(String codigo) throws ErroAoRemoverException{
		
		
		int i = buscarI(codigo);
		if (i != -1){
			repositorio.remove(i);
		}
		else{
			throw new ErroAoRemoverException();
		  }
		
	}
	
	public void atualizar(Produto novo) throws ProdutoNaoExisteException, ErroAoAtualizarException{
		if(novo == null){
			throw new ErroAoAtualizarException();
		}
		else{
		int i = buscarI(novo.getCodigo());
	    if(i == -1){
	    	throw new ProdutoNaoExisteException();
	    }
	    else{
	    	repositorio.get(i).setNome(novo.getNome());
			repositorio.get(i).setEstoque(novo.getEstoque());
			repositorio.get(i).setPreco(novo.getPreco());
	    	
	    }
	    
		}
	}
	
	public ArrayList<Produto> listarProduto(){
		ArrayList<Produto> produtos = new ArrayList<>();
		for(int i = 0; i < this.Size(); i++){
			if(repositorio.get(i) != null){
				produtos.add(repositorio.get(i));
			}
			
		}
		return produtos;
	}
	
	
	
}
