package br.ufrpe.beans;
import br.ufrpe.beans.Carrinho;

/**
 * Esta Classe representa a loja (serviço) fornecida pelo sistema da petShop.
 * Nela o usuário pode efetuar as compras feitas pelos clientes, armazenar as compras realizadas e creditar no caixa.
 * @author srtacamelo
 *
 */
public class Loja {
	//loja tem que ser singleton tb?
	private Carrinho carrinho;
	
	public Loja(){
		this.carrinho = carrinho.getInstance(); 
	}
	
	
}
