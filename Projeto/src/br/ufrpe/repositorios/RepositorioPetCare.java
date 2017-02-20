package br.ufrpe.repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import br.ufrpe.beans.*;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

public class RepositorioPetCare implements IRepositorioPetCare {

	private ArrayList<PetCare> arrayListPetCare;
	private RepositorioPetCare repositorioPetCare;
	
	public RepositorioPetCare getInstance(){
		if(this.repositorioPetCare == null){
			this.repositorioPetCare = lerDoArquivo();
		}
		return this.repositorioPetCare;
	}
	
	public void adicionarPetCare(PetCare novo) throws ObjectNaoExisteException, ObjectJaExisteException{
		if(novo != null){
			
			for (PetCare petCare : this.arrayListPetCare) {
				if (this.arrayListPetCare.equals(novo)) {
					throw new ObjectJaExisteException();
				}
			}
			this.arrayListPetCare.add(novo);	
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
	
	public void removerPetCare(PetCare petcare) throws ObjectNaoExisteException{
		
		if (petcare != null) {
			this.arrayListPetCare.remove(petcare);
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
	
	private static RepositorioPetCare lerDoArquivo(){
		RepositorioPetCare unicInstanc = null;

		File in = new File("Arquivos/PetCare.data");
		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {
			fi = new FileInputStream(in);
			oi = new ObjectInputStream(fi);
			Object obj = oi.readObject();

			unicInstanc = (RepositorioPetCare) obj;
		} catch (Exception e) {
			unicInstanc = new RepositorioPetCare();
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
		if (this.repositorioPetCare == null){
			return;
		}

		File out = new File("Arquivos/PetCare.data");
		FileOutputStream fo = null;
		ObjectOutputStream oos = null;

		try {
			fo = new FileOutputStream(out);
			oos = new ObjectOutputStream(fo);

			oos.writeObject(this.repositorioPetCare);
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
	
	public ArrayList<PetCare> listarServicoEmAndamento(){
			
			ArrayList<PetCare> arrayEmAndamento = new ArrayList<PetCare>();
			
			for (PetCare petCare : arrayListPetCare) {
				if(petCare.getDataFim() == null){
					arrayEmAndamento.add(petCare);
				}
			}
			return arrayEmAndamento;
		}
	
	public ArrayList<PetCare> listarServicoConcluido(){
		
		ArrayList<PetCare> arrayConcluido = new ArrayList<PetCare>();
		
		for (PetCare petCare : arrayListPetCare) {
			if(petCare.getDataFim() != null){
				arrayConcluido.add(petCare);
			}
		}
		return arrayConcluido;
	}
}
