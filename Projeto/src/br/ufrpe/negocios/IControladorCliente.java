package br.ufrpe.negocios;
import br.ufrpe.beans.Cliente;
import br.ufrpe.excecoes.ClienteInvalidoException;
import br.ufrpe.excecoes.ClienteJaExisteException;
import br.ufrpe.excecoes.ClienteNaoEncontradoException;
import br.ufrpe.excecoes.ClienteNaoExisteException;
import br.ufrpe.excecoes.ParametroInvalidoException;
public interface IControladorCliente {
	void cadastrar(Cliente c) throws ClienteJaExisteException, ClienteInvalidoException;
	void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException, ClienteInvalidoException;
	Cliente buscar(String cpf) throws ClienteNaoEncontradoException, ParametroInvalidoException;
	String listar();
}