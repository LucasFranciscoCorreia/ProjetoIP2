package br.ufrpe.beans;
import java.time.LocalDateTime;
public class Funcionario {
	private String nome;
	private String cpf;
	private Endereco endereco;
	private double salario;
	private LocalDateTime entrada;
	private String cargo;	
	public Funcionario(String nome, String cpf, Endereco endereco, 
			double salario, LocalDateTime entrada, String cargo){
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
	public void setNome(String nome){
		this.nome = nome;
	}	
	public void setEndereco(Endereco endereco){
		this.endereco = endereco;
	}	
	public String getEndereco(){
		return this.endereco.toString();
	}	
	public void setSalario(double salario){
		this.salario = salario;
	}	
	public double getSalario(){
		return this.salario;
	}	
	public void setEntrada(LocalDateTime entrada){
		this.entrada = entrada;
	}	
	public String getEntrada(){
		return String.format("%d/%d/%d %d:%d:%d", entrada.getYear(), entrada.getMonthValue(), entrada.getYear(), entrada.getHour(), entrada.getMinute(), entrada.getSecond());
	}	
	public boolean equals(Funcionario outro){
		return cpf.equals(outro.getCPF());
	}	
	public String toString(){
		return "Nome: " + this.nome + " - CPF: " + this.cpf + " - Cargo: " + this.cargo + 
				" - Salario: " + this.salario + " - Endereco: " + this.endereco.toString(); 
	}
}