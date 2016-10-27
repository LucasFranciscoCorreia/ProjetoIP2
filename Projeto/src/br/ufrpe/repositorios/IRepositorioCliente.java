package br.ufrpe.repositorios;
import br.ufrpe.beans.Cliente;
import br.ufrpe.exce�oes.ClienteInvalidoException;
import br.ufrpe.exce�oes.ClienteJaExisteException;
import br.ufrpe.exce�oes.ClienteNaoEncontradoException;
import br.ufrpe.exce�oes.ClienteNaoExisteException;
public interface IRepositorioCliente {
	int getSize();
	Cliente buscar(String cpf) throws ClienteNaoEncontradoException;
	void cadastrar(Cliente outro) throws ClienteJaExisteException, ClienteInvalidoException;
	void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException;
	String listar();
}
