package br.ufrpe.repositorios;

import java.util.ArrayList;

import br.ufrpe.beans.Funcionario;

public class RepositorioFuncionario {
	private ArrayList<Funcionario> repositorio;
	private static RepositorioFuncionario unicInstanc;
	
	//Singleton:
	private RepositorioFuncionario(){
		repositorio = new ArrayList<>();
	}	
	
	public static synchronized RepositorioFuncionario getInstanciado(){
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
	public void cadastrar(Funcionario funcionario){
		this.repositorio.add(funcionario);
	}	
	
	public Funcionario buscar(Funcionario funcionario){
		int i = buscarIndice(funcionario.getCpf());
		
		if(i != -1){
			return this.repositorio.get(i);
		}else{return null;}	
	}
	
	public Funcionario buscar(String cpf){
		int i = buscarIndice(cpf);
		
		if(i != -1){
			return this.repositorio.get(i);
		}else{return null;}		
	}
	
	public void remover(String cpf){
		int i = buscarIndice(cpf);
		
		this.repositorio.remove(i);
	}
	
	public void atualizar(Funcionario funcionario){
		int i = buscarIndice(funcionario.getCpf());
		this.repositorio.get(i).setCargo(funcionario.getCargo());
		this.repositorio.get(i).setEnd(funcionario.getEnd());
		this.repositorio.get(i).setSalario(funcionario.getSalario());
	}
	
	public int Size(){
		return repositorio.size();
	}
}