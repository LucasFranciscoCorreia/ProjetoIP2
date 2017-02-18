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

import java.io.Serializable;
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
public abstract class Pessoa implements Serializable{
	
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
	 * Recebe o cpf da pessoa
	 * 
	 * @param cpf
	 */
	public void setCpf(String cpf){
		this.cpf = cpf;
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
	 * retorna o endere�o da pessoa
	 * 
	 * @return endere�o
	 * 
	 * @see Endereco
	 */
	public Endereco getEnd() {
		return this.end;
	}

	/**
	 * Recebe o endere�o da pessoa
	 *
	 * @param end      Endere�o da pessoa, do tipo Endereco
	 * 
	 * @see Endereco
	 */
	public void setEnd(Endereco end) {
		this.end = end;
	}
	
	/**
	 * Retorna a data de aniversario da pessoa, j� no formato de String (xx/xx/xxxx)
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
	 * Retorna Nome, CPF, Data de nascimento e endere�o, formatada uma abaixo da outra
	 * 
	 * @return informa��es basicas daquela pessoa
	 */
	public String toString(){
		String res = String.format("Nome: %s\nCPF: %s\nData de nascimento: %s\nEndereco: %s", nome, cpf, this.DataAniversario(), end);
		return res;
	}
	
	/**
	 * Faz compara��es utilizando o CPF
	 * 
	 * @return  True ou False
	 */
	public boolean equals(Object outro){
		if(outro instanceof Cliente || outro instanceof Funcionario){
			return (cpf.equals(((Pessoa) outro).getCpf()));			
		}
		return false;
	}

}
