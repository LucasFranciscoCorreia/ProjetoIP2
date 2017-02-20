package br.ufrpe.negocios;

import br.ufrpe.beans.PetCare;
import br.ufrpe.repositorios.IRepositorioPetCare;

public class ControladorPetCare {

	private IRepositorioPetCare repositorioPetCare;
	
	public ControladorPetCare(IRepositorioPetCare instance){
		this.repositorioPetCare = instance;
	}
	public void adicionarPetCare(PetCare petcare){
		this.repositorioPetCare.adicionarPetCare(petcare);
	}
	
	public void removerPetCare(PetCare petcare){
		this.removerPetCare(petcare);
	}
	public void salvarNoArquivo(){
		this.repositorioPetCare.salvarNoArquivo();
	}
}
