package br.ufrpe.excecoes;
public class CaracterInvalidoException2 extends Exception {
	private char c;
	public CaracterInvalidoException2(char c) {
		super("Caracter nao é valido");
		this.c = c;
	}
}
