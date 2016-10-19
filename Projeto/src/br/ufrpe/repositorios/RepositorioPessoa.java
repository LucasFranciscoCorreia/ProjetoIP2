package br.ufrpe.repositorios;

import java.util.ArrayList;

import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.beans.Pessoa;

public class RepositorioPessoa {
	private ArrayList<Pessoa> array;
	private static RepositorioPessoa rep;
	private RepositorioPessoa(){
		array = new ArrayList<>();
	}
	public static RepositorioPessoa getInstance(){
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
	public int Size(){
		return array.size();
	}
	public String listar(){
		String res = "";
		for(int i = 0; i < array.size();i++){
			res += array.get(i) + "\n\n";
		}
		return res;
	}
}
