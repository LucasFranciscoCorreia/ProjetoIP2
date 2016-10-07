package br.ufrpe.beans;

import java.time.LocalDate;

public class Funcionario {
	private String nome;
	private String cpf;
	private Endereco endereco;
	private double salario;
	private LocalDate entrada;
	private String cargo;	
	
	public Funcionario(String nome, String cpf, Endereco endereco, 
			double salario, LocalDate entrada, String cargo){
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.salario = salario;
		this.entrada = entrada;
		this.cargo = cargo;
	}	
	
	public String getCargo(){
		return cargo;
	}	
	
	public void setCargo(String cargo){
		this.cargo = cargo;
	}	
	
	public String getCPF(){
		return cpf;
	}	
	
	public String getNome(){
		return nome;
	}	
	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}	
	
	public Endereco getEnderecoS(){
		return this.endereco;
	}
	
	public Endereco getEndereco(){
		return this.endereco;
	}	
	
	public void setSalario(double salario){
		this.salario = salario;
	}	
	
	public double getSalario(){
		return this.salario;
	}	
	
	public String getEntrada(){
		return String.format("%d/%d/%d", entrada.getYear(), entrada.getMonthValue(), entrada.getYear());
	}	
	
	public boolean equals(Funcionario outro){
		return cpf.equals(outro.getCPF());
	}	
	
	public String toString(){
		return "Nome: " + this.nome + " - CPF: " + this.cpf + " - Cargo: " + this.cargo + 
				" - Salario: " + this.salario + " - Endereco: " + this.endereco.toString(); 
	}
}