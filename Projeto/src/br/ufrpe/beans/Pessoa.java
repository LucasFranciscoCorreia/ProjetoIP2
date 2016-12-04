/*
 * Classe Pessoa
 * 
 * Versão 0.0.1
 * 
 * 4 de Dezembro de 2016
 * 
 * Copyright
 */
 
/*
 	*
 	*Versão: 0.0.1
 	*Data de Criação: -/-/2016
 	*Copyright (c) 2016 DEINFO/UFRPE
 	*Departamento de Estatístca e Informática 
  ()
    * UFRPE - 
    * Módulo <>
    * Todos od direitos reservados.
  *
  * Este software foi criado para fins acadêmicos, visando a aprovação na disciplina 
  * Introdução a Programação II, lecionada no período 2016.2, 
  * pelo professor PhD. Leandro Marques.
  */
/*
 * Descriação da Classe
 * 
 * Exemplo de uso:
 * 
 * > algum código aqui <
 * 
 * Limitações:
 * 
 * 
 * Autor: >não sei se é pra colocar o nome de todos, ou só de quem fez.<
 * Versão: 0.0.1
 */
	/*
	 * >Listagem dos métodos e o que cada um faz aqui<
	 */

package br.ufrpe.beans;

import java.time.LocalDate;

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
