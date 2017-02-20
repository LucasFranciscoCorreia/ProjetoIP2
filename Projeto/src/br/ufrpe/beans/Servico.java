package br.ufrpe.beans;
/**
 * Esta classe representa os Serviços realizados no PetSHop
 * @author srtacamelo
 *
 */
public class Servico extends Produto{
	
	/**
	 * Construtor de Serviços
	 * @param nome
	 * @param preco
	 */
	public Servico(String nome, float preco) {
		super( preco,  nome, "Serviço", 0);
	}	
	/**
	 * Método equals
	 * @param servico
	 * @return
	 */
	public boolean equals(Servico servico){
		return super.equals(servico);
	}
}
