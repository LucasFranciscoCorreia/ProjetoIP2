package br.ufrpe.beans;
import java.time.LocalDate;

public class Cliente extends Pessoa {
	
	private Animal pets[];
	private int qntPets;
	public Animal[] getPets() {
		return pets;
	}
	public Cliente(String cpf, LocalDate nascimento, String nome, Endereco end) {
		
		super(cpf, nascimento,nome,end);
		this.pets = new Animal[1];
		this.qntPets = 0;
	}

	public void addPet(Animal novo){
		pets[qntPets] = novo;
		qntPets++;
		if (qntPets == pets.length) {
			duplicarArray();
		}
	}
	private void duplicarArray() {
		Animal[] novo = new Animal[pets.length*2];
		for (int i = 0; i < pets.length; i++) {
			novo[i] = pets[i];
		}
		this.pets = novo;
	}
	
	public boolean equals(Cliente outro){
		boolean res = false;
		if(this.getCpf().equals(outro.getCpf())){
			
			res = true;
		}
		return res;
	}
}