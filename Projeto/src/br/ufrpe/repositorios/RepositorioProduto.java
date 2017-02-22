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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.beans.Acessorio;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Remedio;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Este repositorio armazena dados sobre os produtos existentes na loja.
 * 
 * Lembrete: Repositorio incompleto, não foi feito a implementação de exceções
 * 
 * @author Diego
 * 
 * @see Produto
 * @see IRepositorioProduto
 */
public class RepositorioProduto implements IRepositorioProduto, Serializable {
	private  ArrayList<Produto> repositorio;
	private static IRepositorioProduto unicInstanc;

	private RepositorioProduto(){
		repositorio = new ArrayList<Produto>();
	}

	public static IRepositorioProduto getInstance(){
		if(unicInstanc == null){
			unicInstanc = lerDoArquivo();
		}

		return unicInstanc;
	}

	private static RepositorioProduto lerDoArquivo(){
		RepositorioProduto unicInstanc = null;

		File in = new File("Arquivos/Produto.data");
		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {
			fi = new FileInputStream(in);
			oi = new ObjectInputStream(fi);
			Object obj = oi.readObject();

			unicInstanc = (RepositorioProduto) obj;
		} catch (Exception e) {
			unicInstanc = new RepositorioProduto();
		} finally {
			if(oi != null){
				try {
					oi.close();
				} catch (IOException e){
				}
			}
		}

		return unicInstanc;
	}

	public void salvarNoArquivo() {
		if (unicInstanc == null){
			return;
		}

		File out = new File("Arquivos/Produto.data");
		FileOutputStream fo = null;
		ObjectOutputStream oos = null;

		try {
			fo = new FileOutputStream(out);
			oos = new ObjectOutputStream(fo);

			oos.writeObject(unicInstanc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null){
				try {
					oos.close();
				} catch (IOException e){
				}
			}
		}
	}

	public int Size(){
		return repositorio.size();
	}

	public int buscarProduto(Produto produto) {

		for(int i = 0; i < repositorio.size();i++){

			if(repositorio.get(i).equals(produto)){
				return i;

			}
		}
		return -1;
	}

	public Produto buscarP(Produto produto) throws ObjectNaoExisteException {

		int i = buscarProduto(produto);

		if(i != -1){
			return repositorio.get(i);			
		}else{throw new ObjectNaoExisteException();}

	}

	private int buscarI(String bus){
		for(int i = 0; i <= repositorio.size()-1;i++){
			if(repositorio.get(i).getCodigo().equals(bus)){
				return i;
			}
		}
		return -1;
	}

	public void cadastrar(Produto novo) throws ErroAoSalvarException, ObjectJaExisteException{

		boolean ok = true;
		for(int i=0; i<this.repositorio.size();i++){
			if(this.repositorio.get(i).equals(novo)){
				ok = false;
				break;
			}
		}

		if(!ok){
			throw new ObjectJaExisteException();
		}
		else if (!this.repositorio.add(novo)) {
			throw new ErroAoSalvarException(novo);
		}

	}

	public Produto buscar(String codigo) throws ObjectNaoExisteException {

		int i = buscarI(codigo);

		if(i != -1){
			return repositorio.get(i);			
		}else{throw new ObjectNaoExisteException();}

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

	public void alterarDoEstoque(Produto produto, int quantidade) throws ObjectNaoExisteException{
		int index = this.buscarProduto(produto);
		if(index != -1){
            if(quantidade>=0){
            	this.repositorio.get(index).setEstoque(quantidade);;
            }
			
		}else{throw new ObjectNaoExisteException();}
	}

	public void atualizar(Produto novo) throws ObjectNaoExisteException, ErroAoAtualizarException{
		if(novo == null){
			throw new ErroAoAtualizarException();
		}
		else{
			int i = buscarI(novo.getCodigo());
			if(i == -1){
				throw new ObjectNaoExisteException();
			}
			else{
				if(novo instanceof Animal){

					Animal achado = (Animal)repositorio.get(i);

					if(novo.getNome() != null){
						achado.setNome(novo.getNome());
					}    		
					if(novo.getPreco() != 0){
						achado.setPreco(novo.getPreco());
					}
					if(novo.getEstoque() != -1){
						achado.setEstoque(novo.getEstoque());
					}
					if(((Animal) novo).getPeso()!=0){
						achado.setPeso(((Animal) novo).getPeso());
					}
					if(((Animal) novo).getTamanho()!=0){
						achado.setTamanho(((Animal) novo).getTamanho());
					}

				}
				else if(novo instanceof Acessorio){

					Acessorio achado = (Acessorio)repositorio.get(i);

					if(novo.getNome()!= null){
						achado.setNome(novo.getNome());
					}
					if(((Acessorio) novo).getCor()!=null){
						achado.setCor(((Acessorio) novo).getCor());
					}
					if(novo.getEstoque()!=-1){
						achado.setEstoque(novo.getEstoque());
					}
					if(novo.getPreco()!=0){
						achado.setPreco(novo.getPreco());
					}
					if(((Acessorio) novo).getTamanho()!=0){
						achado.setTamanho(((Acessorio) novo).getTamanho());
					}

				}
				else if(novo instanceof Remedio){

					Remedio achado = (Remedio)repositorio.get(i);

					if(novo.getNome() != null){
						achado.setNome(novo.getNome());
					}
					if(novo.getEstoque()!=-1){
						achado.setEstoque(novo.getEstoque());
					}
					if(novo.getPreco()!= 0){
						achado.setPreco(novo.getPreco());
					}
					if(((Remedio) novo).getTarja()!= null){
						achado.setTarja(((Remedio) novo).getTarja());
					}

				}

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

	public String gerarCodigo(){
		int ger = 1;
		String ok = null;
		if(!(this.Size() <= 0)){
			for(int i = 0 ; i<= this.Size()-1; i++){
				String codigo = "" + ger;

				if(codigo.equalsIgnoreCase(repositorio.get(i).getCodigo())){
					ger++;
					codigo = null;
				}
				else{
					ok = "" + ger;
				}
				if (ger>this.Size()){
					ok = "" + ger;
				}
			}
		}
		else{
			ok = "" + ger;
		}


		return ok;
	}

}