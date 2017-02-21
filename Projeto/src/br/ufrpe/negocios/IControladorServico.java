package br.ufrpe.negocios;
import java.util.ArrayList;

import br.ufrpe.beans.Produto;
import br.ufrpe.beans.Servico;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.*;

public interface IControladorServico {
	
	public void salvarNoArquivo();
	public ArrayList<Produto> listarServico();
	public void cadastrarServico(Servico novo)throws ObjectJaExisteException, ErroAoSalvarException;
	public void removerServicoNome(String nome)throws ObjectNaoExisteException;
	public Servico buscarServico(String nome)throws ObjectNaoExisteException;
	public void atualizarServico(Servico antigo, Servico novo)throws ErroAoAtualizarException, ObjectNaoExisteException;
}
