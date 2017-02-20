package br.ufrpe.repositorios;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Interface do Repositório de Serviços
 * 
 * @author srtacamelo
 * @see Servico
 * @exception ObjetcJaExisteException
 * @exception ObjectNaoExisteException
 * @exception CodigoNaoExisteException
 * 
 */
public interface IRepositorioServico {
	
	public void addAoRepositorio(Servico servico) throws ObjectNaoExisteException, ObjectJaExisteException;
	public void removeDoRepositorio(Servico servico)throws ObjectNaoExisteException;
	public void removerDoRepositorioNome(String nome);
	public Servico pesquisarNomeNoRepositorioS(String nome) throws ObjectNaoExisteException;
	public int pesquisarNomeNoRepositorioI(String nome)throws ObjectNaoExisteException;
	public int pesquisarServicoNoRepositorio(Servico servico) throws ObjectNaoExisteException;
	public void salvarNoArquivo();
	public ArrayList<Servico> listarServico();
	public int pesquisarServicoNoRepositorio(Servico servico) throws ObjectNaoExisteException;	
}
