package br.ufrpe.produtos;

import java.util.ArrayList;

public class RepositorioProduto {
	private ArrayList<Produtos> rep = new ArrayList<>();
	public void adicionar(Produtos novo){
		rep.add(novo);
	}
	public Produtos buscar(Produtos bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == bus){
				return rep.get(i);
			}
		}
		return null;
	}
	public int buscarI(Produtos bus){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == bus){
				return i;
			}
		}
		return -1;
	}
	public void remover(Produtos antigo){
		int i = buscarI(antigo);
		if(i != -1){
			remover(antigo);
		}else{
			System.out.println("Produto nao encontrado");
		}
	}
	public void atualizar(Produtos antigo, Produtos novo){
		for(int i = 0; i < rep.size();i++){
			if(rep.get(i) == antigo){
				rep.remove(i);
				rep.add(novo);
				break;
			}
		}
	}
}
