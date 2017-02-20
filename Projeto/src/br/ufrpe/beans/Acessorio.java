/*
 * Projeto PetShop
 * 
 * Tipo: Acessorio
 * Tipo 2: Produto, descri��o: abstract
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.beans;

import java.time.LocalDate;


/**
 * Esta classe representa produtos do tipo acessorio que possivelmente ser�o cadastrados no petshop.
 * Ela possui informações padrões que produtos devem ter.
 * 
 * Exemplo de uso: 
 * Acessorio acessorio = new Acessorio(54.99f, "Casa para cachorro", 
 * 										"Casa", "1234FG567", 10, "Variado", null, null);
 * 
 * Lembrete: Alguns produtos podem ser cadastrados com a validade igual a nulo. 
 * 
 * @author Raissa Camelo
 * @see Produto 
 */
public class Acessorio extends Produto{
     
	private String cor;
	private double tamanho;
	private LocalDate validade;
	
    
	public Acessorio(float preco, String nome, String tipo, int estoque, String cor ,double tamanho, 
			LocalDate validade) {
		super(preco, nome, "Acessório", estoque);
		this.cor = cor;
		this.tamanho = tamanho;
		this.validade = validade;
		
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */
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
		
		String resul = null;
		
		if (this.validade != null){
			resul = super.toString() + "\n" + "Cor: " + this.cor + "\nTamanho: " + this.tamanho +"cm"
					+"\nValidade: "+ this.validade + "\nCategoria: Acessório";
		}
		else {
			resul = super.toString() + "\n" + "Cor: " + this.cor + "\nTamanho: " + this.tamanho +"cm" + "\nCategoria: Acessório";
		}
		return resul;
	}
	
	
	
	

	
}
