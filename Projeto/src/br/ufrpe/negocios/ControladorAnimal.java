package br.ufrpe.negocios;
import br.ufrpe.repositorios.AnimalJaExisteException;
import br.ufrpe.repositorios.AnimalNaoExisteException;
import br.ufrpe.repositorios.CodigoNaoExisteException;
import br.ufrpe.repositorios.RepositorioAnimal;
import br.ufrpe.beans.*;
import br.ufrpe.dados.IControladorAnimal;
import br.ufrpe.dados.IRepositorioAnimal;
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
				System.out.println("Animal não encontrado.");
			}
		}
		else{
			System.out.println("Animal inválido");
		}
	}
	
	public void atualizar(Animal novo, Animal antigo)throws AnimalJaExisteException, AnimalNaoExisteException{
		
		if(novo != null && antigo != null){
			boolean check = repositorioAnimal.atualizar(antigo, novo);
			
			if(check){
				System.out.println("Animal atualizado com Sucesso");
			}
			else{
				System.out.println("Animal não encontrado.");
			}
		}
		else{
			System.out.println("Animal inválido");
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
