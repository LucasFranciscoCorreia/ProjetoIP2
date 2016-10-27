package br.ufrpe.negocios;
import br.ufrpe.beans.Cliente;
import br.ufrpe.exceçoes.ClienteInvalidoException;
import br.ufrpe.exceçoes.ClienteJaExisteException;
import br.ufrpe.exceçoes.ClienteNaoEncontradoException;
import br.ufrpe.exceçoes.ClienteNaoExisteException;
import br.ufrpe.exceçoes.ParametroInvalidoException;
public interface IControladorCliente {
	void cadastrar(Cliente c) throws ClienteJaExisteException, ClienteInvalidoException;
	void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException, ClienteInvalidoException;
	Cliente buscar(String cpf) throws ClienteNaoEncontradoException, ParametroInvalidoException;
	String listar();
}
