package br.ufrpe.beans;
import br.ufrpe.beans.Carrinho;
import br.ufrpe.excecoes.ProdutoNaoExisteException;
import br.ufrpe.repositorios.*;
import java.time.*;

/**
 * Esta Classe representa a loja (serviço) fornecida pelo sistema da petShop.
 * Nela o usuário pode efetuar as compras feitas pelos clientes, armazenar as compras realizadas e creditar no caixa.
 * @author srtacamelo
 *
 */
public class Loja {
	
	private Cliente cliente;
	private Carrinho carrinho;
	private LocalDate dataCompra;
	/**
	 * Construtor básico da Loja
	 */
	public Loja(){
		this.carrinho = new Carrinho();
		this.cliente.setCpf("no-informed");
	}
	/*
	 * Construtor do cliente já cadastrado
	 */
	public Loja(Cliente cliente){
		this.carrinho = new Carrinho();
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
	 * Este método adiciona um produto ao carrinho, com sua quantidade
	 * @param produto
	 * @param quantidade
	 */
	public void addAoCarrinho(Produto produto, int quantidade){
		
		this.carrinho.adicionarAoCarrinho(quantidade, produto);
	}
	/**
	 * Este método remove o produto do carrinho, deixando '0' dele.
	 * @param produto
	 */
	public void removeDoCarrinhoTD(Produto produto){
		this.carrinho.removerDoCarrinho(produto);
	}
	/**
	 * Este método altera a quantidade de determinado item no carrinho, aumentando
	 * @param produto
	 * @param quantidade
	 */
	public void addMaisAoCarrinho(Produto produto, int quantidade){
		this.carrinho.addMaisAoCarrinho(produto, quantidade);
	}
	/**
	 * Este método altera a quantidade de determinado item no carrinho, diminuindo 
	 * @param produto
	 * @param quantidade
	 */
	public void removeMaisDoCarrinho(Produto produto, int quantidade){
		this.carrinho.removeMaisDoCarrinho(produto, quantidade);
	}
	/**
	 * Este método realiza a compra, removendo a quantidade comprada do produto do estoque.
	 * Um for-reach circula pelo array de produtos do carrinho, o produto é pesquisado no array
	 * do repositório de produtos(carrinho) e seu indice é retornado (caso o produto não exista o retorno é -1).
	 * Com o indice pegamos a quantidade comprada do produto, e setamos a quantidade do estoque para 
	 * (atual - quan. comprada). 
	 * @throws ProdutoNaoExisteException
	 */
	
	public void realizarCompra()throws ProdutoNaoExisteException{
		
		//TODO saber que antes d chamar <realizarCompra> o cliente deve ser perguntado se quer colocar o CPF
		//Caso não cadastrado
		for (Produto elemento : this.carrinho.getArrayDeProdutos()) {
			int index = this.carrinho.getArrayDeProdutos().indexOf(elemento);
			if(index != -1){
				
				int quantidadeC = this.carrinho.getArrayDeQuantidade().get(index);
				int quantidade = RepositorioProduto.getInstance().buscarP(elemento).getEstoque() - quantidadeC; 
				RepositorioProduto.getInstance().alterarDoEstoque(elemento, quantidade);
				//TODO caixa
				//TODO gerar nota fiscal
			}else{throw new ProdutoNaoExisteException();}
		}
	}
	
	//private String gerarNota(){
		//String nota = "Compra no CPF: "+ this.cliente.
		//iria implementar, mas lembrei que vamos usar a GUI
		//TODO dúvida: Devo criar uma classe "notaFiscal" que tenha um repositório onde
		//savaremos todas as compras feitas? Assim passamos tudo pra lá, aki, nessa função
		// e depois na hora de exibir na tela é só pegar as strings direto da nota fiscal
	
	
		//Simplesmente dar new em notaFiscal
	//}
	
	
		// TODO Dúvidas
			//RealizarCompra(AL produto, AL quantidade)
		/** realizarCompra tem que retornar alguma coisa, boolean (sucesso/ falha)?
		 * 	
		 * 
		 * caixa.addDinheiro
		 */

	
}
