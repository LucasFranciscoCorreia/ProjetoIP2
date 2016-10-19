package br.ufrpe.interfaces;

import br.ufrpe.beans.Funcionario;

public interface IRepositorioFuncionario {
	
	boolean cadastrar(Funcionario funcionario);
	Funcionario buscar(Funcionario funcionario);
	Funcionario buscar(String cpf);
	boolean remover(String cpf);
	void atualizar(Funcionario Funcionario);
	int size();
}
