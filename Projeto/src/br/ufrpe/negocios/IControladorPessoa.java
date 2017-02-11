/*
 * Projeto PetShop
 * 
 * Tipo 1: IControladorPessoa
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.negocios;
import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Pessoa;
import br.ufrpe.excecoes.ErroAoAtualizarException;
import br.ufrpe.excecoes.ErroAoRemoverException;
import br.ufrpe.excecoes.ErroAoSalvarException;
import br.ufrpe.excecoes.ObjectoJaExisteException;
import br.ufrpe.excecoes.ObjectoNaoExisteException;

/**
 * Esta � a interface do ControladorPessoa
 * 
 * @author Maria Fernanda
 * 
 * @see Pessoa
 * @see Animal
 * @see ControladorPessoa
 * @exception ErroAoAtualizarException
 * @exception ErroAoRemoverException
 * @exception ErroAoSalvarException
 * @exception PessoaJaCadastradaException
 * @exception PessoaNaoExisteException
 */
public interface IControladorPessoa {
	
	void cadastrar(Pessoa novo) throws ObjectoNaoExisteException, ErroAoSalvarException, ObjectoJaExisteException;
	public Pessoa buscar(String cpf) throws ObjectoNaoExisteException; 
	void atualizar(Pessoa novo) throws ObjectoNaoExisteException, ErroAoAtualizarException;
	String listar();
	String listarFuncionario();
	String listarCLiente();
	int size();
	int sizeCliente();
	int sizeFuncionario();
	void remover(String cpf) throws ObjectoNaoExisteException, ErroAoRemoverException;
}
