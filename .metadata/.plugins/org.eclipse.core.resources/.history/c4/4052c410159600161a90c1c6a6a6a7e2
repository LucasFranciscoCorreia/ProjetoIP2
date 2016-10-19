package br.ufrpe.beans;
import java.time.LocalDate;
public abstract class Pessoa {
	
	private String cpf;
	private LocalDate nascimento;
	private String nome;
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
	
	private String DataAniversario(){
		String res = String.format("%d/%d/%d", nascimento.getDayOfMonth(), nascimento.getMonth().getValue(), nascimento.getYear());
		return res;
	}
	
	public String toString(){
		String res = String.format("Nome: %s\nCPF: %s\nData de nascimento: %s\nEndereco: %s", nome, cpf, this.DataAniversario(), end);
		return res;
	}

}
