package br.ufrpe.dados;

import br.ufrpe.beans.Funcionario;

public interface IControladorFuncionario {
	
	boolean cadastrar(Funcionario funcionario);
	boolean remover(String cpf);
	Funcionario pesquisar(String cpf);
	boolean atualizar(Funcionario novo);
}
