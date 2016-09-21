package br.ufrpe.repositorios;
import java.util.ArrayList;

import br.ufrpe.beans.Funcionario;
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
	public Funcionario buscar(int i){
		if(i < this.repositorio.size() && i >= 0){
			return this.repositorio.get(i);		
		}
		return null;
	}
	public void remover(Funcionario funcionario){
		int i = buscarIndice(funcionario);
		this.repositorio.remove(i);
	}
	public int Size(){
		return repositorio.size();
	}
}
