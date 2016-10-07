package br.ufrpe.negocios;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.repositorios.RepositorioFuncionario;

public class ControladorFuncionario {
	private RepositorioFuncionario repositorioFuncionario;
	
	public ControladorFuncionario(){
		repositorioFuncionario = repositorioFuncionario.getInstanciado();
	}
	public void cadastrar(Funcionario funcionario){
		if(funcionario != null){
			Funcionario verificar = repositorioFuncionario.buscar(funcionario.getCpf());
			
			if(verificar == null){
				repositorioFuncionario.cadastrar(funcionario);
				System.out.println("\t*****Funcionario cadastrado com sucesso*****");
			}else{System.out.println("\t*****Funcionario nao cadastrado*****");}
		}else{System.out.println("\t*****Entrada Invalida*****");}
	}
	
	public void remover(String cpf){
		if(cpf != null){
			Funcionario verificar = repositorioFuncionario.buscar(cpf);
			
			if(verificar != null){
				repositorioFuncionario.remover(cpf);
				System.out.println("\t*****Funcionario removido com sucesso*****");
			}else{System.out.println("\t*****Funcionario nao cadastrado*****");}
		}else{System.out.println("\t*****Entrada Invalida****");}
	}
	
	public Funcionario pesquisar(String cpf){
		if(cpf != null){
			Funcionario verificar = repositorioFuncionario.buscar(cpf);
			
			if(verificar != null){
				return verificar;
			}else{return null;}
		}else{
			System.out.println("\t*****Entrada Invalida****");
			return null;
		}
	}
	
	public void atualizar(Funcionario novo){
		if(novo != null){
			Funcionario verificar = repositorioFuncionario.buscar(novo);
			
			if(verificar != null){
				repositorioFuncionario.atualizar(novo);
			}else{System.out.println("\t*****Funcionario nao cadastrado*****");}
		}else{System.out.println("\t*****Entrada Invalida****");}
	}
	
}
