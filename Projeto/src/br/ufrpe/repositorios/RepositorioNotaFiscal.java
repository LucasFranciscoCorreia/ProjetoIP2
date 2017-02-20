package br.ufrpe.repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.ufrpe.beans.NotaFiscal;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

public class RepositorioNotaFiscal {

	private ArrayList<NotaFiscal> arrayDeNotaFiscal;
	private RepositorioNotaFiscal repositorioNotaFiscal;
	
	public RepositorioNotaFiscal getInstance(){
		if(this.repositorioNotaFiscal == null){
			this.repositorioNotaFiscal = lerDoArquivo();
		}
		return this.repositorioNotaFiscal;
	}
	
	private static RepositorioNotaFiscal lerDoArquivo(){
		RepositorioNotaFiscal unicInstanc = null;

		File in = new File("Arquivos/NotaFiscal.data");
		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {
			fi = new FileInputStream(in);
			oi = new ObjectInputStream(fi);
			Object obj = oi.readObject();

			unicInstanc = (RepositorioNotaFiscal) obj;
		} catch (Exception e) {
			unicInstanc = new RepositorioNotaFiscal();
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
		if (this.repositorioNotaFiscal == null){
			return;
		}

		File out = new File("Arquivos/NotaFiscal.data");
		FileOutputStream fo = null;
		ObjectOutputStream oos = null;

		try {
			fo = new FileOutputStream(out);
			oos = new ObjectOutputStream(fo);

			oos.writeObject(this.repositorioNotaFiscal);
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
	
	public void adicionarNotaFiscal(NotaFiscal nova)throws ObjectNaoExisteException, ObjectJaExisteException{
		if(nova != null){
			for (NotaFiscal notaFiscal : arrayDeNotaFiscal) {
				if(notaFiscal.equals(nova)){
					throw new ObjectJaExisteException();
				}
			}
			this.arrayDeNotaFiscal.add(nova);
		}
		else{
			throw new ObjectNaoExisteException();
		}
			
	}
	
	public void removerNotaFical(NotaFiscal canseiDessaBosta)throws ObjectNaoExisteException{
		
		if(canseiDessaBosta != null){
			this.arrayDeNotaFiscal.remove(canseiDessaBosta);
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
	
	
}
