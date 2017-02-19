package br.ufrpe.negocios;
import java.util.ArrayList;

import br.ufrpe.beans.Servico;
import br.ufrpe.repositorios.*;
public interface IControladorServico {
	public void salvarNoArquivo();
	public ArrayList<Servico> listarServico();
}
