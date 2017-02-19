package br.ufrpe.negocios;
import java.util.ArrayList;

import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.*;


public class ControladorServico implements IControladorServico{
	private IRepositorioServico repositorioServico;
	
	public ControladorServico(IRepositorioServico instance){
		this.repositorioServico = instance;
	}
	
	public void cadastrarServico(Servico novo)throws ObjectJaExisteException,ObjectNaoExisteException{
		repositorioServico.addAoRepositorio(novo);
	}
	public void removerServico(Servico servico)throws ObjectNaoExisteException{
		repositorioServico.removeDoRepositorio(servico);
	}
	public void removerServicoNome(String nome)throws ObjectNaoExisteException{
		repositorioServico.removerDoRepositorioNome(nome);
	}
	public Servico buscarServico(String nome)throws ObjectNaoExisteException{
		return repositorioServico.pesquisarNomeNoRepositorioS(nome);
	}
	public int buscarNome(String nome)throws ObjectNaoExisteException{
		return repositorioServico.pesquisarNomeNoRepositorioI(nome);
	}
	public int buscarServico(Servico servico) throws ObjectNaoExisteException{
		return repositorioServico.pesquisarServicoNoRepositorio(servico);
	}

	public void salvarNoArquivo(){
		repositorioServico.salvarNoArquivo();
	}
	
	public ArrayList<Servico> listarServico(){
		return repositorioServico.listarServico();
	}

}
