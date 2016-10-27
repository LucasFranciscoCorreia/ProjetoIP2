package br.ufrpe.negocios;
import br.ufrpe.beans.Cliente;
import br.ufrpe.exce�oes.ClienteInvalidoException;
import br.ufrpe.exce�oes.ClienteJaExisteException;
import br.ufrpe.exce�oes.ClienteNaoEncontradoException;
import br.ufrpe.exce�oes.ClienteNaoExisteException;
import br.ufrpe.exce�oes.ParametroInvalidoException;
public interface IControladorCliente {
	void cadastrar(Cliente c) throws ClienteJaExisteException, ClienteInvalidoException;
	void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException, ClienteInvalidoException;
	Cliente buscar(String cpf) throws ClienteNaoEncontradoException, ParametroInvalidoException;
	String listar();
}
