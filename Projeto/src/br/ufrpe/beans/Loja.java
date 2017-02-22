package br.ufrpe.beans;
import java.time.LocalDate;

import br.ufrpe.excecoes.ObjectNaoExisteException;
import br.ufrpe.repositorios.RepositorioProduto;

/**
 * Esta Classe representa a loja (serviço) fornecida pelo sistema da petShop.
 * Nela o usuário pode efetuar as compras feitas pelos clientes, armazenar as compras realizadas e creditar no caixa.
 * @author srtacamelo
 *
 */
public class Loja {
	
	private Cliente cliente;
	private Funcionario funcionario;
	/**
	 * Construtor básico da Loja
	 */
	public Loja(){
		this.cliente.setCpf("not-informed");
	}
	/*
	 * Construtor do cliente já cadastrado
	 */
	public Loja(Cliente cliente){
		this.cliente = cliente;
	}
	public void GetLocalDate(){
		//TODO como pegar hora do PC
		//Vai retornar um LocalDate
	}
	
	public void setCPF(String cpf){
		this.cliente.setCpf(cpf);
	}
	/**
	 * Este método realiza a compra, removendo a quantidade comprada do produto do estoque.
	 * Um for-reach circula pelo array de produtos do carrinho, o produto é pesquisado no array
	 * do repositório de produtos(carrinho) e seu indice é retornado (caso o produto não exista o retorno é -1).
	 * Com o indice pegamos a quantidade comprada do produto, e setamos a quantidade do estoque para 
	 * (atual - quan. comprada). 
	 * @throws ProdutoNaoExisteException
	 */
	
	public void realizarCompra(Carrinho compra)throws ObjectNaoExisteException{
		
		//TODO saber que antes d chamar <realizarCompra> o cliente deve ser perguntado se quer colocar o CPF
		//Caso não cadastrado
		for (Produto elemento : compra.getArrayDeProdutos()) {
			int index = compra.getArrayDeProdutos().indexOf(elemento);
			if(index != -1){
				
				int quantidadeC = compra.getArrayDeProdutos().get(index).getQuantidadeCompra();
				int quantidade = RepositorioProduto.getInstance().buscarP(elemento).getEstoque() - quantidadeC; 
				RepositorioProduto.getInstance().alterarDoEstoque(elemento, quantidade);
				
				new NotaFiscal(funcionario, cliente, compra);
			}else{throw new ObjectNaoExisteException();}
		}
	}		

	
}
