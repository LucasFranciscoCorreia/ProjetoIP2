package br.ufrpe.beans;

public class Animal extends Produto{

	private boolean isAlive;
	private String especie;
	private String raca;
	private Cliente dono;
	private double peso;
	private double tamanho;
	private String categoria;
	public Animal(boolean isAlive, String especie, String raca, Pessoa dono, double peso, double tamanho,String nome,String codigo) {
		
		super(nome,codigo);
		this.isAlive = isAlive;
		this.especie = especie;
		this.raca = raca;
		this.dono = (Cliente) dono;
		this.peso = peso;
		this.tamanho = tamanho;
		this.categoria = "Paciente";
	}
	
	public Animal(float preco, String nome, String tipo, String codigo, int estoque,boolean isAlive, String especie, String raca, Pessoa dono, double peso, double tamanho){
		
		super(preco,nome,tipo,codigo,estoque);
		this.isAlive = isAlive;
		this.especie = especie;
		this.raca = raca;
		this.dono = (Cliente) dono;
		this.peso = peso;
		this.tamanho = tamanho;
		this.categoria = "Produto";
	}
	public boolean getIsAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getDonoCPF() {
		return this.dono.getCpf();
	}

	public void setDonoCPF(Cliente dono) {
		this.dono = dono;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public String getEspecie() {
		return especie;
	}

	public String getRaca() {
		return raca;
	}

	public String getDonoNome() {
		return this.dono.getNome();
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String toString(){
		String res = String.format("Dono: %s\nCPF do dono: %s\nRaça: %s\nEspecie: %s\nTamanho: %.2fM\nPeso: %.2fKg\n", dono.getNome(), dono.getCpf(), raca, especie, tamanho, peso);
		res+="Is Alive? " + isAlive +"\nCategoria: "+categoria;
		return res;
	}
	public void setDono(Cliente dono){
		this.dono = dono;
	}
	public boolean equals(Animal outro){
		boolean res = false;
		if(dono.getCpf() == outro.getDonoCPF()
				&& raca == outro.getRaca()
				&& especie == outro.getEspecie()
				&& isAlive == outro.getIsAlive()){
			res = true;
		}
		return res;
	}
}
