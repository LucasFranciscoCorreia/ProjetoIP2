package br.ufrpe.negocios;
import br.ufrpe.repositorios.RepositorioAnimal;
import br.ufrpe.beans.*;
public class ControladorAnimal {
	
	private RepositorioAnimal repositorioAnimal;
	
	public ControladorAnimal(){
		RepositorioAnimal.getInstance();
	}
	
	public void cadastrar(Animal novo){
		if (novo != null) {
			boolean check = repositorioAnimal.adicionar(novo);

			if (!check) {
				System.out.println("Animal ja cadastrado");
			}
			else{System.out.println("Animal cadastrado com sucesso");
			}
		}else{
			System.out.println("Animal invalido");
		}
	}
		
	public void remover(String codigo){
		
		if (codigo != null){
			
			if(repositorioAnimal.remover(codigo)){
				
				System.out.println("Animal Removido com sucesso");
			}
			else{
				System.out.println("Animal n�o encontrado.");
			}
		}
		else{
			System.out.println("Animal inv�lido");
		}
	}
	
	public void atualizar(Animal novo, Animal antigo){
		
		if(novo != null && antigo != null){
			boolean check = repositorioAnimal.atualizar(antigo, novo);
			
			if(check){
				System.out.println("Animal atualizado com Sucesso");
			}
			else{
				System.out.println("Animal n�o encontrado.");
			}
		}
		else{
			System.out.println("Animal inv�lido");
		}
	}
	
	//Buscar

}
