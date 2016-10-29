package br.ufrpe.repositorios;
import br.ufrpe.beans.Cliente;
import br.ufrpe.excecoes.ClienteInvalidoException;
import br.ufrpe.excecoes.ClienteJaExisteException;
import br.ufrpe.excecoes.ClienteNaoEncontradoException;
import br.ufrpe.excecoes.ClienteNaoExisteException;
public interface IRepositorioCliente {
	int getSize();
	Cliente buscar(String cpf) throws ClienteNaoEncontradoException;
	void cadastrar(Cliente outro) throws ClienteJaExisteException, ClienteInvalidoException;
	void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException;
	String listar();
}
