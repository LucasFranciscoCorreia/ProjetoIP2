package br.ufrpe.repositorios;
import br.ufrpe.beans.Cliente;
import br.ufrpe.exceçoes.ClienteInvalidoException;
import br.ufrpe.exceçoes.ClienteJaExisteException;
import br.ufrpe.exceçoes.ClienteNaoEncontradoException;
import br.ufrpe.exceçoes.ClienteNaoExisteException;
public interface IRepositorioCliente {
	int getSize();
	Cliente buscar(String cpf) throws ClienteNaoEncontradoException;
	void cadastrar(Cliente outro) throws ClienteJaExisteException, ClienteInvalidoException;
	void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException;
	String listar();
}
