package br.ufrpe.beans;

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
