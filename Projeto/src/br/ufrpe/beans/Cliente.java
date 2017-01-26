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
	
	@Override
	public String toString(){
		String res = String.format("Nome: %s\nCPF: %s\nData de nascimento: %s\nEndereco: %s", this.getNome(), this.getCpf(), this.DataAniversario(), this.getEnd());
		res += "\nAnimais: \n";
		for(int i = 0; i < qntPets;i++){
			res+= pets[i];
		}
		return res;
	}
}