/*
 * Projeto PetShop
 * 
 * Tipo: Cliente
 * Tipo 2: Pessoa, descri��o: abstract
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.beans;


import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta classe representa pessoas do tipo cliente, para melhor controle de venda foi desenvolvido essa classe,
 * onde se tera mais informa��es sobre os clientes. Al�m da vendo, outro fator importante de ser lembrado, � 
 * o controle de animais existentes no petshop, saber se aquele animal residente � um produto ou cliente. 
 * 
 * Lembrete: Verificar se a classe est� em perfeito estado
 * 
 * @author Lucas Correia
 * @see Pessoa
 */
public class Cliente extends Pessoa {

	private ArrayList<Animal> pets;
	
	
	/**
	 * Construtor da classe cliente 
	 * 
	 * @param cpf
	 * @param nascimento
	 * @param nome
	 * @param end
	 */
	public Cliente(String cpf, LocalDate nascimento, String nome, Endereco end) {

		super(cpf, nascimento,nome,end);
		pets = new ArrayList<>();
	}
	
	public Cliente(String cpf){
		super(cpf, null, null);
		pets = new ArrayList<>();
	}
	
	/**
	 * Adiciona um pet ao arraylist de animals
	 * @param novo
	 */
	public void addPet(Animal novo){
		this.pets.add(novo);
	}
	/**
	 * Remove o pet do ArrayList de animais.
	 * @param antigo
	 */
	public void removePet(Animal antigo){
		this.pets.remove(antigo);
	}
	
	/**
	 * Retorna os pets cadastrados pelo usuario
	 * 
	 * @return pets			atual pets
	 * 
	 * @see Animal
	 */
	
	public ArrayList<Animal> getPets(){
		return this.pets;
	}
	
	private String listarPets(){
		String pets = "";
		if(pets != null){
			for (Animal animal : this.pets) {
				pets += "\n" + animal.getNome();
			}
		}
				
		return pets;
	}
	
	public void setPets(ArrayList<Animal> pets){
		this.pets = pets;
	}
	/*public Animal[] getPets() {
		return pets;
	}*/
	
	/**
	 * Aumenta a capacidade de pets para armazenamento por cliente
	 * 
	 * @param pets		novo pets
	 */
	
	/*private void duplicarArray() {
		Animal[] novo = new Animal[pets.length*2];
		for (int i = 0; i < pets.length; i++) {
			novo[i] = pets[i];
		}
		this.pets = novo;
	}*/
	
	/**
	 * Informa todos os dados do cliente
	 * 
	 * @return res		contem nome, cpf, aniversario, endereço, pets cadastrados
	 * 
	 * @see Endereço
	 * @see Pessoa
	 * @see Animal
	 */
	@Override
	public String toString(){
		String res = String.format("Nome: %s\nCPF: %s\nData de nascimento: %s\nEndereco: %s", this.getNome(), this.getCpf(), this.DataAniversario(), this.getEnd());
		if(listarPets().length() > 0){
			res += "\nPets:\n\t" + listarPets();
		}
		
		return res;
	}
}