package br.ufrpe.negocios;
import br.ufrpe.repositorios.RepositorioCliente;
import br.ufrpe.beans.Cliente;
public class ControladorCliente {
	private RepositorioCliente repo;
	public ControladorCliente(){
		repo = RepositorioCliente.getInstance();
	}
	public void cadastrar(Cliente novo){
		if (novo != null) {
			boolean ok = repo.cadastrar(novo);

			if (!ok) {
				System.out.println("Cliente ja cadastrado");
			}
			else{System.out.println("Cliente cadastrado com sucesso");
			}
		}else{
			System.out.println("Cliente invalido");
		}
	}
	public void remover(String cpf){
		if (cpf != null) {
			boolean ok = repo.remover(cpf);
			if (ok) {
				System.out.println("Cliente removido com sucesso");
			}else{
				System.out.println("Cliente nao encontrado");
			}
		}else{
			System.out.println("Cliente invalido");
		}
	}
	public void atualizar(Cliente antigo, Cliente novo){
		if (antigo != null && novo != null) {
			boolean ok = repo.remover(antigo.getCpf());
			if (ok) {
				repo.cadastrar(novo);	
				System.out.println("Usuario atualizado com sucesso");
			}else{
				System.out.println("Cliente nao encontrado");
			}
		}else{
			System.out.println("Clientes Invalidos");
		}
	}
	
	
	public Cliente buscar(String cpf){
		if (cpf != null){
			Cliente c= repo.buscar(cpf);
			if (c != null) {
				return c;
			}else{
				System.out.println("Cliente nao encontrado");
			}
		}else{
			System.out.println("CPF invaldo");
		}
		return null;
	}
	public void listar(){
		System.out.println(repo.listar());
	}
}