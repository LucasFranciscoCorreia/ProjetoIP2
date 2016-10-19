package br.ufrpe.interfaces;

import br.ufrpe.beans.Funcionario;

public interface IControladorFuncionario {
	
	boolean cadastrar(Funcionario funcionario);
	boolean remover(String cpf);
	Funcionario pesquisar(String cpf);
	boolean atualizar(Funcionario novo);
}
