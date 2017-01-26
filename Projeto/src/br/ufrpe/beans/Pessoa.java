/*
 * Projeto PetShop
 * 
 * Tipo: Pessoa
 *  
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.beans;

import java.time.LocalDate;

/**
 * Est� classe � a base para uma futura implementa��o de Cliente e Funcionario,
 * ela � a representa��o basica de uma pessoa, n�o importando qual o seu tipo. 
 * 
 * @author Maria Fernanda
 * @author Lucas Correia (DataAniversario)
 * 
 * @see LocalDate
 */
public abstract class Pessoa {
	
	private String cpf, nome;
	private LocalDate nascimento;
	private Endereco end;
	
	public Pessoa(String cpf, LocalDate nascimento, String nome,Endereco end){
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.end = end;
	}
	public Pessoa(String cpf, String nome, Endereco end){
		
		this.cpf = cpf;
		this.nome = nome;
		this.end = end;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public String getNome() {
		return nome;
	}
	
	public Endereco getEnd() {
		return this.end;
	}

	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	public String DataAniversario(){
		int dia = nascimento.getDayOfMonth();
		int mes = nascimento.getMonthValue();
		int ano = nascimento.getYear();
		String res = Integer.toString(dia) + '/' + mes + '/' + ano;
		return res;
	}
	
	public String toString(){
		String res = String.format("Nome: %s\nCPF: %s\nData de nascimento: %s\nEndereco: %s", nome, cpf, this.DataAniversario(), end);
		return res;
	}
	
	public boolean equals(Pessoa outro){
		return (cpf.equals(outro.getCpf()));
	}

}
