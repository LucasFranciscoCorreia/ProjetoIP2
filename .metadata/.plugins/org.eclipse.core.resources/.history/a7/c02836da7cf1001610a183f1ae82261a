package br.ufrpe.negocios;

import br.ufrpe.repositorios.IRepositorioAnimal;
import br.ufrpe.repositorios.IRepositorioProduto;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.beans.Produto;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.*;
/* Facade */

public class FachadaControlador {
	private ControladorAnimal controladorAnimal;
	private ControladorPessoa controladorPessoa;
	private ControladorProduto controladorProduto;
	
	public FachadaControlador(IRepositorioAnimal instanceAnimal, IRepositorioProduto instanceProduto, IRepositorioPessoa instancePessoa ){
		this.controladorAnimal = new ControladorAnimal(instanceAnimal);
		this.controladorProduto = new ControladorProduto(instanceProduto );
		this.controladorPessoa = new ControladorPessoa(instancePessoa);
	}

	public void cadastrar(Animal novo) throws ObjectJaExisteException {
		controladorAnimal.cadastrar(novo);
	}

	public void remover(String codigo) throws CodigoNaoExisteException {
		controladorAnimal.remover(codigo);
	}

	public void atualizar(Animal novo, Animal antigo) throws ObjectJaExisteException, ObjectNaoExisteException {
		controladorAnimal.atualizar(novo, antigo);
	}

	public Animal buscar(String codigo) throws CodigoNaoExisteException {
		return controladorAnimal.buscar(codigo);
	}

	public boolean equals(Object arg0) {
		return controladorAnimal.equals(arg0);
	}

	public int hashCode() {
		return controladorAnimal.hashCode();
	}

	public String toString() {
		return controladorAnimal.toString();
	}

	public void cadastrar(Pessoa novo)
			throws ObjectNaoExisteException, ErroAoSalvarException, ObjectJaExisteException {
		controladorPessoa.cadastrar(novo);
	}

	public String listarCLiente() {
		return controladorPessoa.listarCLiente();
	}

	public String listarFuncionario() {
		return controladorPessoa.listarFuncionario();
	}

	public String listar() {
		return controladorPessoa.listar();
	}

	public int size() {
		return controladorPessoa.size();
	}

	public void atualizar(Pessoa novo) throws ObjectNaoExisteException, ErroAoAtualizarException {
		controladorPessoa.atualizar(novo);
	}

	public int sizeCliente() {
		return controladorPessoa.sizeCliente();
	}

	public int sizeFuncionario() {
		return controladorPessoa.sizeFuncionario();
	}

	public boolean login(String login, int senha) {
		return controladorPessoa.login(login, senha);
	}

	public void cadastrar(Produto produto) throws ObjectJaExisteException, ErroAoSalvarException {
		controladorProduto.cadastrar(produto);
	}

	public void atualizar(Produto produto) throws ObjectNaoExisteException, ErroAoAtualizarException {
		controladorProduto.atualizar(produto);
	}

	public String listarProduto() {
		return controladorProduto.listarProduto();
	}
	
	

}
