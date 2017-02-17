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
 * pois esse tipo de produto nescessita de informa��es um pouco diferentes dos outros tipos de produto.
 * 
 * Lembrete: N�o se tem certeza, se a classe esta funcionando perfeitamente
 * 
 * @see Produto
 * 
 * @author Raissa Camelo
 */
public class Remedio extends Produto{
	
	private String bula;
	private String tarja;

	public Remedio(float preco, String nome, String tipo, String codigo, int estoque,String bula, String tarja){
		
		super(preco,nome,tipo,codigo,estoque);
		this.bula = bula;
		this.tarja = tarja;
	}
	
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
	
	public String toString(){
		return super.toString()+" Bula: "+this.bula+"\nTarja: "+this.tarja;
	}
}
