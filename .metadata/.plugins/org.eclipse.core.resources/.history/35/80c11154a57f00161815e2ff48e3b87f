package br.ufrpe.cliente;
import java.time.LocalDate;
public class Cliente {
	private String cpf;
	private LocalDate nascimento;
	private String nome;
	private String sobrenome;
	private Endereco end;
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome){
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sobrenome = sobrenome;
		this.end = new Endereco();
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome, Endereco end) {
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.end = end;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public Endereco getEnd() {
		return end;
	}
	public void setEnd(Endereco end) {
		this.end = end;
	}
	public String getCpf() {
		return cpf;
	}
	private String DataAniversario(){
		String res = String.format("%0d/%0d/%000d", nascimento.getDayOfMonth(), nascimento.getMonth().getValue(), nascimento.getYear());
		return res;
	}
	public String toString(){
		String res = String.format("Nome: %s %s\nCPF: %s\nData de nascimento: %s\nEndereco: %s", nome, sobrenome, cpf, this.DataAniversario(), end);
		return res;
	}
	public boolean equals(Cliente outro){
		boolean res = false;
		if(cpf.equals(outro.getCpf())){
			res = true;
		}
		return res;
	}
}