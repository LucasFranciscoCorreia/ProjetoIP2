/*
 * Projeto PetShop
 * 
 * Tipo: Animal
 * Tipo 2: Produto, descriÁ„o: abstract
 * 
 *Este software foi criado para fins acadÍmicos, visando a aprovaÁ„o na disciplina
 *IntroduÁ„o a ProgramaÁ„o II, lecionada no perÌodo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */

package br.ufrpe.beans;


/**
 * Esta classe fo criada afim de possibilitar o cadastro de "animais" na CRUD gerida 
 * pelo programa, como o projeto se trata de um gestor de pet-shop, essa classe se mostra 
 * essencial, contendo todas as caracteriscas necess√°rias para um animal, seja ele um
 * produto da loja ou um animal pertencente √† um cliente.
 * Como reparado, a classe √© uma extens√£o de produto, contudo, caso o animal cadastrado
 * em quest√£o n√£o seja um produto da loja, os parametros passados pelo construtor (e
 * consequentemente pelo "super") ser√£o inv√°lidos.
 * 
 * Exemplo de uso:
 *	Animal a = Animal(True,Cachorro(Canis Familiares), Vira-Lata, Alexandre G.,5, 100, Dede, codigo);
 *  (Esse foi um exemplo de um cadastratamento de um animal "pet", um cliente da cl√≠nica)
 *   Foi usado o primeiro construtor
 * Animal(boolean isAlive, String especie, String raca, Pessoa dono, double peso, double tamanho,String nome,String codigo);
 * (Esse foi um exemplo de um cadastramento de um animal "Produto", √† ser vendido na loja)
 *  Foi usado o segundo construtor
 * 
 * Limita√ß√µes: Essa classe se restringe ao cadastramento/ altera√ß√£o de dados do Tipo "Animal", fazendo parte do package "beans".
 * Todos os m√©todos contido nela se restringem √† altera√ß√£o das caracteristicas de um objeto instanciado na mesma.
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
		String res = String.format("Dono: %s\nCPF do dono: %s\nRa√ßa: %s\nEspecie: %s\nTamanho: %.2fM\nPeso: %.2fKg\n", dono.getNome(), dono.getCpf(), raca, especie, tamanho, peso);
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
