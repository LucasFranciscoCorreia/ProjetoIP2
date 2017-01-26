/*
 * Projeto PetShop
 * 
 * Tipo 1: IControladorPessoa
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.negocios;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.PessoaJaCadastradaException;
import br.ufrpe.excecoes.PessoaNaoExisteException;

/**
 * Esta é a interface do ControladorPessoa
 * 
 * @author Maria Fernanda
 * 
 * @see Pessoa
 * @see Animal
 * @see ControladorPessoa
 * @exception ErroAoAtualizarException
 * @exception ErroAoRemoverException
 * @exception ErroAoSalvarException
 * @exception PessoaJaCadastradaException
 * @exception PessoaNaoExisteException
 */
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
