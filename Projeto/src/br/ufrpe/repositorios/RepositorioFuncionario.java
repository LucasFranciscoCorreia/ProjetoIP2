package br.ufrpe.repositorios;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.beans.Funcionario;
import br.ufrpe.interfaces.IRepositorioFuncionario;

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
	public boolean cadastrar(Funcionario funcionario){
		return this.repositorio.add(funcionario);
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
	
	public boolean remover(String cpf){
		Funcionario funcionario = new Funcionario(cpf);
		return this.repositorio.remove(funcionario);
	}
	
	public void atualizar(Funcionario funcionario){
		int i = buscarIndice(funcionario.getCpf());
		this.repositorio.get(i).setCargo(funcionario.getCargo());
		this.repositorio.get(i).setEnd(funcionario.getEnd());
		this.repositorio.get(i).setSalario(funcionario.getSalario());
	}
	
	public int size(){
		return repositorio.size();
	}

}