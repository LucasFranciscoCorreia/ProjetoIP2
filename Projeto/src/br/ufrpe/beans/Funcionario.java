/*
 * Projeto PetShop
 * 
 * Tipo: Funcionario
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
 * Esta classe representa um funcionario, com cargo, salario,
 * data de entrada na empresa e um login de acesso ao sistema.
 * 
 * @author Maria Fernanda
 * @author Lucas Correia (login)
 * 
 * @see Pessoa
 * @see Login
 */
public class Funcionario extends Pessoa{
	
	private double salario;
	private LocalDate entrada;
	private String cargo;	
	private Login log;
	
	/**
	 * Construtor basico de Funcionario, contem apenas cpf
	 * 
	 * @param cpf		cpf do funcionario
	 * 
	 * @see Pessoa
	 */
	public Funcionario(String cpf){
		super(cpf, null, null);
	}
	
	/**
	 * Construtor de Funcionario
	 * 
	 * @param nome
	 * @param cpf
	 * @param endereco
	 * @param salario
	 * @param aniversario
	 * @param cargo
	 * 
	 * @see Pessoa
	 * @see Endereco
	 * 
	 * obs.: O login é o nome do funcionario
	 * obs.2:: A senha é a data de anivesario do funcionario
	 */
	public Funcionario(String nome, String cpf, Endereco endereco, 
			double salario, LocalDate aniversario, String cargo){
		
		super(cpf,aniversario, nome,endereco);
		this.salario = salario;
		this.entrada = LocalDate.now();
		this.cargo = cargo;
		String senha;
		if(aniversario.getMonthValue() >= 10){
			senha = Integer.toString(aniversario.getDayOfMonth()) + Integer.toString(aniversario.getMonthValue()) + Integer.toString(aniversario.getYear()).charAt(2) + Integer.toString(aniversario.getYear()).charAt(3);
		}else{
			senha = Integer.toString(aniversario.getDayOfMonth()) + "0" + Integer.toString(aniversario.getMonthValue()) + Integer.toString(aniversario.getYear()).charAt(2) + Integer.toString(aniversario.getYear()).charAt(3);
		}
		String login[] = nome.split(" ");
		log = new Login(login[0], Integer.parseInt(senha));
	}	
	
	/**
	 * Informa o login do funcionario
	 * 
	 * @return log		login
	 * 
	 * @see Login
	 */
	public Login getLog() {
		return log;
	}

	/**
	 * Altera o login do funcionario, ou cadastra um se o funcionario nao possuir
	 * 
	 * @param log		novo login
	 * 
	 * @see Login
	 */
	public void setLog(Login log) {
		this.log = log;
	}

	/**
	 * Informa o cargo atual do funcionario
	 * 
	 * @return cargo
	 */
	public String getCargo(){
		return cargo;
	}	
	
	/**
	 * Altera ou adiciona um cargo ao funcionario
	 * 
	 * @param cargo			novo cargo
	 */
	public void setCargo(String cargo){
		this.cargo = cargo;
	}	
	
	/**
	 * Altera ou adiciona um salario ao funcionario
	 * 
	 * @param salario		novo salario
	 */
	public void setSalario(double salario){
		this.salario = salario;
	}	
	
	/**
	 * Informa o atual salario do funcionario
	 * 
	 * @return salario 		atual salario
	 */
	public double getSalario(){
		return this.salario;
	}	
	
	/**
	 * Informa o dia de entrada na empresa
	 * 
	 * @return 				uma string no formato yyyy/mm/dd 
	 */
	public String getEntrada(){
		return String.format("%d/%d/%d", entrada.getYear(), entrada.getMonthValue(), entrada.getYear());
	}	
	
	/**
	 * Informa todos os dados do funcionario
	 * 
	 * @return res		contem cargo, salario, entrada, login e senha
	 * 
	 * @see Endereco
	 * @see Login
	 */
	@Override
	public String toString(){
		String res = super.toString();
		res += "\nCargo: "+this.cargo+"\nSalário: "+this.salario+
				"\nEntrada: "+this.entrada + "\nLogin: " + 
				this.log.getLogin() + "\nSenha: " + this.log.getSenha();
		return res;
	
	}
}