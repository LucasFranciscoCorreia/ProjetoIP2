/*
 * Projeto PetShop
 * 
 * Tipo 1: IRepositorioPessoa
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.repositorios;
import java.util.ArrayList;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectNaoExisteException;

/**
 * Interface do RepositorioPessoa
 * 
 * @author Maria Fernanda
 *
 * @see Pessoa
 * @see Animal
 * @see Cliente
 * @see Funcionario
 * @see Login
 * @see RepositorioPessoa
 * @exception ErroAoAtualizarException
 * @exception ErroAoRemoverException
 * @exception ErroAoSalvarException
 * @exception PessoaNaoExisteException
 */

public interface IRepositorioPessoa {
	
	int size();
	int sizeFuncionario();
	int sizeCliente();
	ArrayList<Funcionario> listarFuncionario();
	ArrayList<Cliente> listarCliente();
	boolean checarLogin(Login log);
	void cadastrar(Pessoa pessoa) throws ErroAoSalvarException;
	Pessoa buscar(String cpf) throws ObjectNaoExisteException;
	Pessoa buscar(Login log) throws ObjectNaoExisteException;
	void remover(String cpf) throws ErroAoRemoverException;
	void atualizar(Pessoa p) throws ObjectNaoExisteException, ErroAoAtualizarException;
	void salvarNoArquivo();
}
