package br.ufrpe.beans;

import java.time.LocalDate;

public class Acessorio extends Produto{
     
	private String cor;
	private double tamanho;
	private LocalDate validade;
    
	public Acessorio(float preco, String nome, String tipo, String codigo, int estoque, String cor ,double tamanho, LocalDate validade) {
		super(preco, nome, tipo, codigo, estoque);
		this.cor = cor;
		this.tamanho = tamanho;
		this.validade = validade;
		
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
		
	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	@Override
	public String toString() {
		return super.toString() + "\n" + "Cor: " + this.cor + "\nTamanho: " + this.tamanho +"cm"
				+"\nValidade: "+ this.validade;
	}
	
	
	
	

	
}
