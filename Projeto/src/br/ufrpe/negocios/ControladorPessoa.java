package br.ufrpe.negocios;

import br.ufrpe.beans.Pessoa;
import br.ufrpe.repositorios.IRepositorioPessoa;
import br.ufrpe.repositorios.RepositorioPessoa;

public class ControladorPessoa implements IControladorPessoa {
	private IRepositorioPessoa p;
	
	public ControladorPessoa(IRepositorioPessoa instance){
		p = instance;
	}
	public Pessoa buscarPessoa(String cpf){
		Pessoa busca = p.buscar(cpf);
		if (busca == null) {
			System.out.println("Pessoa nao encontrada");
			return null;
		}
		return busca;
	}
	public void cadastrarPessoa(Pessoa novo){
		if (novo != null) {
			boolean ok = p.cadastrar(novo);
			if (!ok) {
				System.out.println("Nao foi possivel cadastrar Pessoa");
			}
		}else{
			System.out.println("Pessoa invalida para cadastro");
		}
	}
	public void removerPessoa(String cpf){
		p.remover(cpf);
	}
	public void listar(){
		System.out.println(p.listar());
	}
	
	@Override
	public boolean atualizarPessoa(Pessoa novo) {
		// TODO Auto-generated method stub
		return false;
	}
}
