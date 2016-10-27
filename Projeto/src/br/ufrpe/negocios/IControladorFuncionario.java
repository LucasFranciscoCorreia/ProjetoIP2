package br.ufrpe.negocios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.FuncionarioNaoExisteException;

public interface IControladorFuncionario {
	
	void cadastrar(Funcionario funcionario) throws ErroAoSalvarException, FuncionarioNaoExisteException;
	void remover(String cpf) throws FuncionarioNaoExisteException, ErroAoRemoverException;
	Funcionario pesquisar(String cpf)  throws FuncionarioNaoExisteException;
	void atualizar(Funcionario novo) throws FuncionarioNaoExisteException;
}
