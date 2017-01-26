/*
 * Projeto PetShop
 * 
 * Tipo 1: IndiceOutofBoundsException
 * 
 *Este software foi criado para fins acad�micos, visando a aprova��o na disciplina
 *Introdu��o a Programa��o II, lecionada no per�odo 2016.2, 
 *na UFRPE (Universidade Federal Rural de Pernambuco),
 *pelo professor PhD. Leandro Marques. 
 */
package br.ufrpe.excecoes ;

public class IndiceOutofBoundsException extends Exception{

	private int indiceOut;
	
	public IndiceOutofBoundsException(int indiceOut, String m){
		super(m);
		this.indiceOut = indiceOut;
		
	}
	public int getIndiceOut(){
		return this.indiceOut;
	}

}
