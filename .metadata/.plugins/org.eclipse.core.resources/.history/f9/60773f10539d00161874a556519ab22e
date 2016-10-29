package br.ufrpe.repositorios;

import java.util.ArrayList;

import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.dados.IRepositorioPessoa;

public class RepositorioPessoa implements IRepositorioPessoa{
	private ArrayList<Pessoa> array;
	private static IRepositorioPessoa rep;
	
	private RepositorioPessoa(){
		array = new ArrayList<>();
	}
	public static IRepositorioPessoa getInstance(){
		if(rep == null){
			rep = new RepositorioPessoa();
		}
		return rep;
	}
	public boolean cadastrar(Pessoa p){
		for(int i = 0; i < array.size();i++){
			if (p.equals(array.get(i))) {
				return false;
			}
		}
		array.add(p);
		return true;
	}
	public boolean remover(String cpf){
		for(int i = 0; i < array.size();i++){
			if (cpf.equals(array.get(i).getCpf())) {
				array.remove(i);
				return true;
			}
		}
		return false;
	}
	public Pessoa buscar(String cpf){
		for(int i = 0; i < array.size(); i++){
			if (array.get(i).getCpf().equals(cpf)) {
				return array.get(i);
			}
		}
		return null;
	}
	public int size(){
		return array.size();
	}
	public String listar(){
		String res = "";
		for(int i = 0; i < array.size();i++){
			res += array.get(i) + "\n\n";
		}
		return res;
	}
	
	public boolean atualizar(Pessoa p) {
		// TODO Auto-generated method stub
		return false;
	}
}
