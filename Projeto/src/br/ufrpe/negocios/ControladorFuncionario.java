package br.ufrpe.negocios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.repositorios.RepositorioFuncionario;
import br.ufrpe.dados.IControladorFuncionario;

public class ControladorFuncionario implements IControladorFuncionario{
	private RepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario(){
		repositorioFuncionario = RepositorioFuncionario.getInstance();
	}
	public boolean cadastrar(Funcionario funcionario){
		if(funcionario != null){
			Funcionario verificar = repositorioFuncionario.buscar(funcionario.getCpf());
			
			if(verificar == null){
				repositorioFuncionario.cadastrar(funcionario);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean remover(String cpf){
		if(cpf != null){
			Funcionario verificar = repositorioFuncionario.buscar(cpf);
			
			if(verificar != null){
				repositorioFuncionario.remover(cpf);
				return true;
			}
		}
		return false;
	}
	
	public Funcionario pesquisar(String cpf){
		if(cpf != null){
			Funcionario verificar = repositorioFuncionario.buscar(cpf);
			
			if(verificar != null){
				return verificar;
			}else{return null;}
		}else{return null;}
	}
	
	public boolean atualizar(Funcionario novo){
		if(novo != null){
			Funcionario verificar = repositorioFuncionario.buscar(novo);
			
			if(verificar != null){
				repositorioFuncionario.atualizar(novo);
				return true;
			}
		}
		
		return false;
	}
	
}
