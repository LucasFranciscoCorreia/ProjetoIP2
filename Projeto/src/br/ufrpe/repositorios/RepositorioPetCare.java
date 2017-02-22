package br.ufrpe.repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import br.ufrpe.beans.*;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
/**
 * Esta classe representa o repositório de PetCare, classe que contém e realiza os serviços nos animais.
 * Ex: Banho.
 * @author srtacamelo
 *
 */
public class RepositorioPetCare implements IRepositorioPetCare, Serializable {

	private ArrayList<PetCare> repositorio;
	private static IRepositorioPetCare unicInstanc;

	private RepositorioPetCare(){
		this.repositorio = new ArrayList<>();
	}
	/**
	 * Método getInstance, garante que existirá apenas uma instancia da classe.
	 * @see Padrão Singleton
	 */
	public static IRepositorioPetCare getInstance(){
		if(unicInstanc == null){
			unicInstanc = lerDoArquivo();
		}
		return unicInstanc;
	}
	
	public PetCare busca(Cliente b, Animal p) throws ObjectNaoExisteException {
		LocalDate agora = LocalDate.now();
		int i = 0;
		boolean ok = true;
		
		ArrayList<PetCare> petCareEmAndamento = new ArrayList<>();
		petCareEmAndamento = listarServicoEmAndamento();
		PetCare achado = null;
		
		for (PetCare petCare : petCareEmAndamento) {
			if(petCare.getCliente().equals(b) && petCare.getNomeAnimal().equals(p.getNome())){
				achado = petCare;
				break;
			}
		}
		if(achado == null){
			throw new ObjectNaoExisteException();
		}
		
		return achado;
	}
	
	/**
	 * Método que le as o ArrayList de petCare do arquivo
	 * @return
	 */
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
	/**
	 * Método que salva o arrayList de petCare no arquivo
	 */
	public void salvarNoArquivo() {
		if (unicInstanc == null){
			return;
		}

		File out = new File("Arquivos/PetCare.data");
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
	
	/**
	 * Método que adiciona um novo "PetCare" ao repositório de petCare
	 */
	public void adicionarPetCare(PetCare novo) throws ObjectNaoExisteException, ObjectJaExisteException{
		if(novo != null){
			
			for (PetCare petCare : repositorio) {
				if (petCare.equals(novo)) {
					throw new ObjectJaExisteException();
				}
			}
			this.repositorio.add(novo);	
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
	/**
	 * Método que remove um PetCare do repositório de PetCare
	 */
	public void removerPetCare(PetCare petcare) throws ObjectNaoExisteException{
		
		if (petcare != null) {
			this.repositorio.remove(petcare);
		}
		else{
			throw new ObjectNaoExisteException();
		}
	}
	
//	public void removerDeAndamento(){
//		for (PetCare pet : listarServicoEmAndamento()) {
//			if(pet.getDataFim() != null){
//				listarServicoEmAndamento().remove(pet);
//			}
//		}
//
//	}
	
	/**
	 * Método que lista os serviços ainda não concluídos. 
	 * Usado na TableView da GUI
	 */
	public ArrayList<PetCare> listarServicoEmAndamento(){
		
		ArrayList<PetCare> arrayEmAndamento = new ArrayList<>();
		
		for (PetCare petCare : repositorio) {
			if(petCare.getDataFim() == null){
				arrayEmAndamento.add(petCare);
			}
		}
		return arrayEmAndamento;
	}
	/**
	 * Método que lista os Serviços que já foram concluidos.
	 * Usado na TableView da GUI
	 */
	public ArrayList<PetCare> listarServicoConcluido(){
		
		ArrayList<PetCare> arrayConcluido = new ArrayList<>();
		
		for (PetCare petCare : repositorio) {
			
			if(petCare.getDataFim() != null){
				arrayConcluido.add(petCare);
			}
		}
		return arrayConcluido;
	}
}
