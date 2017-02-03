/*
 * Projeto PetShop
 * 
 * Tipo: Animal
 * Tipo 2: Produto, descri��o: abstract
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.beans;


/**
 * Esta classe fo criada afim de possibilitar o cadastro de "animais" na CRUD gerida 
 * pelo programa, como o projeto se trata de um gestor de pet-shop, essa classe se mostra 
 * essencial, contendo todas as caracteriscas necessárias para um animal, seja ele um
 * produto da loja ou um animal pertencente à um cliente.
 * Como reparado, a classe é uma extensão de produto, contudo, caso o animal cadastrado
 * em questão não seja um produto da loja, os parametros passados pelo construtor (e
 * consequentemente pelo "super") serão inválidos.
 * 
 * Exemplo de uso:
 *	Animal a = Animal(True,Cachorro(Canis Familiares), Vira-Lata, Alexandre G.,5, 100, Dede, codigo);
 *  (Esse foi um exemplo de um cadastratamento de um animal "pet", um cliente da clínica)
 *   Foi usado o primeiro construtor
 * Animal(boolean isAlive, String especie, String raca, Pessoa dono, double peso, double tamanho,String nome,String codigo);
 * (Esse foi um exemplo de um cadastramento de um animal "Produto", à ser vendido na loja)
 *  Foi usado o segundo construtor
 * 
 * Limitações: Essa classe se restringe ao cadastramento/ alteração de dados do Tipo "Animal", fazendo parte do package "beans".
 * Todos os métodos contido nela se restringem à alteração das caracteristicas de um objeto instanciado na mesma.
 * 
 * @author Raissa Camelo
 * @see Produto
 */
public class Animal extends Produto{

	private boolean isAlive;
	private String especie;
	private String raca;
	private Cliente dono;
	private double peso;
	private double tamanho;
	private String categoria;

	/**
	 * Construtor da classe Animal
	 * 
	 * @param isAlive
	 * @param especie
	 * @param raca
	 * @param dono
	 * @param peso
	 * @param tamanho
	 * @param nome
	 * @param codigo
	 */
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
		String res = String.format("Dono: %s\nCPF do dono: %s\nRa�a: %s\nEspecie: %s\nTamanho: %.2fM\nPeso: %.2fKg\n", dono.getNome(), dono.getCpf(), raca, especie, tamanho, peso);
		res+="Is Alive? " + isAlive +"\nCategoria: "+categoria;
		return res;
	}
	public void setDono(Cliente dono){
		this.dono = dono;
	}
	public boolean equals(Object  outro){
		boolean res = false;
		if(outro instanceof Animal){
			if(dono.getCpf() == ((Animal)outro).getDonoCPF()
					&& raca == ((Animal)outro).getRaca()
					&& especie == ((Animal)outro).getEspecie()
					&& isAlive == ((Animal)outro).getIsAlive()){
				res = true;
			}
		}
		return res;
	}
}
