package br.ufrpe.cliente;
import java.time.LocalDate;
import java.util.ArrayList;

import br.ufrpe.animal.Animal;
import br.ufrpe.animal.RepositorioAnimal;
public class Cliente {
	private String cpf;
	private LocalDate nascimento;
	private String nome;
	public RepositorioAnimal getPets() {
		return pets;
	}
	private String sobrenome;
	private Endereco end;
	private RepositorioAnimal pets;
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome){
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sobrenome = sobrenome;
		this.end = new Endereco();
		this.pets = new RepositorioAnimal();
		
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome, Animal outro){
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sobrenome = sobrenome;
		this.end = new Endereco();
		this.pets = new RepositorioAnimal(outro);
		
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome, Animal[] outro){
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sobrenome = sobrenome;
		this.end = new Endereco();
		this.pets = new RepositorioAnimal(outro);
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome, ArrayList<Animal> outro){
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sobrenome = sobrenome;
		this.end = new Endereco();
		this.pets = new RepositorioAnimal(outro);
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome, Endereco end) {
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.end = end;
		this.pets = new RepositorioAnimal();
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome, Endereco end, Animal outro) {
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.end = end;
		this.pets = new RepositorioAnimal(outro);
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome, Endereco end, Animal[] outros) {
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.end = end;
		this.pets = new RepositorioAnimal(outros);
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, String sobrenome, Endereco end, ArrayList<Animal> outros) {
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.end = end;
		this.pets = new RepositorioAnimal(outros);
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