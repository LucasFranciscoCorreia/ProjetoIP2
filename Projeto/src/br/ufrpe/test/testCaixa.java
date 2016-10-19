package br.ufrpe.test;

import java.time.LocalDate;

import br.ufrpe.Caixa;

public class testCaixa {
	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		Caixa c = Caixa.getInstance();
		System.out.println(c.valorArrecadadoHoje(hoje));
		c.addCaixa(100, hoje);
		System.out.println(c.valorArrecadadoHoje(hoje));
		hoje = hoje.plusDays(1);
		System.out.println(c.valorArrecadadoHoje(hoje));
		c.addCaixa(100, hoje);
		System.out.println(c.valorArrecadadoHoje(hoje));
	}
}