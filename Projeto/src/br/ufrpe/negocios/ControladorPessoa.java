/*
 * Projeto PetShop
 * 
 * Tipo: ControladorPessoa
 * Tipo 2: IControladorPessoa, descri��o: interface
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.negocios;

import java.util.ArrayList;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.beans.Login;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.PessoaJaCadastradaException;
import br.ufrpe.excecoes.PessoaNaoExisteException;
import br.ufrpe.repositorios.IRepositorioPessoa;

public class ControladorPessoa implements IControladorPessoa {
	private IRepositorioPessoa repositorio;
	
	/**
	 * Contrutor de ControladorPessoa
	 * 
	 * @param instance
	 * 
	 * @see IRepositorioPessoa
	 */
	public ControladorPessoa(IRepositorioPessoa instance){
		repositorio = instance;
	}
	
	/**
	 * Faz o procedimento de busca
	 * 
	 * @param cpf
	 * 
	 * @return      Pessoa que est� sendo procurada
	 * 
	 * @exception PessoaNaoExisteException     Pessoa n�o se encontra no sistema
	 * 
	 * @see Pessoa
	 */
	public Pessoa buscar(String cpf) throws PessoaNaoExisteException{
		if(cpf == null){
			throw new IllegalArgumentException("CPF invalido!");
		}else{
			Pessoa pessoa = repositorio.buscar(cpf);
			return pessoa;
		}
	}
	
	/**
	 * Cadastra uma nova pessoa no sistema
	 * 
	 * @param novo   
	 * 
	 * @exception PessoaNaoExisteException					Utilizado para verificar se ja existe aquela pessoa no sistema  
	 * @exception ErroAoSalvarException						Possiveis erros de escrita
	 * @exception PessoaJaCadastradaException				Pessoa j� se encontra no sistema
	 */
	public void cadastrar(Pessoa novo) throws PessoaNaoExisteException, ErroAoSalvarException, PessoaJaCadastradaException{
		if(novo == null){
			throw new IllegalArgumentException("Pessoa invalida!");
		}else{
			try{
				Pessoa pesquisado = repositorio.buscar(novo.getCpf());
				if(pesquisado != null){
					throw new PessoaJaCadastradaException();					
				}
			}catch(PessoaNaoExisteException E){
				repositorio.cadastrar(novo);
			}		
		}
	}
	
	/**
	 * Remove uma pessoa por vez do sistema, utilizando o cpf da pessoa que ser� removida
	 * 
	 * @param cpf
	 * 
	 * @exception PessoaNaoExisteException				Pessoa n�o existe no sistema
	 * @exception ErroAoRemoverException				Erro ao remover
	 */
	public void remover(String cpf) throws PessoaNaoExisteException, ErroAoRemoverException{
		if(cpf == null){
			throw new IllegalArgumentException("CPF invalido!");
		}else{
			Pessoa pesquisado = repositorio.buscar(cpf);
			repositorio.remover(pesquisado.getCpf());
		}
	}
	
	/**
	 * Lista todos os clientes ativos no sistema
	 * 
	 * @return String com todos os clientes
	 */
	public String listarCLiente(){
		ArrayList<Cliente> clientes = repositorio.listarCliente();
		if(repositorio.sizeCliente() == 0){
			return "Nao existem clientes cadastrados no sistema!";
		}else{
			String resultado = "";
			for(int i = 0; i < repositorio.sizeCliente(); i++){
				resultado += clientes.get(i).toString() + "\n\n";
			}
			return resultado;
		}
	}
	
	/**
	 * Lista todos os funcionarios ativos no sistema
	 * 
	 * @return String com todos os funcionarios
	 */
	public String listarFuncionario(){
		ArrayList<Funcionario> funcionarios = repositorio.listarFuncionario();
		if(repositorio.sizeFuncionario() == 0){
			return "Nao existem funcionarios cadastrados no sistema!";
		}else{
			String resultado = "";
			for(int i = 0; i < repositorio.sizeFuncionario(); i++){
				resultado += funcionarios.get(i).toString() + "\n\n";
			}
			return resultado;
		}
	}
	
	/**
	 * Lista todas as pessoas no sistema
	 * 
	 * @return Todas as pessoas no sistema, n importando se s�o clientes ou funcionarios
	 */
	public String listar(){
		if(size() == 0){
			return "Não existem pessoas cadastradas no sistema!";
		}else{
			return repositorio.listar();
		}
	}
	
	/**
	 * Informa a quantidade de pessoas cadastradas no sistema
	 * 
	 * @return quantidade
	 */
	public int size(){
		return repositorio.size();
	}
	
	/**
	 * Atualiza informa��es de uma pessoa
	 * 
	 * @exception PessoaNaoExisteException				Pessoa n�o est� no sistema, impossivel fazer altera��o
	 * @exception ErroAoAtualizarException				
	 */
	public void atualizar(Pessoa novo) throws PessoaNaoExisteException, ErroAoAtualizarException{
		if(novo == null){
			throw new IllegalArgumentException("Pessoa invalida!");
		}else{
			repositorio.atualizar(novo);
		}
	}
	
	/**
	 * Informa a quantidade de clientes no sistema
	 * 
	 * @return quantidade
	 */
	public int sizeCliente() {
		return repositorio.sizeCliente();
	}
	
	/**
	 * Informa a quantidade de funcionarios no sistema
	 * 
	 * @return quantidade
	 */
	public int sizeFuncionario() {
		return repositorio.sizeFuncionario();
	}
	
	/**
	 * 
	 * 
	 * @param login
	 * @param senha
	 * @return TRUE/FALSE
	 */
	public boolean login(String login, int senha) {
		Login log = new Login(login, senha);
		boolean ok = false;
		if(this.repositorio.checarLogin(log)){
			ok = true;
		}
		return ok;
	}
}
