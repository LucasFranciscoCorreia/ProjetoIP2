package br.ufrpe.repositorios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.exceçoes.ErroAoRemoverException;
import br.ufrpe.exceçoes.ErroAoSalvarException;
import br.ufrpe.exceçoes.FuncionarioNaoExisteException;

public interface IRepositorioFuncionario {
	
	void cadastrar(Funcionario funcionario) throws ErroAoSalvarException;
	Funcionario buscar(String cpf) throws FuncionarioNaoExisteException;
	void remover(String cpf) throws FuncionarioNaoExisteException, ErroAoRemoverException;
	void atualizar(Funcionario funcionario) throws FuncionarioNaoExisteException;
	int size();
}
