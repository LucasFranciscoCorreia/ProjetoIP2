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
	
	public void cadastrarServico(Servico novo)throws ObjectJaExisteException{
		repositorioServico.addAoRepositorio(novo);
	}
	
	public void removerServicoNome(String nome)throws ObjectNaoExisteException{
		repositorioServico.removerDoRepositorio(nome);
	}
	public Servico buscarServico(String nome)throws ObjectNaoExisteException{
		return repositorioServico.pesquisarNoRepositorio(nome);
	}

	public void salvarNoArquivo(){
		repositorioServico.salvarNoArquivo();
	}
	
	public ArrayList<Servico> listarServico(){
		return repositorioServico.listarServico();
	}

}
