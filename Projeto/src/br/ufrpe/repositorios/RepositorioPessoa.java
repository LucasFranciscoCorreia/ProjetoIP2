/*
 * Projeto PetShop
 * 
 * Tipo 1: RepositorioPessoa
 * Tipo 2: IRepositorioPessoa, descriçãp: interface
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

/**
 * RepositorioPessoa armazena todas as pessoas, independentes do tipo, 
 * em um ArrayList. Nessa classe tambem ocorrem alguns verificações basicas,
 * com intuito de evitar erros e inscosistencia de dados.
 * 
 * @see Funcionario
 * @see Cliente
 * @see Pessoa
 * 
 * @author Maria Fernanda
 */

public class RepositorioPessoa implements IRepositorioPessoa{
	private ArrayList<Pessoa> repositorio;
	private static IRepositorioPessoa unicInstanc;
	
	/**
	 * Construtor privado
	 */
	private RepositorioPessoa(){
		repositorio = new ArrayList<>();
	}
	
	public static IRepositorioPessoa getInstance(){
		if(unicInstanc == null){
			unicInstanc = new RepositorioPessoa();
		}
		return unicInstanc;
	}
	
	/**
	 * Busca no array usando o cpf
	 * 
	 * @param cpf			cpf da pessoa
	 * @return				indice equivalente ao cpf,
	 *  -1 significa pessoa nao encontrada
	 */
	private int buscarIndice(String cpf){
		for(int i = 0; i < this.repositorio.size(); i++){
			if(this.repositorio.get(i).getCpf().equals(cpf)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Cadastra uma pessoa
	 * 
	 * @param pessoa			pessoa que sera cadastrada
	 * 
	 * @exception ErroAoSalvarException		Exception levantada quando
	 *  o repositorio.add retorna falso. 
	 */
	public void cadastrar(Pessoa pessoa) throws ErroAoSalvarException{
		if(pessoa == null){
			throw new IllegalArgumentException("Erro ao salvar!");
		}else{
			if(!this.repositorio.add(pessoa)){
				throw new ErroAoSalvarException(pessoa);
			}
		}
	}
	
	/**
	 * Remove uma pessoa
	 * 
	 * @param cpf			cpf da pessoa que sera removida
	 * 
	 * @exception ErroAoRemoverException		Exception levantada quando
	 * o metodo buscar nao encontra a pessoa 
	 */
	public void remover(String cpf) throws ErroAoRemoverException{
		if(cpf == null){
			throw new IllegalArgumentException("CPF invï¿½lido!");
		}else{
			int indice = buscarIndice(cpf);
			
			if(indice != -1){
				this.repositorio.remove(indice);
			}else{
				throw new ErroAoRemoverException();
			}
		}
	}
	
	/**
	 * Busca por uma pessoa
	 * 
	 * @param cpf
	 * 
	 * @exception PessoaNaoExisteException			Exception levantada quando
	 * o metodo buscar nao encontra a pessoa no array.
	 * 
	 * @return repositorio.get(indice)				Pessoa com o cpf informado
	 */
	public Pessoa buscar(String cpf) throws PessoaNaoExisteException{
		if(cpf == null){
			throw new IllegalArgumentException("CPF invï¿½lido!");
		}else{
			int indice = buscarIndice(cpf);
			
			if(indice != -1){
				return this.repositorio.get(indice);
			}else{
				throw new PessoaNaoExisteException();
			}
		}		
	}
	
	/**
	 * Quantidade de funcionarios no sistema.
	 * 
	 * @return funcionario		quantidade total de funcionarios ativos
	 * 
	 * @see Funcionario
	 */
	public int sizeFuncionario(){
		int funcionario = 0;
		for(int i = 0; i < size(); i++){
			if(repositorio.get(i) instanceof Funcionario){
				funcionario++;
			}
		}
		return funcionario;
	}
	
	/**
	 * Quantidade de clientes no sistema
	 * 
	 * @return cliente			quantidade de clientes ativos
	 * 
	 * @see Cliente
	 */
	public int sizeCliente(){
		int cliente = 0;
		for(int i = 0; i < size(); i++){
			if(repositorio.get(i) instanceof Cliente){
				cliente++;
			}
		}
		return cliente;
	}
	
	/**
	 * Quantidade de Pessoas, independente se sejao clientes ou funcionarios
	 * 
	 * @return repositorio.size()
	 */
	public int size(){
		return repositorio.size();
	}
	
	/**
	 * ArrayList com todos os clientes cadastrados
	 * 
	 * @return clientes 			array com todos os clientes
	 * 
	 * @see Cliente
	 */
	public ArrayList<Cliente> listarCliente(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		for(int i = 0; i < size(); i++){
			if(repositorio.get(i) instanceof Cliente){
				clientes.add(((Cliente) repositorio.get(i)));
			}
		}
		return clientes;
	}
	
	/**
	 * ArrayList com todos os funcionarios cadastrados
	 * 
	 * @return funcionario			array com todos os funcionarios
	 * 
	 * @see Funcionario
	 */
	public ArrayList<Funcionario> listarFuncionario(){
		ArrayList<Funcionario> funcionarios = new ArrayList<>();
		for(int i = 0; i < size(); i++){
			if(repositorio.get(i) instanceof Funcionario){
				funcionarios.add(((Funcionario) repositorio.get(i)));
			}
		}
		return funcionarios;
	}
	
	/**
	 * Lista com todas as pessoas ativas
	 * 
	 * @return res				todas as pessoas listadas, um abaixo da outra
	 */
	public String listar(){
		String res = "";
		for(int i = 0; i < repositorio.size();i++){
			res += repositorio.get(i) + "\n\n";
		}
		return res;
	}
	
	/**
	 * Atualiza informaçoes especificas de uma Pessoa
	 * 
	 * @param pessoa				Pessoa que tera seus dados atualizados
	 * 
	 * @exception PessoaNaoExisteException			Exception levantada quando
	 * o metodo de pesquisa retorna -1
	 * @exception ErroAoAtualizarException			Exception levantada se a Pessoa
	 * nao for Cliente e nem Funcionario
	 * 
	 * @see Cliente
	 * @see Funcionario
	 */
	
	//INCOMPLETO codigo
	public void atualizar(Pessoa pessoa) throws PessoaNaoExisteException, 
			ErroAoAtualizarException{
		if(pessoa == null){
			throw new IllegalArgumentException("Erro ao atualizar!");
		}else{
			int indice = buscarIndice(pessoa.getCpf());
			
			if(indice == -1){
				throw new PessoaNaoExisteException();
			}else{
				if(pessoa instanceof Funcionario){
					if(((Funcionario) pessoa).getCargo() != null){
						((Funcionario) repositorio.get(indice)).setCargo(((Funcionario) pessoa).getCargo());	
					}if(pessoa.getEnd() != null){
						repositorio.get(indice).setEnd(pessoa.getEnd());
					}if(((Funcionario) pessoa).getSalario() != 0){
						((Funcionario) repositorio.get(indice)).setSalario(((Funcionario) pessoa).getSalario());			
					}
				}else if(pessoa instanceof Cliente){
					//repositorio.get(indice) = pessoa;
				}else{
					throw new ErroAoAtualizarException();
				}				
			}
		}
	}
	
	/**
	 * Checa se o login for valido
	 * 
	 * @param l				login que sera analisado
	 * 
	 * @return ok			boolean que confirma se é valido ou nao
	 * 
	 * @see Login
	 */
	@Override
	public boolean checarLogin(Login l) {
		boolean ok = false;
		for(int i = 0; i < repositorio.size();i++){
			if(this.repositorio.get(i) instanceof Funcionario){
				if (((Funcionario) this.repositorio.get(i)).getLog().equals(l)) {
					ok =  true;
				}
			}
		}
		return ok;
	}
}
