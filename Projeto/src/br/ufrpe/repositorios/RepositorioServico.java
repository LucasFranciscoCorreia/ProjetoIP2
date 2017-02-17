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
		if(this.unicInstance == null){
			unicInstance = lerDoArquivo();
		}
		return this.unicInstance;
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
		if (this.unicInstance == null){
			return;
		}
		
		File out = new File("Arquivos/Servico.data");
		FileOutputStream fo = null;
		ObjectOutputStream oos = null;
		
		try {
			fo = new FileOutputStream(out);
			oos = new ObjectOutputStream(fo);
			
			oos.writeObject(this.unicInstance);
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
					this.ArrayDeServicos.add(servico);
				}
			}
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
	
	public void removeDoRepositorio(){
		
	}
	

}
