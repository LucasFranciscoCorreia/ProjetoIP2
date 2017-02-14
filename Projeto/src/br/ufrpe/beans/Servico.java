package br.ufrpe.beans;
/**
 * Esta classe representa os Serviços realizados no PetSHop
 * @author srtacamelo
 *
 */
public class Servico {
	
	private String nome;
	private double preco;
	/**
	 * Construtor de Serviços
	 * @param nome
	 * @param preco
	 */
	public Servico(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	

}
