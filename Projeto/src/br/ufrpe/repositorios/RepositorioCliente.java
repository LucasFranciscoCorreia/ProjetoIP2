package br.ufrpe.repositorios;
import java.util.ArrayList;

import br.ufrpe.beans.Cliente;
import br.ufrpe.exce�oes.ClienteInvalidoException;
import br.ufrpe.exce�oes.ClienteJaExisteException;
import br.ufrpe.exce�oes.ClienteNaoEncontradoException;
import br.ufrpe.exce�oes.ClienteNaoExisteException;
import br.ufrpe.exce�oes.IndiceNaoEncontradoException;
public class RepositorioCliente implements IRepositorioCliente{
	private ArrayList<Cliente> repositorio;
	private static  IRepositorioCliente rep;

	private RepositorioCliente() {
		repositorio = new ArrayList<>();
	}
	public static IRepositorioCliente getInstance(){
		if (rep == null) {
			rep = new RepositorioCliente();
		}
		return rep;
	}
	public int getSize(){
		return this.repositorio.size();
	}
	public Cliente buscar(String cpf) throws ClienteNaoEncontradoException{
		for(int i = 0; i < repositorio.size();i++){
			if (repositorio.get(i).getCpf().equals(cpf)) {
				return repositorio.get(i);
			}
		}
		throw new ClienteNaoEncontradoException(cpf);
	}
	private Cliente buscar(int i) throws IndiceNaoEncontradoException{
		Cliente c = repositorio.get(i);
		if(c != null){
			return repositorio.get(i);			
		}
		throw new IndiceNaoEncontradoException(i);
	}
	public void cadastrar(Cliente outro) throws ClienteJaExisteException, ClienteInvalidoException{
		if(outro != null){
			for(int i = 0;i <repositorio.size();i++){
				if (outro.equals(repositorio.get(i))) {
					throw new ClienteJaExisteException(outro);
				}
			}
			repositorio.add(outro);
		}else{
			throw new ClienteInvalidoException(outro);
		}
	}
	public void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException{
		Cliente c;
		for(int i = 0; i < repositorio.size();i++){
			c = repositorio.get(i);
			if (c.getCpf().equals(cpf)) {
				repositorio.remove(i);
			}
		}
	}
	public String listar(){
		String res = "";
		for(int i = 0; i < repositorio.size();i++){
			res += repositorio.get(i);
		}
		return res;
	}
}