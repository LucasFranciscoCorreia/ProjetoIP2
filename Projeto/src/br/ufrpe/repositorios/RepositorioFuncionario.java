package br.ufrpe.repositorios;
import java.util.ArrayList;
import java.util.List;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Login;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.FuncionarioNaoExisteException;


public class RepositorioFuncionario implements IRepositorioFuncionario{
	private List<Funcionario> repositorio;
	private static IRepositorioFuncionario unicInstanc;
	
	//Singleton:
	private RepositorioFuncionario(){
		repositorio = new ArrayList<>();
	}	
	
	public static IRepositorioFuncionario getInstance(){
		if(unicInstanc == null){
			unicInstanc = new RepositorioFuncionario();
		}
		
		return unicInstanc;
	}
	
	//Sistema de Busca:
	private int buscarIndice(String cpf){
		for(int i = 0; i < this.repositorio.size(); i++){
			if(this.repositorio.get(i).getCpf().equals(cpf)){
				return i;
			}
		}
		return -1;
	}
	
	//CRUD:	
	public void cadastrar(Funcionario funcionario) throws ErroAoSalvarException{
		//cadastrou = true //nao cadastrou = false
		if(!this.repositorio.add(funcionario)){
			throw new ErroAoSalvarException(funcionario);
		}
	}	
	
	public Funcionario buscar(String cpf) throws FuncionarioNaoExisteException{
		int i = buscarIndice(cpf);
		if(i != -1){
			return this.repositorio.get(i);
		}else{
			throw new FuncionarioNaoExisteException(cpf);
		}
	}
	
	public void remover(String cpf) throws FuncionarioNaoExisteException, ErroAoRemoverException{
		if(cpf == null){
			throw new IllegalArgumentException("Parametro inv�lido");
		}else{
			int i = buscarIndice(cpf);
			
			if(i != -1){
				Funcionario funcionario = new Funcionario(cpf);
				//removeu com sucesso = true //falha ao remover = false;
				if(!this.repositorio.remove(funcionario)){
					throw new ErroAoRemoverException();
				}
			}else{
				throw new FuncionarioNaoExisteException(cpf);
			}
		}
	}
	
	public void atualizar(Funcionario funcionario) throws FuncionarioNaoExisteException{
		if(funcionario == null){
			throw new IllegalArgumentException("Parametro inv�lido");
		}else{
			int i = buscarIndice(funcionario.getCpf());
			if(i != -1){
				if(funcionario.getCargo() != null){
					this.repositorio.get(i).setCargo(funcionario.getCargo());					
				}if(funcionario.getEnd() != null){
					this.repositorio.get(i).setEnd(funcionario.getEnd());					
				}if(funcionario.getSalario() != 0){
					this.repositorio.get(i).setSalario(funcionario.getSalario());									
				}
			}else{
				throw new FuncionarioNaoExisteException(funcionario.getCpf());
			}
		}
	}
	
	public int size(){
		return repositorio.size();
	}

	@Override
	public boolean checarLogin(Login teste) {
		boolean ok = false;
		for(int i = 0 ; i < repositorio.size();i++){
			Login test = this.repositorio.get(i).getLog();
			if(test.equals(teste)){
				ok = true;
			}
		}
		return ok;
		
	}

}