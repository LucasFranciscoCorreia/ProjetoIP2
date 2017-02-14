package br.ufrpe.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * Esta classe representa o "PetCare" espécie de loja onde serão adicionados os serviços prestados
 * aos animais (banho, tosa, etc).
 * 
 * Obs: O status do serviço será checado a partir da existência da variável "DataFim".
 * 
 * @author srtacamelo
 *
 */
public class PetCare {
	
	private Servico servico;
	private Cliente cliente;
	private Animal pet;
	private Funcionario funcionario;
	private LocalDateTime dataComeco;
	private LocalDateTime dataFim;
	
	/**
	 * Construtor vázio padrão.
	 */
	public PetCare() {
		
	}

	/**
	 * Construtor de PetCare
	 * @param servico
	 * @param cliente
	 * @param funcionario
	 */
	public PetCare(Servico servico, Cliente cliente, Funcionario funcionario,Animal pet) {
		
		this.servico = servico;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.pet = pet;
	}
	/**
	 * Inicializa o serviço
	 */
	public void comecarServico(){
		this.dataComeco = LocalDateTime.now();
	}
	
	/**
	 * Finaliza o Serviço
	 */
	public void terminarServico(){
		this.dataFim = LocalDateTime.now();
	}
	
	/**
	 * Getters and Setters
	 * @return
	 */
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	
	
}
