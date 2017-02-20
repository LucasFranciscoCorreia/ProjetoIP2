package br.ufrpe.beans;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Esta Classe representa a nota fiscal gerada pelas compras 
 * @author srtacamelo
 *
 */
public class NotaFiscal {

	private ArrayList<Produto> itens;
	private Funcionario funcionario;
	private Cliente cliente;
	private LocalDateTime horaComeco;
	private LocalDateTime horaFim;
	/**
	 * Construtor vazio padrão.
	 */
	public NotaFiscal(){
		
	}
	/**
	 * Construtor para Nota Fiacal de serviço realizado no PetCare
	 * 
	 * @param funcionario
	 * @param cliente
	 * @param pet
	 * @param servico
	 */
	public NotaFiscal(Funcionario funcionario, Cliente cliente, Animal pet, Servico servico) {
	
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.pet = pet;

	}
	/**
	 * Construtor para Serviço <Compra>
	 * 
	 * @param funcionario
	 * @param cliente
	 * @param carrinho
	 */
	public NotaFiscal(Funcionario funcionario, Cliente cliente, Carrinho carrinho) {
		
		this.funcionario = funcionario;
		this.cliente = cliente;
	}
	
	/**
	 * Métodos Getters and Settters
	 * @return
	 * @void
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Animal getPet() {
		return pet;
	}
	public void setPet(Animal pet) {
		this.pet = pet;
	}
	
}
