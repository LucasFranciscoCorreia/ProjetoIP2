/*
 * Projeto PetShop
 * 
 * Tipo: ControladorAnimal
 * Tipo 2: IControladorAnimal, descrição: interface
 * 
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.negocios;
import br.ufrpe.beans.Animal;
import br.ufrpe.excecoes.AnimalNaoExisteException;
import br.ufrpe.excecoes.CodigoNaoExisteException;
import br.ufrpe.excecoes.AnimalJaExisteException;
import br.ufrpe.repositorios.IRepositorioAnimal;
public class ControladorAnimal implements IControladorAnimal{
	
	private IRepositorioAnimal repositorioAnimal;
	
	public ControladorAnimal(IRepositorioAnimal instance){
		repositorioAnimal = instance;
	}
	
	public void cadastrar(Animal novo) throws AnimalJaExisteException{
		if (novo != null) {
			 repositorioAnimal.adicionar(novo);
		}
	
	}
		
	public void remover(String codigo)throws CodigoNaoExisteException{
		
		if (codigo != null){
			
			if(repositorioAnimal.remover(codigo)){
				
				System.out.println("Animal Removido com sucesso");
			}
			else{
				System.out.println("Animal nÃ£o encontrado.");
			}
		}
		else{
			System.out.println("Animal invÃ¡lido");
		}
	}
	
	public void atualizar(Animal novo, Animal antigo)throws AnimalJaExisteException, AnimalNaoExisteException{
		
		if(novo != null && antigo != null){
			boolean check = repositorioAnimal.atualizar(antigo, novo);
			
			if(check){
				System.out.println("Animal atualizado com Sucesso");
			}
			else{
				System.out.println("Animal nÃ£o encontrado.");
			}
		}
		else{
			System.out.println("Animal invÃ¡lido");
		}
	}
	
	public Animal buscar(String codigo) throws CodigoNaoExisteException{
		if (codigo != null) {
			Animal a = repositorioAnimal.buscar(codigo);
			if (a != null) {
				return a;
			}else{
				System.out.println("animal nao encontrado");
			}
		}else{
			System.out.println("Codigo incorreto");
		}
		return null;
	}

}
