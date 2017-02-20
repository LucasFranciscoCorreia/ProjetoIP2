package br.ufrpe.negocios;

import br.ufrpe.beans.NotaFiscal;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.IRepositorioNotaFiscal;

public class ControladorNotaFiscal {

	private IRepositorioNotaFiscal repositorioNotaFiscal;
	
	public ControladorNotaFiscal(IRepositorioNotaFiscal instance){
		this.repositorioNotaFiscal = instance;
	}
	
	public void adicionarNotaFiscal(NotaFiscal nova)throws ObjectNaoExisteException, ObjectJaExisteException{
		this.repositorioNotaFiscal.adicionarNotaFiscal(nova);
	}
	
	public void removerNotaFical(NotaFiscal canseiDessaBosta)throws ObjectNaoExisteException{
		this.repositorioNotaFiscal.removerNotaFical(canseiDessaBosta);
	}
	
	public void salvarNoArquivo(){
		this.repositorioNotaFiscal.salvarNoArquivo();
	}
}
