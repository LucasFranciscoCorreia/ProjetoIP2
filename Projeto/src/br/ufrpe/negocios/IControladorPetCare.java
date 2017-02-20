package br.ufrpe.negocios;

import br.ufrpe.beans.PetCare;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.IRepositorioPetCare;

public interface IControladorPetCare {

	public void adicionarPetCare(PetCare petcare)throws ObjectJaExisteException, ObjectNaoExisteException;
	public void removerPetCare(PetCare petcare)throws ObjectNaoExisteException;
	public void salvarNoArquivo();
	
}
