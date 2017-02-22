package br.ufrpe.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
/**
 * Esta classe representa o "PetCare" espécie de loja onde serão adicionados os serviços prestados
 * aos animais (banho, tosa, etc).
 * 
 * Obs: O status do serviço será checado a partir da existência da variável "DataFim".
 * 
 * @author srtacamelo
 *
 */
public class PetCare implements Serializable{
	
	private Servico servico;
	private Cliente cliente;
	private Animal pet;
	private Funcionario funcionario;
	private LocalDateTime dataComeco;
	private LocalDateTime dataFim;
	
	private String dataCom;
	private String dataFi;
	private String nomeServico;
	private float precoServico;
	private String nomeCliente;
	private String cpfCliente;
	private String nomeAnimal;
	private String especieAnimal;
	private String nomeFuncionario;
	
	
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
		this.dataComeco = LocalDateTime.now();
		this.dataFim = null;
		gerarVariaveisDesnecessariasPraGambiarraPqNaoFunfaNaGUI();
	}
	/**
	 * Construtor II
	 * @param servico
	 * @param cliente
	 * @param pet
	 */
	public PetCare(Servico servico, Cliente cliente,Animal pet) {
		
		this.servico = servico;
		this.cliente = cliente;
		this.pet = pet;
		this.dataComeco = LocalDateTime.now();
		gerarVariaveisDesnecessariasPraGambiarraPqNaoFunfaNaGUI();
	}
	/**
	 * Função inútil para variáveis desnecessárias, mas que precisamos por que GUI é um bug mental.
	 */
	private void gerarVariaveisDesnecessariasPraGambiarraPqNaoFunfaNaGUI(){
		
		this.nomeServico = this.servico.getNome();
		this.precoServico = this.servico.getPreco();
		this.nomeCliente = this.cliente.getNome();
		this.cpfCliente = this.cliente.getCpf();
		this.nomeAnimal = this.pet.getNome();
		this.especieAnimal = this.pet.getEspecie();
		this.nomeFuncionario = this.funcionario.getNome();
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
	public String getDataFi(){
		DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
		dataFi = dataFim.format(formatador);
		return dataFi;
	}
	
	public String getDataCom(){
		DateTimeFormatter formatador = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("pt", "br"));
		dataCom = dataComeco.format(formatador);
		
		return dataCom;
	}
	
	public String getNomeServico(){
		return nomeServico;
	}
	
	
	public float getPrecoServico() {
		return precoServico;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public String getEspecieAnimal() {
		return especieAnimal;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

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

	public Animal getPet() {
		return pet;
	}

	public void setPet(Animal pet) {
		this.pet = pet;
	}

	public LocalDateTime getDataComeco() {
		return dataComeco;
	}

	public void setDataComeco(LocalDateTime dataComeco) {
		this.dataComeco = dataComeco;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataComeco == null) ? 0 : dataComeco.hashCode());
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((pet == null) ? 0 : pet.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		return result;
	}
	
	@Override
	public String toString(){
		return nomeServico + " REALIZADO POR " + nomeFuncionario + " PARA O CLIENTE " + nomeCliente 
				+ " DO CPF " + cpfCliente;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PetCare other = (PetCare) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataComeco == null) {
			if (other.dataComeco != null)
				return false;
		} else if (!dataComeco.equals(other.dataComeco))
			return false;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (pet == null) {
			if (other.pet != null)
				return false;
		} else if (!pet.equals(other.pet))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		return true;
	}
	
}
