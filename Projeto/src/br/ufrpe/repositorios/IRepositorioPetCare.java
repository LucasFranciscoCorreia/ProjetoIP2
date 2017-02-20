package br.ufrpe.repositorios;

import br.ufrpe.beans.PetCare;

public interface IRepositorioPetCare {

	public RepositorioPetCare getInstance();
	public void adicionarPetCare(PetCare novo);
	public void removerPetCare(PetCare petcare);
	public void salvarNoArquivo();
	
}
