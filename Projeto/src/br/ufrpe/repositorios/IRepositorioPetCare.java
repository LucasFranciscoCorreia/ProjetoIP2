package br.ufrpe.repositorios;

import java.util.ArrayList;

import br.ufrpe.beans.PetCare;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

public interface IRepositorioPetCare {

	public void adicionarPetCare(PetCare novo) throws ObjectNaoExisteException, ObjectJaExisteException;
	public void removerPetCare(PetCare petcare) throws ObjectNaoExisteException;
	public ArrayList<PetCare> listarServicoEmAndamento();
	public ArrayList<PetCare> listarServicoConcluido();
	public void salvarNoArquivo();
	
}
