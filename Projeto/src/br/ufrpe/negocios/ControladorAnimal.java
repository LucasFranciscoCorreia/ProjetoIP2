/*
 * Projeto PetShop
 * 
 * Tipo: ControladorAnimal
 * Tipo 2: IControladorAnimal, descri��o: interface
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.negocios;
import br.ufrpe.beans.Animal;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.ObjectJaExisteException;
import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.IRepositorioAnimal;
public class ControladorAnimal implements IControladorAnimal{
	
	private IRepositorioAnimal repositorioAnimal;

	public ControladorAnimal(IRepositorioAnimal instance){
		repositorioAnimal = instance;
	}
	
	public void salvarNoArquivo(){
		repositorioAnimal.salvarNoArquivo();
	}
	
	public void cadastrar(Animal novo) throws ObjectJaExisteException{
		if (novo != null) {
			 repositorioAnimal.adicionar(novo);
		}
	
	}
		
	public void remover(String codigo)throws CodigoNaoExisteException{
		
		if (codigo != null){
			
			if(repositorioAnimal.remover(codigo)){

			}

		}
		
	}
	
	public void atualizar(Animal novo, Animal antigo)throws ObjectJaExisteException, ObjectNaoExisteException{
			repositorioAnimal.atualizar(antigo, novo);
		
	}
	
	public Animal buscar(String codigo) throws CodigoNaoExisteException{
			Animal a = repositorioAnimal.buscar(codigo);
	}
		

}
