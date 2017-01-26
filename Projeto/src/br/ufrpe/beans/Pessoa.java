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
	
	/**
	 * Contrutor da classe Pessoa
	 * 
	 * @param cpf
	 * @param nascimento
	 * @param nome
	 * @param end
	 */
	public Pessoa(String cpf, LocalDate nascimento, String nome,Endereco end){
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.end = end;
	}
	
	/**
	 * Segundo construtor da classe Pessoa
	 * 
	 * @param cpf
	 * @param nome
	 * @param end
	 */
	public Pessoa(String cpf, String nome, Endereco end){
		
		this.cpf = cpf;
		this.nome = nome;
		this.end = end;
	}

	/**
	 * Retorna cpf da pessoa
	 * 
	 * @return cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Retprma a data de nascimento da pessoa
	 * 
	 * @return variavel do tipo LocalDate contendo a data de nascimento da pessoa
	 * 
	 * @see LocalDate
	 */
	public LocalDate getNascimento() {
		return nascimento;
	}

	/**
	 * Retorna o nome da pessoa
	 * 
	 * @return nome da pessoa
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * retorna o endereço da pessoa
	 * 
	 * @return endereço
	 * 
	 * @see Endereco
	 */
	public Endereco getEnd() {
		return this.end;
	}

	/**
	 * Recebe o endereço da pessoa
	 *
	 * @param end      Endereço da pessoa, do tipo Endereco
	 * 
	 * @see Endereco
	 */
	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	/**
	 * Retorna a data de aniversario da pessoa, já no formato de String (xx/xx/xxxx)
	 * 
	 * @return xx/xx/xxxx
	 */
	public String DataAniversario(){
		int dia = nascimento.getDayOfMonth();
		int mes = nascimento.getMonthValue();
		int ano = nascimento.getYear();
		String res = Integer.toString(dia) + '/' + mes + '/' + ano;
		return res;
	}
	
	/**
	 * Retorna Nome, CPF, Data de nascimento e endereço, formatada uma abaixo da outra
	 * 
	 * @return informações basicas daquela pessoa
	 */
	public String toString(){
		String res = String.format("Nome: %s\nCPF: %s\nData de nascimento: %s\nEndereco: %s", nome, cpf, this.DataAniversario(), end);
		return res;
	}
	
	/**
	 * Faz comparações utilizando o CPF
	 * 
	 * @return  True ou False
	 */
	public boolean equals(Pessoa outro){
		return (cpf.equals(outro.getCpf()));
	}

}
