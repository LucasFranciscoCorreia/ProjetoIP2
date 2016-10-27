package br.ufrpe.excecoes;
public class CaracterInvalidoException extends Exception {
	private char c;
	public CaracterInvalidoException(char c) {
		super("Caracter nao é valido");
		this.c = c;
	}
}
