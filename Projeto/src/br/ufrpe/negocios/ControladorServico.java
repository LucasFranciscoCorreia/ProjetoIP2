package br.ufrpe.negocios;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.*;
public class ControladorServico {


	private IRepositorioServico repositorioServico;
	
	public ControladorServico(IRepositorioServico instance){
		this.repositorioServico = instance;
	}
	void cadastrarServico(Servico novo)throws ObjectJaExisteException,ObjectNaoExisteException{
		repositorioServico.addAoRepositorio(novo);
	}
	void removerServico(Servico servico)throws ObjectNaoExisteException{
		repositorioServico.removeDoRepositorio(servico);
	}
	void removerServicoNome(String nome)throws ObjectNaoExisteException{
		repositorioServico.removerDoRepositorioNome(nome);
	}
	Servico buscarServico(String nome)throws ObjectNaoExisteException{
		return repositorioServico.pesquisarNomeNoRepositorioS(nome);
	}
	int buscarNome(String nome)throws ObjectNaoExisteException{
		return repositorioServico.pesquisarNomeNoRepositorioI(nome);
	}
	int buscarServico(Servico servico) throws ObjectNaoExisteException{
		return repositorioServico.pesquisarServicoNoRepositorio(servico);
	}
	void atualizarServico(Servico novo, Servico antigo)throws ObjectNaoExisteException{
		
	}
	void salvarNoArquivo(){
		
	}

}
