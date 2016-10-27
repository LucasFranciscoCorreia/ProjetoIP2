package br.ufrpe.negocios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.dados.IControladorFuncionario;
import br.ufrpe.dados.IRepositorioFuncionario;
import br.ufrpe.repositorios.ErroAoRemoverException;
import br.ufrpe.repositorios.ErroAoSalvarException;
import br.ufrpe.repositorios.FuncionarioNaoExisteException;

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
	public boolean login(String login, int senha){
		Login teste = new Login(login, senha);
		boolean ok = this.repositorioFuncionario.checarLogin(teste);
		System.out.println(ok);
		if(ok){
			return true;
		}else{
			return false;
		}
		
	}
}
