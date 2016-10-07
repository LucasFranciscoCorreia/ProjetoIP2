package br.ufrpe.repositorios;
import java.util.ArrayList;

import br.ufrpe.beans.Cliente;
public class RepositorioCliente {
	private ArrayList<Cliente> repositorio;
	private ArrayList<Cliente> lixeira;
	private static  RepositorioCliente rep;
	private RepositorioCliente() {
		repositorio = new ArrayList<>();
		lixeira = new ArrayList<>();
	}
	public static RepositorioCliente getInstance(){
		if (rep == null) {
			rep = new RepositorioCliente();
		}
		return rep;
	}
	public int getSize(){
		return this.repositorio.size();
	}
	public Cliente buscar(String cpf){
		for(int i = 0; i < repositorio.size();i++){
			if (repositorio.get(i).getCpf().equals(cpf)) {
				return repositorio.get(i);
			}
		}
		return null;
	}
	private int buscarI(Cliente outro){
		int ok = -1;
		for(int i = 0; i < repositorio.size();i++){
			if (repositorio.get(i).equals(outro)) {
				ok = i;
			}
		}
		return ok;
	}
	public Cliente buscar(int i){
		return repositorio.get(i);
	}
	public boolean cadastrar(Cliente outro){
		boolean ok =  true;
		for(int i = 0;i <repositorio.size();i++){
			if (outro.equals(repositorio.get(i))) {
				ok = false;
			}
		}
		if (ok) {
			repositorio.add(outro);			
		}
		return ok;
	}
	public boolean remover(String cpf){
		boolean ok = false;
		Cliente c;
		for(int i = 0; i < repositorio.size();i++){
			c = repositorio.get(i);
			System.out.println(c);
			if (c.getCpf().equals(cpf)) {
				System.out.println("ok");
				lixeira.add(repositorio.get(i));
				repositorio.remove(i);
				ok = true;
			}
		}
		return ok;
	}
	public boolean atualizar(Cliente antigo, Cliente novo){
		boolean ok = false;
		for(int i = 0; i < repositorio.size();i++){
			if (antigo.equals(repositorio.get(i))) {
				ok = true;
				lixeira.add(antigo);
				repositorio.remove(i);
				repositorio.add(novo);
			}
		}
		return ok;
	}
	public Cliente recuperar(String cpf){
		for (int i = 0; i < lixeira.size(); i++) {
			if (lixeira.get(i).getCpf().equals(cpf)) {
				return lixeira.get(i);
			}
		}
		return null;
	}
	public String listar(){
		String res = "";
		for(int i = 0; i < repositorio.size();i++){
			res += repositorio.get(i);
		}
		return res;
	}
}