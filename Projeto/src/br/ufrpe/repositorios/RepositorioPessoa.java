/*
 * Projeto PetShop
 * 
 * Tipo 1: RepositorioPessoa
 * Tipo 2: IRepositorioPessoa, descri��p: interface
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.repositorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
 * RepositorioPessoa armazena todas as pessoas, independentes do tipo, 
 * em um ArrayList. Al�m do armazenamento, � possivel pesquisar, remover
 * e atualizar as informa��es cadastradas da pessoa. Nessa classe tambem 
 * ocorrem alguns verifica��es basicas, com intuito de evitar erros e 
 * inconsist�ncia de dados. 
 * 
 * @author Maria Fernanda
 * 
 * @see Funcionario
 * @see Cliente
 * @see Pessoa
 * @see IRepositorioPessoa
 * @exception PessoaNaoExisteException
 * @exception ErroAoSalvarException
 * @exception ErroAoAtualizarException
 * @exception ErroAoRemoverException
 */
public class RepositorioPessoa implements IRepositorioPessoa, Serializable{
	private ArrayList<Pessoa> repositorio;
	private static IRepositorioPessoa unicInstanc;

	/**
	 * Contrutor privado de RepositorioPessoa
	 * 
	 * @param repositorio
	 */
	private RepositorioPessoa(){
		repositorio = new ArrayList<>();
	}

	/**
	 * Construtor publico de RepositorioPessoa, seguindo o padrão singleton
	 * 
	 * @param unicInstanc   Padr�o singleton
	 * 
	 * @return unicInstanc
	 */
	public static IRepositorioPessoa getInstance(){
		if(unicInstanc == null){
			unicInstanc = lerDoArquivo();
		}
		return unicInstanc;
	}

	private static RepositorioPessoa lerDoArquivo(){
		RepositorioPessoa unicInstanc = null;

		File in = new File("Arquivos/Pessoa.data");
		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {
			fi = new FileInputStream(in);
			oi = new ObjectInputStream(fi);
			Object obj = oi.readObject();

			unicInstanc = (RepositorioPessoa) obj;
		} catch (Exception e) {
			unicInstanc = new RepositorioPessoa();
		} finally {
			if(oi != null){
				try {
					oi.close();
				} catch (IOException e){
				}
			}
		}
		return unicInstanc;
	}

	public void salvarNoArquivo() {
		if (unicInstanc == null){
			return;
		}

		File out = new File("Arquivos/Pessoa.data");
		FileOutputStream fo = null;
		ObjectOutputStream oos = null;

		try {
			fo = new FileOutputStream(out);
			oos = new ObjectOutputStream(fo);

			oos.writeObject(unicInstanc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null){
				try {
					oos.close();
				} catch (IOException e){
				}
			}
		}
	}

	/**
	 * Busca no array usando o cpf
	 * 
	 * @param cpf		
	 * @return  indice equivalente ao cpf,
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
	 * @param pessoa	
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
	 * @param cpf	
	 * 
	 * @exception ErroAoRemoverException		Exception levantada quando
	 * o metodo buscar nao encontra a pessoa 
	 */
	public void remover(String cpf) throws ErroAoRemoverException{
		if(cpf == null){
			throw new IllegalArgumentException("CPF inválido!");
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
	 * @exception ObjectNaoExisteException		Exception levantada quando
	 * o metodo buscar nao encontra a pessoa no array.
	 * 
	 * @return 	Pessoa com o cpf informado
	 */
	public Pessoa buscar(String cpf) throws ObjectNaoExisteException{
		if(cpf == null){
			throw new IllegalArgumentException("CPF inválido!");
		}else{
			int indice = buscarIndice(cpf);

			if(indice != -1){
				return this.repositorio.get(indice);
			}else{
				throw new ObjectNaoExisteException();
			}
		}		
	}

	/**
	 * Quantidade de funcionarios no sistema.
	 * 
	 * @return quantidade total de funcionarios ativos
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
	 * @return quantidade de clientes ativos
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
	 * @return quantidade total de pessoas cadastradas
	 */
	public int size(){
		return repositorio.size();
	}

	/**
	 * ArrayList com todos os clientes cadastrados
	 * 
	 * @return array com todos os clientes
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
	 * @return array com todos os funcionarios
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
	 * Atualiza informa�oes especificas de uma Pessoa
	 * 
	 * Metodo ainda incompleto, Cliente não consegue ser atualizado
	 * 
	 * @param pessoa				Pessoa que tera seus dados atualizados
	 * 
	 * @exception ObjectNaoExisteException			Exception levantada quando
	 * o metodo de pesquisa retorna -1
	 * @exception ErroAoAtualizarException			Exception levantada se a Pessoa
	 * nao for Cliente e nem Funcionario
	 * 
	 * @see Cliente
	 * @see Funcionario
	 */
	public void atualizar(Pessoa pessoa) throws ObjectNaoExisteException, 
	ErroAoAtualizarException{
		if(pessoa == null){
			throw new IllegalArgumentException("Erro ao atualizar!");
		}else{
			int indice = buscarIndice(pessoa.getCpf());

			if(indice == -1){
				throw new ObjectNaoExisteException();
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
					if (((Cliente) pessoa).getPets() != null){
						
						Cliente c = ((Cliente) repositorio.get(indice));
						c.setPets(((Cliente)pessoa).getPets());
					}if(pessoa.getEnd() != null){
						repositorio.get(indice).setEnd(pessoa.getEnd());
					}
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
	 * @return boolean que confirma se � valido ou nao
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

	@Override
	public Pessoa buscar(Login log) throws ObjectNaoExisteException {
		if(log == null){
			throw new IllegalArgumentException("Login nao encontrado");
		}else{
			for(int i = 0; i < repositorio.size();i++){
				if(repositorio.get(i) instanceof Funcionario){
					if(((Funcionario) repositorio.get(i)).getLog().equals(log)){
						return repositorio.get(i);
					}
				}
			}
		}
		return null;
	}
}
