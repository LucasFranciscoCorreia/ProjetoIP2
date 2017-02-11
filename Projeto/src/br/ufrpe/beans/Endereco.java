/*
 * Projeto PetShop
 * 
 * Tipo: Endereco
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.beans;

import java.io.Serializable;

/**
 * Est� classe � essencial no controle tanto de funcionario, quanto de cliente. Saber onde o funcionario reside,
 * em caso de aparecer algum imprevisto � muito importanto. No caso de clientes, chega a ser mais importante, principalmente,
 * quando esse cliente deixou algum animal na clinica. 
 * 
 * Lembrete: Pessoas podem ser cadastradas com endere�o null, mas � preferivel que n�o esteja null. 
 * 
 * @author Lucas Correia
 */
public class Endereco implements Serializable{
	
	private String rua;
	private String complemento;
	private short numero;
	private String cep;
	private String cidadeUF;
	
	public Endereco(){
		rua = "";
		complemento = "";
		cep = "";
		cidadeUF = "";
	}
	
	public Endereco(String rua, String complemento, short numero, String cep, String cidadeUF) {
		this.rua = rua;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.cidadeUF = cidadeUF;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public short getNumero() {
		return numero;
	}
	public void setNumero(short numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCidadeUF() {
		return cidadeUF;
	}
	
	public void setCidadeUF(String cidadeUF) {
		this.cidadeUF = cidadeUF;
	}
	
	public String toString(){
		String res = String.format("\nCidade-UF: %s\nRua: %s\nNumero: %d\nCEP: %s\nComplemento : %s", cidadeUF, rua, numero, cep, complemento);
		return res;
	}
	
	public boolean equals(Endereco outro){
		boolean res = false;
		if(this.rua.equals(outro.getRua())
				&& this.cep.equals(outro.getCep())
				&& this.cidadeUF.equals(outro.getCidadeUF())
				&& this.complemento.equals(outro.getComplemento())
				&& this.numero == outro.getNumero()){
			res = true;
		}
		return res;
	}
}