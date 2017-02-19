/*
 * Projeto PetShop
 * 
 * Tipo: Remedio
 * Tipo 2: Produto, descrição: abstract
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdução a Programação II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.beans;

/**
 * Esta classe representa produtos do tipo remedio, foi nescessario criar uma classe separada para remedio, 
 * pois esse tipo de produto nescessita de informações um pouco diferentes dos outros tipos de produto.
 * 
 * 
 * @see Produto
 * 
 * @author Raissa Camelo
 */
public class Remedio extends Produto{
	
	private String bula;
	private String tarja;
	
	/**
	 * Construtor
	 * @param preco
	 * @param nome
	 * @param tipo
	 * @param codigo
	 * @param estoque
	 * @param bula
	 * @param tarja
	 */
	public Remedio(float preco, String nome, String tipo, int estoque,String bula, String tarja){
		
		super(preco,nome,tipo,estoque);
		this.bula = bula;
		this.tarja = tarja;
	}
	/**
	 * Getters and Setters
	 * @return
	 */
	public String getBula(){
		return this.bula;
	}
	
	public String getTarja(){
		return this.tarja;
	}
	public void setBula(String bula){
		this.bula = bula;
	}
	public void setTarja(String tarja){
		this.tarja = tarja;
	}
	/**
	 * Método to String
	 */
	public String toString(){
		return super.toString()+" Bula: "+this.bula+"\nTarja: "+this.tarja;
	}
}
