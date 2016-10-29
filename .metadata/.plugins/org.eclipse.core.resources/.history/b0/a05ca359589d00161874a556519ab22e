package br.ufrpe.dados;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.repositorios.ErroAoRemoverException;
import br.ufrpe.repositorios.ErroAoSalvarException;
import br.ufrpe.repositorios.FuncionarioNaoExisteException;

public interface IControladorFuncionario {
	
	void cadastrar(Funcionario funcionario) throws ErroAoSalvarException, FuncionarioNaoExisteException;
	void remover(String cpf) throws FuncionarioNaoExisteException, ErroAoRemoverException;
	Funcionario pesquisar(String cpf)  throws FuncionarioNaoExisteException;
	void atualizar(Funcionario novo) throws FuncionarioNaoExisteException;
}
