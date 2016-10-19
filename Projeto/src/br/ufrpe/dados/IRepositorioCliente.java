package br.ufrpe.dados;
import br.ufrpe.beans.Cliente;
import br.ufrpe.repositorios.RepositorioCliente;
public interface IRepositorioCliente {
	int getSize();
	Cliente buscar(String cpf);
	Cliente buscar(int i);
	boolean cadastrar(Cliente outro);
	boolean remover(String cpf);
	boolean atualizar(Cliente novo);
	String listar();
}
