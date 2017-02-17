/*
 * Projeto PetShop
 * 
 * Tipo 1: IControladorPessoa
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.negocios;
import java.util.ArrayList;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Esta � a interface do ControladorPessoa
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
	
	void cadastrar(Pessoa novo) throws ObjectNaoExisteException, ErroAoSalvarException, ObjectJaExisteException;
	Pessoa buscar(String cpf) throws ObjectNaoExisteException;
	Pessoa buscar(Login log) throws ObjectNaoExisteException;
	public boolean login(String login, int senha);
	void atualizar(Pessoa novo) throws ObjectNaoExisteException, ErroAoAtualizarException;
	ArrayList<Funcionario> listarFuncionario();
	ArrayList<Cliente> listarCLiente();
	
	void salvarNoArquivo();
	int size();
	int sizeCliente();
	int sizeFuncionario();
	void remover(String cpf) throws ObjectNaoExisteException, ErroAoRemoverException;
}
