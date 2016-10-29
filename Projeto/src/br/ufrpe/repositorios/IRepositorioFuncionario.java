package br.ufrpe.repositorios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.FuncionarioNaoExisteException;

public interface IRepositorioFuncionario {
	
	void cadastrar(Funcionario funcionario) throws ErroAoSalvarException;
	Funcionario buscar(String cpf) throws FuncionarioNaoExisteException;
	void remover(String cpf) throws FuncionarioNaoExisteException, ErroAoRemoverException;
	void atualizar(Funcionario funcionario) throws FuncionarioNaoExisteException;
	int size();
	boolean checarLogin(Login teste);
}