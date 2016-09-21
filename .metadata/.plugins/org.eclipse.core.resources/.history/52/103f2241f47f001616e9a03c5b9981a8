package br.ufrpe.cliente;
import java.util.ArrayList;
public class RepositorioCliente {
	private ArrayList<Cliente> repositorio;
	public RepositorioCliente() {
		 repositorio = new ArrayList<>();
	}
	public RepositorioCliente(ArrayList<Cliente> repositorio){
		this.repositorio = repositorio;
	}
	public RepositorioCliente(Cliente[] repositorio){
		int i;
		this.repositorio = new ArrayList<>();
		for(i = 0; i < repositorio.length;i++){
			this.repositorio.add(repositorio[i]);
		}
	}
	public void cadastrar(Cliente outro){
		this.repositorio.add(outro);
	}
	public int getSize(){
		return this.repositorio.size();
	}
	public Cliente buscar(String cpf){
		int i;
		for(i = 0; i < this.getSize();i++){
			if(this.repositorio.get(i).getCpf().equals(cpf)){
				break;
			}
		}
		return this.repositorio.get(i);
	}
	public int buscarI(Cliente outro){
		int i;
		for(i = 0; i < this.getSize();i++){
			if(this.repositorio.get(i).equals(outro)){
				break;
			}
		}
		return i;
	}
	public void remover(Cliente outro){
		int i = this.buscarI(outro);
		this.repositorio.remove(i);
	}
}