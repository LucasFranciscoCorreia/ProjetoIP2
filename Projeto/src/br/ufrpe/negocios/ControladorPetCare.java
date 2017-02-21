package br.ufrpe.negocios;

import java.util.ArrayList;

import br.ufrpe.beans.PetCare;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.IRepositorioPetCare;

public class ControladorPetCare implements IControladorPetCare{

	private IRepositorioPetCare repositorioPetCare;
	
	public ControladorPetCare(IRepositorioPetCare instance){
		this.repositorioPetCare = instance;
	}
	public void adicionarPetCare(PetCare petcare)throws ObjectJaExisteException, ObjectNaoExisteException{
		this.repositorioPetCare.adicionarPetCare(petcare);
	}
	
	public void removerPetCare(PetCare petcare) throws ObjectNaoExisteException{
		this.removerPetCare(petcare);
	}
	public void salvarNoArquivo(){
		this.repositorioPetCare.salvarNoArquivo();
	}
	
	public ArrayList<PetCare> listarServicoEmAndamento() {
		return repositorioPetCare.listarServicoEmAndamento();
	}
	
	public ArrayList<PetCare> listarServicoConcluido() {
		return repositorioPetCare.listarServicoConcluido();
	}
}
