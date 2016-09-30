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
			if(this.repositorio.get(i).getCPF().equals(cpf)){
				return i;
			}
		}
		return -1;
	}
	
	private int buscarIndice(Funcionario funcionario){
		for(int i = 0; i < this.repositorio.size(); i++){
			if(this.repositorio.get(i).equals(funcionario)){
				return i;
			}
		}
		return -1;
	}
	
	//CRUD:	
	public boolean cadastrar(Funcionario funcionario){
		if(buscarIndice(funcionario.getCPF()) == -1){
			this.repositorio.add(funcionario);
			return true;
		}else{return false;}
	}	
	
	public Funcionario buscar(String cpf){
		int i = buscarIndice(cpf);
		
		if(i == -1){return null;}
		else{return this.repositorio.get(i);}
	}
	
	public Funcionario buscar(Funcionario funcionario){
		boolean achado = false;
		int i;
		
		for(i = 0; i < this.repositorio.size(); i++){
			if(this.repositorio.get(i).equals(funcionario)){
				achado = true;
				break;
			}
		}		
		
		if(!achado){return null;}
		
		return this.repositorio.get(i);
	}	
	
	public Funcionario buscar(int i){
		if(i < this.repositorio.size() && i >= 0){
			return this.repositorio.get(i);		
		}
		
		return null;
	}
	
	public boolean remover(String cpf){
		int i = buscarIndice(cpf);
		
		if(i != -1){
			this.repositorio.remove(i);
			return true;
		}else{return false;}
	}
	
	public boolean atualizar(Funcionario funcionario){
		int i = buscarIndice(funcionario);
		
		if(i != -1){
			this.repositorio.get(i).setCargo(funcionario.getCargo());
			this.repositorio.get(i).setEndereco(funcionario.getEndereco());
			this.repositorio.get(i).setSalario(funcionario.getSalario());
			
			return true;
		}else{return false;}
	}
	
	public int Size(){
		return repositorio.size();
	}
}
