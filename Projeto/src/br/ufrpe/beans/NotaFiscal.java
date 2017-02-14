package br.ufrpe.beans;

import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;
/**
 * Esta Classe representa a nota fiscal gerada do servico realizado (Compra ou Serviço PetCare) 
 * @author srtacamelo
 *
 */
public class NotaFiscal {

	private Servico servico;
	private Funcionario funcionario;
	private Cliente cliente;
	private Animal pet;
	private ArrayList<Produto> produtos;
	private ArrayList<Integer> quantidades;

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
		this.servico = servico;

	}
	/**
	 * Constrytor para Serviço <Compra>
	 * @param funcionario
	 * @param cliente
	 * @param dataComeco
	 * @param preco
	 * @param produtos
	 * @param quantidades
	 */
	public NotaFiscal(Funcionario funcionario, Cliente cliente, LocalDate dataComeco, String preco,
			ArrayList<Produto> produtos, ArrayList<Integer> quantidades) {
		
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.dataComeco = dataComeco;
		this.preco = preco;
		this.produtos = produtos;
		this.quantidades = quantidades;
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
	public LocalDate getDataComeco() {
		return dataComeco;
	}
	public void setDataComeco(LocalDate dataComeco) {
		this.dataComeco = dataComeco;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
}
