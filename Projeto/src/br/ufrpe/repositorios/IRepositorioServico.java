package br.ufrpe.repositorios;
import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import java.util.ArrayList;

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
	
	public void addAoRepositorio(Servico servico) throws ObjectJaExisteException, ErroAoSalvarException;
	public void removerDoRepositorio(String nome)throws ObjectNaoExisteException;
	public Servico pesquisarNoRepositorio(String nome) throws ObjectNaoExisteException;
	public void atualizarServico(Servico antigo, Servico novo)throws ErroAoAtualizarException, ObjectNaoExisteException;
	public void salvarNoArquivo();
	public ArrayList<Produto> listarServico();
}
