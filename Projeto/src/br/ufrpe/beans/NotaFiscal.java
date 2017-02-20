package br.ufrpe.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Esta Classe representa a nota fiscal gerada pelas compras 
 * @author srtacamelo
 *
 */
public class NotaFiscal {

	private Funcionario funcionario;
	private Cliente cliente;
	private Carrinho carrinho;
	private LocalDate horaDaCompra;
	/**
	 * Construtor vazio padrão.
	 */
	public NotaFiscal(){
		
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
		this.carrinho = carrinho;
		this.horaDaCompra = LocalDate.now();
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
	@Override
	public String toString() {
		return "NotaFiscal [funcionario=" + funcionario + ", cliente=" + cliente + ", carrinho=" + carrinho
				+ ", horaDaCompra=" + horaDaCompra + "]";
	}
	
	
}
