/*
 * Projeto PetShop
 * 
 * Tipo 1: IRepositorioPessoa
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.repositorios;
import java.util.ArrayList;

import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.beans.Login;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.PessoaNaoExisteException;

public interface IRepositorioPessoa {
	
	void cadastrar(Pessoa pessoa) throws ErroAoSalvarException;
	Pessoa buscar(String cpf) throws PessoaNaoExisteException;
	void remover(String cpf) throws ErroAoRemoverException;
	void atualizar(Pessoa p) throws PessoaNaoExisteException, ErroAoAtualizarException;
	int size();
	int sizeFuncionario();
	int sizeCliente();
	String listar();
	ArrayList<Funcionario> listarFuncionario();
	ArrayList<Cliente> listarCliente();
	boolean checarLogin(Login log);
}
