package br.ufrpe.repositorios;

import br.ufrpe.beans.NotaFiscal;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

public interface IRepositorioNotaFiscal {

	public void adicionarNotaFiscal(NotaFiscal nova)throws ObjectNaoExisteException, ObjectJaExisteException;
	public void removerNotaFical(NotaFiscal canseiDessaBosta)throws ObjectNaoExisteException;
	public void salvarNoArquivo();
}
