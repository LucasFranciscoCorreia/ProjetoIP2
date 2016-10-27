package br.ufrpe.negocios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.exce�oes.ErroAoRemoverException;
import br.ufrpe.exce�oes.ErroAoSalvarException;
import br.ufrpe.exce�oes.FuncionarioNaoExisteException;
import br.ufrpe.repositorios.IRepositorioFuncionario;

public class ControladorFuncionario implements IControladorFuncionario{
	private IRepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario(IRepositorioFuncionario instance){
		repositorioFuncionario = instance;
	}
	public void cadastrar(Funcionario funcionario) throws ErroAoSalvarException, FuncionarioNaoExisteException{
		if(funcionario == null){
			throw new IllegalArgumentException("Parametro inv�lido");
		}else{
			Funcionario pesquisado = repositorioFuncionario.buscar(funcionario.getCpf());
			this.repositorioFuncionario.cadastrar(funcionario);
		}
	}
	
	public void remover(String cpf) throws FuncionarioNaoExisteException, ErroAoRemoverException{
		if(cpf == null){
			throw new IllegalArgumentException("Parametro inv�lido");
		}else{
			repositorioFuncionario.remover(cpf);
		}
	}
	
	public Funcionario pesquisar(String cpf) throws FuncionarioNaoExisteException{
		if(cpf == null){
			throw new IllegalArgumentException("Parametro inv�lido");
		}else{
			Funcionario pesquisado = repositorioFuncionario.buscar(cpf);				
			return pesquisado;
		}
	}
	
	public void atualizar(Funcionario novo) throws FuncionarioNaoExisteException{
		if(novo == null){
			throw new IllegalArgumentException("Parametro inv�lido");
		}else{
			Funcionario pesquisado = repositorioFuncionario.buscar(novo.getCpf());
			repositorioFuncionario.atualizar(novo);				
		}
	}
	
}
