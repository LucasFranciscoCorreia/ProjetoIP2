/*
 * Projeto PetShop
 * 
 * Tipo: Pessoa
 *  
 *Este software foi criado para fins acadêmicos, visando a aprovação na disciplina
 *Introdução a Programação II, lecionada no período 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.beans;

import java.time.LocalDate;

/**
 * Está classe é a base para uma futura implementação de Cliente e Funcionario,
 * ela é a representação basica de uma pessoa, não importando qual o seu tipo. 
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
