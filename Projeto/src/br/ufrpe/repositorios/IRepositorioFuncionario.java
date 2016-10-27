package br.ufrpe.repositorios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.exce�oes.ErroAoRemoverException;
import br.ufrpe.exce�oes.ErroAoSalvarException;
import br.ufrpe.exce�oes.FuncionarioNaoExisteException;

public interface IRepositorioFuncionario {
	
	void cadastrar(Funcionario funcionario) throws ErroAoSalvarException;
	Funcionario buscar(String cpf) throws FuncionarioNaoExisteException;
	void remover(String cpf) throws FuncionarioNaoExisteException, ErroAoRemoverException;
	void atualizar(Funcionario funcionario) throws FuncionarioNaoExisteException;
	int size();
}
