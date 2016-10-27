package br.ufrpe.negocios;
import br.ufrpe.beans.Cliente;
import br.ufrpe.exce�oes.ClienteInvalidoException;
import br.ufrpe.exce�oes.ClienteJaExisteException;
import br.ufrpe.exce�oes.ClienteNaoEncontradoException;
import br.ufrpe.exce�oes.ClienteNaoExisteException;
import br.ufrpe.exce�oes.ParametroInvalidoException;
import br.ufrpe.repositorios.IRepositorioCliente;
import br.ufrpe.repositorios.RepositorioCliente;
public class ControladorCliente implements IControladorCliente {
	private IRepositorioCliente repo;
	
	public ControladorCliente(IRepositorioCliente instance){
		repo = RepositorioCliente.getInstance();
	}
	public void cadastrar(Cliente novo) throws ClienteJaExisteException, ClienteInvalidoException{
		if (novo != null) {
			repo.cadastrar(novo);
		}else{
			throw new ClienteInvalidoException(novo);
		}
		
	}
	public void remover(String cpf) throws ClienteNaoExisteException, ClienteNaoEncontradoException, ClienteInvalidoException{
		if (cpf != null) {
			repo.remover(cpf);
		}else{
			throw new ClienteInvalidoException(cpf);
		}
	}
	public Cliente buscar(String cpf) throws ClienteNaoEncontradoException, ParametroInvalidoException{
		if (cpf != null){
			Cliente c = repo.buscar(cpf);
			if (c != null) {
				return c;
			}else{
				throw new ClienteNaoEncontradoException(cpf);
			}
		}else{
			throw new ParametroInvalidoException();
		}
	}
	public String listar(){
		return repo.listar();
	}
}