package br.ufrpe.funcionario;

import java.util.ArrayList;

public class RepositorioFuncionario {
	private ArrayList<Funcionario> repositorio;
	
	public RepositorioFuncionario(){
		repositorio = new ArrayList<>();
	}
	
	//Adicionar um outro repositorio a esse:
	public RepositorioFuncionario(Funcionario[] repositorio){
		int i;
		this.repositorio = new ArrayList<>();
		for(i = 0; i < repositorio.length; i++){
			this.repositorio.add(repositorio[i]);
		}
	}
	
	//Adicionar um outro repositorio a esse:
	public RepositorioFuncionario(ArrayList<Funcionario> repositorio){
		this.repositorio = repositorio;
	}
	
	public void cadastrar(Funcionario funcionario){
		this.repositorio.add(funcionario);
	}
	
	public Funcionario buscar(Funcionario funcionario){
		int i;
		
		for(i = 0; i < this.repositorio.size(); i++){
			if(this.repositorio.get(i).equals(funcionario)){
				break;
			}
		}
		
		return this.repositorio.get(i);
	}
	
	public int buscarIndice(Funcionario funcionario){
		int i;
		
		for(i = 0; i < this.repositorio.size(); i++){
			if(this.repositorio.get(i).equals(funcionario)){
				break;
			}
		}
		
		return i;
	}
	
	public void remover(Funcionario funcionario){
		int i = buscarIndice(funcionario);
		
		this.repositorio.remove(i);
	}
}
