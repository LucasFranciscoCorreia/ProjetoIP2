package br.ufrpe.dados;
import br.ufrpe.beans.Cliente;
import br.ufrpe.repositorios.ClienteInvalidoException;
import br.ufrpe.repositorios.ClienteJaExisteException;
import br.ufrpe.repositorios.ClienteNaoEncontradoException;
import br.ufrpe.repositorios.ClienteNaoExisteException;
import br.ufrpe.repositorios.IndiceNaoEncontradoException;
import br.ufrpe.repositorios.RepositorioCliente;
public interface IRepositorioCliente {
	int getSize();
	Cliente buscar(String cpf) throws ClienteNaoEncontradoException;
	Cliente buscar(int i) throws IndiceNaoEncontradoException;
	void cadastrar(Cliente outro) throws ClienteJaExisteException, ClienteInvalidoException;
	void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException;
	String listar();
}
