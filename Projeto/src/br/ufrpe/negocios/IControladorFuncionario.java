package br.ufrpe.negocios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.exceçoes.ErroAoRemoverException;
import br.ufrpe.exceçoes.ErroAoSalvarException;
import br.ufrpe.exceçoes.FuncionarioNaoExisteException;

public interface IControladorFuncionario {
	
	void cadastrar(Funcionario funcionario) throws ErroAoSalvarException, FuncionarioNaoExisteException;
	void remover(String cpf) throws FuncionarioNaoExisteException, ErroAoRemoverException;
	Funcionario pesquisar(String cpf)  throws FuncionarioNaoExisteException;
	void atualizar(Funcionario novo) throws FuncionarioNaoExisteException;
}
