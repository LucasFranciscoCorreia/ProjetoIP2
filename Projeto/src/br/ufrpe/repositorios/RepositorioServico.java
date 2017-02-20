package br.ufrpe.repositorios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Repositório do objeto "servico"
 * Serve para armezanar os possíveis serviços gerados
 * @author srtacamelo
 *
 */
public class RepositorioServico implements IRepositorioServico{
	
	private ArrayList<Servico> ArrayDeServicos;
	private static IRepositorioServico unicInstance;
	/**
	 * Construtor vázio
	 *///Dead code?
	private RepositorioServico(){
		this.ArrayDeServicos = new ArrayList<>();
	}
	
	public IRepositorioServico getInstance(){
		if(unicInstance == null){
			unicInstance = lerDoArquivo();
		}
		return unicInstance;
	}
	
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
	
	public void addAoRepositorio(Servico servico) throws ObjectNaoExisteException, ObjectJaExisteException{
		
		if(servico != null){
			
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
		else{
			throw new ObjectNaoExisteException();
		}
	}
	
	public void removeDoRepositorio(Servico servico)throws ObjectNaoExisteException{
		
		if(servico != null){
			
			for (Servico servicoA : ArrayDeServicos) {
				
				if(servicoA.equals(servico)){
					this.ArrayDeServicos.remove(servicoA);
				}
			}
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
	
	public void removerDoRepositorioNome(String nome){
		
		if(nome != null){
			
			for (Servico servico : ArrayDeServicos) {
				if(servico.equals(servico.getNome())){
					this.ArrayDeServicos.remove(servico);
				}
			}
		}
	}
	
	public Servico pesquisarNomeNoRepositorioS(String nome) throws ObjectNaoExisteException{
		
		if(nome != null){
			
			for (Servico servico : ArrayDeServicos) {
				
				if(nome.equals(servico.getNome())){
					return servico;
				}
			}
			return null;
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
    
	public int pesquisarNomeNoRepositorioI(String nome)throws ObjectNaoExisteException{
	
		if(nome != null){
			Servico servico = pesquisarNomeNoRepositorioS(nome);
			return this.ArrayDeServicos.indexOf(servico);
		}
		else{
			throw new ObjectNaoExisteException();
		}
		
	}
	
	public int pesquisarServicoNoRepositorio(Servico servico) throws ObjectNaoExisteException{ 
		
		if (servico != null) {
			for (Servico servicoR : ArrayDeServicos) {
				if (servicoR.equals(servico)) {
					return ArrayDeServicos.indexOf(servicoR);
				}
			}
			return -1;
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
    
	private String gerarCodigo(){
		return String.valueOf(this.ArrayDeServicos.size()+1);
	}
}
