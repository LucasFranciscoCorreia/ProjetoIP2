package br.ufrpe.negocios;
import br.ufrpe.repositorios.*;
public class ControladorServico {

	private IRepositorioServico repositorioServico;
	
	public ControladorServico(IRepositorioServico instance){
		this.repositorioServico = instance;
	}
}
