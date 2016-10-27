package br.ufrpe.beans;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	private double salario;
	private LocalDate entrada;
	private String cargo;	
	private Login log;
	
	public Funcionario(String cpf){
		super(cpf, null, null);
	}
	
	public Funcionario(String nome, String cpf, Endereco endereco, 
			double salario, LocalDate aniversario, String cargo){
		
		super(cpf,aniversario, nome,endereco);
		this.salario = salario;
		this.entrada = LocalDate.now();
		this.cargo = cargo;
		String senha;
		if(aniversario.getMonthValue() >= 10){
			senha = Integer.toString(aniversario.getDayOfMonth()) + Integer.toString(aniversario.getMonthValue()) + Integer.toString(aniversario.getYear()).charAt(2) + Integer.toString(aniversario.getYear()).charAt(3);
		}else{
			senha = Integer.toString(aniversario.getDayOfMonth()) + "0" + Integer.toString(aniversario.getMonthValue()) + Integer.toString(aniversario.getYear()).charAt(2) + Integer.toString(aniversario.getYear()).charAt(3);
		}
		log = new Login(nome, Integer.parseInt(senha));
	}	
	
	public Login getLog() {
		return log;
	}

	public void setLog(Login log) {
		this.log = log;
	}

	public String getCargo(){
		return cargo;
	}	
	
	public void setCargo(String cargo){
		this.cargo = cargo;
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
		return this.getCpf().equals(outro.getCpf());
	}	
	
	
	public String toString(){
		String res = super.toString();
		res += "\nCargo: "+this.cargo+"\nSal�rio: "+this.salario+"\nEntrada: "+this.entrada + "\nLogin: " + this.log.getLogin() + "\nSenha: " + this.log.getSenha();
		return res;
	
	}
}