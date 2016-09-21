package br.ufrpe.animal;

public class Animal {

	private boolean isAlive;
	private String especie;
	private String raca;
	private String donoNome;
	private String donoCPF;
	private double peso;
	private double tamanho;
	public Animal(boolean isAlive, String especie, String raca, String donoNome, String donoCPF, double peso, double tamanho) {
		this.isAlive = isAlive;
		this.especie = especie;
		this.raca = raca;
		this.donoNome = donoNome;
		this.donoCPF = donoCPF;
		this.peso = peso;
		this.tamanho = tamanho;
	}
	public boolean getIsAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getDonoCPF() {
		return donoCPF;
	}

	public void setDonoCPF(String donoCPF) {
		this.donoCPF = donoCPF;
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
		return donoNome;
	}
	
	public String toString(){
		String res = String.format("Dono: %s\nCPF do dono: %s\nRaça: %s\nEspecie: %s\nTamanho: %f\nPeso: %f\n", donoNome, donoCPF, raca, especie, tamanho, peso);
		res+="\nIs Alive? " + isAlive;
		return res;
	}
	public boolean equals(Animal outro){
		boolean res = false;
		if(donoCPF == outro.getDonoCPF()
				&& raca == outro.getRaca()
				&& especie == outro.getEspecie()
				&& isAlive == outro.getIsAlive()){
			res = true;
		}
		return res;
	}
}
