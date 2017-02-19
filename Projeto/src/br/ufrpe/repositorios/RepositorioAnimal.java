/*
 * Projeto PetShop
 * 
 * Tipo 1: RepositorioAnimal
 * Tipo 2: IRepositorioAnimal, descri��p: interface
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

import br.ufrpe.beans.Animal;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Est� classe � utilizada para armazenar futuros animais cadastrados no sistema, nela
 * voc� pode tanto alterar, remover, cadastrar ou pesquisar por animais, independente do tipo
 * de animal (produto ou cliente).
 * 
 * @author Raissa Camelo
 *
 * @see Animal
 * @see IRepositorioAnimal
 * @exception AnimalJaExisteException
 * @exception AnimalNaoExisteException
 * @exception CodigoNaoExisteException
 */
public class RepositorioAnimal implements IRepositorioAnimal, Serializable{
	private ArrayList<Animal> rep;
	private ArrayList<Animal> lixeira;
	private static IRepositorioAnimal unicInstanc;
	/**
	 * Construtor/
	 */
	private RepositorioAnimal(){
		rep = new ArrayList<>();
		lixeira = new ArrayList<>();
	}

	public static IRepositorioAnimal getInstance(){
		if (unicInstanc == null) {
			unicInstanc = lerDoArquivo();
		}
		return unicInstanc;
	}

	private static RepositorioAnimal lerDoArquivo(){
		RepositorioAnimal unicInstanc = null;

		File in = new File("Arquivos/Animal.data");
		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {
			fi = new FileInputStream(in);
			oi = new ObjectInputStream(fi);
			Object obj = oi.readObject();

			unicInstanc = (RepositorioAnimal) obj;
		} catch (Exception e) {
			unicInstanc = new RepositorioAnimal();
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

		File out = new File("Arquivos/Animal.data");
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

	public int buscarIndice(Animal bus) {
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i).equals(bus)){ //Duvida: deve-se manter esse return dentro do laço?
				return i;              //Ou eh melhor declarar a variavel i antes do for(-1), e
			}				//usar um if depois dele (if i > -1)
		}				//Como fiz no metodo abaixo:
		return -1;

	}
	public int buscarIndice(String codigo) throws CodigoNaoExisteException{
		int result = -1;

		for(int i = 0; i< rep.size(); i++){
			if(rep.get(i).getCodigo().equals(codigo)){
				result = i;
			}
		}
		if(result == -1){
			String m = "Codigo nao existe: "+codigo;
			throw new CodigoNaoExisteException(codigo, m);
		}
		return result;
	}

	public int size(){
		return rep.size();
	}

	public void adicionar(Animal novo) throws ObjectJaExisteException{
		boolean ok = false;
		if (novo != null) {
			ok = true;
			for (int i = 0; i < rep.size(); i++) {
				if (rep.get(i).equals(novo)) {
					ok = false;
				}
			}
			if (ok) {
				rep.add(novo);		
				for (int i = 0; i < lixeira.size(); i++) {
					if (lixeira.get(i).equals(novo)) {
						lixeira.remove(novo);
					}
				}
			}
			else{
				throw new ObjectJaExisteException();
			}
		}

	}

	public Animal getPet(int i){
		if(i >=0 && i < rep.size()){
			return this.rep.get(i);			
		}
		return null;
	}

	public boolean remover(Animal antigo) throws ObjectNaoExisteException{
		boolean ok = false;
		int i = -1;


		i = buscarIndice(antigo);

		if(i != -1){
			lixeira.add(antigo);
			rep.remove(i);		
			ok = true;		
		}

		return ok;
	}
	private void adicionarDireto(Animal novo){
		if(novo != null){
			this.rep.add(novo);
		}
	}
	public boolean atualizar(Animal antigo, Animal novo) throws ObjectJaExisteException, ObjectNaoExisteException{
		boolean ok = false;
		int i = this.buscarIndice(antigo);
		if(i != -1){
			ok = true;
			this.remover(antigo); 
			adicionarDireto(novo);	
		}

		return ok;
	}
	public Animal buscar(String codigo)throws CodigoNaoExisteException{
		Animal a;
		for(int i = 0; i< rep.size(); i++){
			a= rep.get(i);
			if(a.getCodigo() != null && a.getCodigo().equals(codigo)){
				return a;
			}
		}//Mudar para for reach]
		String m = "Codigo Digitado nao Existe: "+codigo;
		throw new CodigoNaoExisteException(codigo, m);

	}
	public boolean remover(String codigo)throws CodigoNaoExisteException{

		boolean result = false;
		if(codigo != null){
			int busca = this.buscarIndice(codigo);
			if(busca != -1){
				rep.remove(rep.get(busca));
				result = true;
			}
		}
		return result; //Exception ja eh "throwed" em buscar
	}

	public Animal recuperar(String cpf, String raca){
		for (int i = 0; i < lixeira.size(); i++) {
			if (lixeira.get(i).getDonoCPF().equals(cpf) && lixeira.get(i).getRaca().equals(raca)) {
				return lixeira.get(i);
			}
		}
		return null;
	}

	public String toString(){
		String animais="";
		for (Animal s: this.rep){
			animais += s+"\n";
		}
		return animais;
	}
}
