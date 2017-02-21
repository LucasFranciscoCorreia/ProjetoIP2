<<<<<<< HEAD
package br.ufrpe.repositorios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Repositório do objeto "servico"
 * Serve para armezanar os possíveis serviços gerados
 * @author srtacamelo
 *
 */
public class RepositorioServico implements IRepositorioServico, Serializable{
	
	private ArrayList<Servico> ArrayDeServicos;
	private static IRepositorioServico unicInstance;
	/**
	 * Construtor vázio
	 *///Dead code?
	private RepositorioServico(){
		this.ArrayDeServicos = new ArrayList<>();
	}
	/**
	 * Método getInstance, garante que haverá apenas uma instancia da classe.
	 * @see Padrão Singleton
	 * @return
	 */
	public static IRepositorioServico getInstance(){
		if(unicInstance == null){
			unicInstance = lerDoArquivo();
		}
		return unicInstance;
	}
	/**
	 * Método le os serviços salvos no aquivo e os passa para o arrayList
	 * @return
	 */
	private static RepositorioServico lerDoArquivo(){
		RepositorioServico unicInstanc = null;
		
		File in = new File("Arquivos/Servico.data");
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		
		try {
			fi = new FileInputStream(in);
			oi = new ObjectInputStream(fi);
			Object obj = oi.readObject();
			
			unicInstanc = (RepositorioServico) obj;
		} catch (Exception e) {
			unicInstanc = new RepositorioServico();
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
	/**
	 * Método salva os serviços do ArrayList do sistema no arquivo 
	 */
	public void salvarNoArquivo() {
		if (unicInstance == null){
			return;
		}
		
		File out = new File("Arquivos/Servico.data");
		FileOutputStream fo = null;
		ObjectOutputStream oos = null;
		
		try {
			fo = new FileOutputStream(out);
			oos = new ObjectOutputStream(fo);
			
			oos.writeObject(unicInstance);
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
	/**
	 * Método que adicona um novo serviço ao repositóro de serviços
	 */
	public void addAoRepositorio(Servico servico) throws ObjectJaExisteException{
			
		for (Servico servicoA : ArrayDeServicos) {
			if(servicoA.getNome().equalsIgnoreCase(servico.getNome())){
				throw new ObjectJaExisteException();
			}
			else{
				servico.setCodigo(gerarCodigo());
				this.ArrayDeServicos.add(servico);
			}
		}
		
	}
	/**
	 * Método que remove um serviço do repositório de Serviço
	 */
	public void removerDoRepositorio(String nome) throws ObjectNaoExisteException{
		boolean achado = false;
		
		if(nome != null){	
			for (Servico servico : ArrayDeServicos) {
				if(servico.equals(servico.getCodigo())){
					this.ArrayDeServicos.remove(servico);
					achado = true;
				}
			}
		}
		
		if(!achado){
			throw new ObjectNaoExisteException();
		}
	}
	/**
	 * Método atualiza um serviço já existente, (trocando nome ou preço)
	 */
	public void atualizarServico(Servico antigo, Servico novo)throws ErroAoAtualizarException{
		if(antigo != null){
			this.ArrayDeServicos.remove(antigo);
			this.ArrayDeServicos.add(novo);
		}
		else{
			throw new ErroAoAtualizarException();
		}
	}
	/**
	 * Método que pesquisa pelo código o serviço no repositório
	 */
	public Servico pesquisarNoRepositorio(String codigo) throws ObjectNaoExisteException{
		boolean achado = true;
		
		if(codigo != null){	
			for (Servico servico : ArrayDeServicos) {
				
				if(codigo.equals(servico.getCodigo())){
					return servico;
				}
			}
			achado = false;
		}else{
			achado = false;
		}
		
		if(!achado){
			throw new ObjectNaoExisteException();
		}

		return null;
	}
    /**
     * Método que gera o código do serviço através da quantidade no repositório.
     * @return
     */
	private String gerarCodigo(){
		return String.valueOf(this.ArrayDeServicos.size()+1);
	}
	/**
	 * Método que lista os serviços, retornando um arrayList de Produtos (Classe mais genérica, já que 
	 * Serviço extends produto.
	 */
	public ArrayList<Produto> listarServico(){
		
		ArrayList<Produto> servicos = new ArrayList<>();
		for(Servico servicoA : ArrayDeServicos){
			servicos.add(servicoA);
		}
		return servicos;
	}
}
=======
package br.ufrpe.repositorios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Repositório do objeto "servico"
 * Serve para armezanar os possíveis serviços gerados
 * @author srtacamelo
 *
 */
public class RepositorioServico implements IRepositorioServico, Serializable{
	
	private ArrayList<Servico> ArrayDeServicos;
	private static IRepositorioServico unicInstance;
	/**
	 * Construtor vázio
	 *///Dead code?
	private RepositorioServico(){
		this.ArrayDeServicos = new ArrayList<>();
	}
	/**
	 * Método getInstance, garante que haverá apenas uma instancia da classe.
	 * @see Padrão Singleton
	 * @return
	 */
	public static IRepositorioServico getInstance(){
		if(unicInstance == null){
			unicInstance = lerDoArquivo();
		}
		return unicInstance;
	}
	/**
	 * Método le os serviços salvos no aquivo e os passa para o arrayList
	 * @return
	 */
	private static RepositorioServico lerDoArquivo(){
		RepositorioServico unicInstanc = null;
		
		File in = new File("Arquivos/Servico.data");
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		
		try {
			fi = new FileInputStream(in);
			oi = new ObjectInputStream(fi);
			Object obj = oi.readObject();
			
			unicInstanc = (RepositorioServico) obj;
		} catch (Exception e) {
			unicInstanc = new RepositorioServico();
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
	/**
	 * Método salva os serviços do ArrayList do sistema no arquivo 
	 */
	public void salvarNoArquivo() {
		if (unicInstance == null){
			return;
		}
		
		File out = new File("Arquivos/Servico.data");
		FileOutputStream fo = null;
		ObjectOutputStream oos = null;
		
		try {
			fo = new FileOutputStream(out);
			oos = new ObjectOutputStream(fo);
			
			oos.writeObject(unicInstance);
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
	/**
	 * Método que adicona um novo serviço ao repositóro de serviços
	 */
	public void addAoRepositorio(Servico servico) throws ObjectJaExisteException{
			
		for (Servico servicoA : ArrayDeServicos) {
			if(servicoA.equals(servico)){
				throw new ObjectJaExisteException();
			}
			else{
				servico.setCodigo(gerarCodigo());
				this.ArrayDeServicos.add(servico);
			}
		}
		
	}
	/**
	 * Método que remove um serviço do repositório de Serviço
	 */
	public void removerDoRepositorio(String nome) throws ObjectNaoExisteException{
		boolean achado = false;
		
		if(nome != null){	
			for (Servico servico : ArrayDeServicos) {
				if(servico.equals(servico.getCodigo())){
					this.ArrayDeServicos.remove(servico);
					achado = true;
				}
			}
		}
		
		if(!achado){
			throw new ObjectNaoExisteException();
		}
	}
	/**
	 * Método atualiza um serviço já existente, (trocando nome ou preço)
	 */
	public void atualizarServico(Servico antigo, Servico novo)throws ErroAoAtualizarException{
		if(antigo != null){
			this.ArrayDeServicos.remove(antigo);
			this.ArrayDeServicos.add(novo);
		}
		else{
			throw new ErroAoAtualizarException();
		}
	}
	/**
	 * Método que pesquisa pelo código o serviço no repositório
	 */
	public Servico pesquisarNoRepositorio(String codigo) throws ObjectNaoExisteException{
		boolean achado = true;
		
		if(codigo != null){	
			for (Servico servico : ArrayDeServicos) {
				
				if(codigo.equals(servico.getCodigo())){
					return servico;
				}
			}
			achado = false;
		}else{
			achado = false;
		}
		
		if(!achado){
			throw new ObjectNaoExisteException();
		}

		return null;
	}
    /**
     * Método que gera o código do serviço através da quantidade no repositório.
     * @return
     */
	private String gerarCodigo(){
		return String.valueOf(this.ArrayDeServicos.size()+1);
	}
	/**
	 * Método que lista os serviços, retornando um arrayList de Produtos (Classe mais genérica, já que 
	 * Serviço extends produto.
	 */
	public ArrayList<Produto> listarServico(){
		
		ArrayList<Produto> servicos = new ArrayList();
		for(Servico servicoA : ArrayDeServicos){
			servicos.add(servicoA);
		}
		return servicos;
	}
}
>>>>>>> branch 'master' of https://github.com/LucasFranciscoCorreia/ProjetoIP2.git
