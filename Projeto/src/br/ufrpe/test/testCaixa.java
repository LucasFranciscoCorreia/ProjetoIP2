package br.ufrpe.test;

import java.util.Scanner;

import br.ufrpe.Caixa;

public class testCaixa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Caixa c = Caixa.getInstance();
		System.out.println(c.valorArrecadadoHoje());
		c.addCaixa(200);
		System.out.println(c.valorArrecadadoHoje());
		c.addCaixa(200);
		System.out.println(c.valorArrecadadoHoje());
		scanner.nextLine();
		c.addCaixa(300);
		System.out.println(c.valorArrecadadoHoje());
		scanner.close();
	}
}
