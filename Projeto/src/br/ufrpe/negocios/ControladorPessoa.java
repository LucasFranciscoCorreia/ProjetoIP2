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
	
	public ControladorPessoa(IRepositorioPessoa instance){
		repositorio = instance;
	}
	public Pessoa buscar(String cpf) throws PessoaNaoExisteException{
		if(cpf == null){
			throw new IllegalArgumentException("CPF invalido!");
		}else{
			Pessoa pessoa = repositorio.buscar(cpf);
			return pessoa;
		}
	}
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
	
	public void remover(String cpf) throws PessoaNaoExisteException, ErroAoRemoverException{
		if(cpf == null){
			throw new IllegalArgumentException("CPF invalido!");
		}else{
			Pessoa pesquisado = repositorio.buscar(cpf);
			repositorio.remover(pesquisado.getCpf());
		}
	}
	
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
	
	public String listar(){
		if(size() == 0){
			return "N�o existem pessoas cadastradas no sistema!";
		}else{
			return repositorio.listar();
		}
	}
	
	public int size(){
		return repositorio.size();
	}
	
	public void atualizar(Pessoa novo) throws PessoaNaoExisteException, ErroAoAtualizarException{
		if(novo == null){
			throw new IllegalArgumentException("Pessoa invalida!");
		}else{
			repositorio.atualizar(novo);
		}
	}
	
	public int sizeCliente() {
		return repositorio.sizeCliente();
	}
	
	public int sizeFuncionario() {
		return repositorio.sizeFuncionario();
	}
	public boolean login(String login, int senha) {
		Login log = new Login(login, senha);
		boolean ok = false;
		if(this.repositorio.checarLogin(log)){
			ok = true;
		}
		return ok;
	}
}
