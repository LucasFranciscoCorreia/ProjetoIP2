package br.ufrpe.negocios;
import java.util.ArrayList;

import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.*;


public class ControladorServico implements IControladorServico{
	private IRepositorioServico repositorioServico;
	
	public ControladorServico(IRepositorioServico instance){
		repositorioServico = instance;
	}
	public void salvarNoArquivo(){
		repositorioServico.salvarNoArquivo();
	}
	
	public void cadastrarServico(Servico novo)throws ObjectJaExisteException, ErroAoSalvarException{
		repositorioServico.addAoRepositorio(novo);
	}
	
	public void removerServicoNome(String codigo)throws ObjectNaoExisteException{
		repositorioServico.removerDoRepositorio(codigo);
	}
	public Servico buscarServico(String codigo)throws ObjectNaoExisteException{
		return repositorioServico.pesquisarNoRepositorio(codigo);
	}

	public void atualizarServico(Servico antigo, Servico novo)throws ErroAoAtualizarException, ObjectNaoExisteException{
		this.repositorioServico.atualizarServico(antigo, novo);
	}
	
	public ArrayList<Produto> listarServico(){
		return repositorioServico.listarServico();
	}
	

}
