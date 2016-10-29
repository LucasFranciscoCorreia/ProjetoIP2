package br.ufrpe.negocios;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.PessoaJaCadastradaException;
import br.ufrpe.excecoes.PessoaNaoExisteException;

public interface IControladorPessoa {
	
	void cadastrar(Pessoa novo) throws PessoaNaoExisteException, ErroAoSalvarException, PessoaJaCadastradaException;
	public Pessoa buscar(String cpf) throws PessoaNaoExisteException; 
	void atualizar(Pessoa novo) throws PessoaNaoExisteException, ErroAoAtualizarException;
	String listar();
	String listarFuncionario();
	String listarCLiente();
	int size();
	int sizeCliente();
	int sizeFuncionario();
	void remover(String cpf) throws PessoaNaoExisteException, ErroAoRemoverException;
}
