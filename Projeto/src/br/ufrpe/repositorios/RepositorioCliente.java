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
	public boolean cadastrar(Cliente outro){
		boolean ok = true;
		if (outro != null) {
			for (int i = 0; i < repositorio.size(); i++) {
				if (outro.equals(repositorio.get(i))) {
					ok = false;
				}
			}
			if (ok) {
				this.repositorio.add(outro);			
			}
		}else{
			ok = false;
		}
		return ok;
	}
	public int getSize(){
		return this.repositorio.size();
	}
	public Cliente buscar(String cpf){
		int i;
		Cliente c = null;
		for(i = 0; i < getSize();i++){
			c = repositorio.get(i);				
			if(c.getCpf().equals(cpf)){
				return c;
			}
		}
		return c;
	}
	public Cliente buscar(int i){
		if (i >= 0 && i < repositorio.size()) {
			return this.repositorio.get(i);
		}
		return null;
	}
	private int buscarI(Cliente outro){
		int ok = -1;
		for(int i = 0; i < this.getSize();i++){
			if(this.repositorio.get(i).equals(outro)){
				ok = i;
			}
		}
		return ok;
	}
	public boolean remover(Cliente outro){
		int i = this.buscarI(outro);
		boolean ok = false;
		if (i != -1) {
			this.lixeira.add(outro);
			this.repositorio.remove(i);
			ok = true;
		}
		return ok;
	}
	public boolean atualizar(Cliente antigo, Cliente novo){
		boolean ok = true;
		if (antigo != null && novo != null) {
			int i = buscarI(antigo);
			if (i != -1) {
				this.remover(antigo);
				repositorio.add(novo);
			}else{
				ok = false;
			}
		}else{
			ok = false;
		}
		return ok;
	}
	public void listar(){
		for(int i = 0; i < repositorio.size();i++){
			System.out.println(repositorio.get(i));
		}
	}
	public Cliente recuperar(String cpf){
		for (int i = 0; i < lixeira.size(); i++) {
			if (lixeira.get(i).getCpf().equals(cpf)) {
				return lixeira.get(i);
			}
		}
		return null;
	}
}