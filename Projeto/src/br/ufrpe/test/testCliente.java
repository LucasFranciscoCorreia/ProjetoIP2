package br.ufrpe.test;

import java.time.LocalDate;
import br.ufrpe.beans.Cliente;
public class testCliente {
	public static void main(String[] args) {
		LocalDate aniversario = LocalDate.of(1996, 7, 26);
		Cliente c1 = new Cliente("101.575.184-93", aniversario, "Lucas", "Correia");
		LocalDate aniversario2 = LocalDate.of(1997, 3, 10);
		Cliente c2 = new Cliente("316.147.364-72", aniversario2, "Jennifer", "de Lira");
		Cliente c3 = new Cliente("101.575.184-93", aniversario, "Lucas", "Correia");
		System.out.println(c1);
		System.out.println();
		System.out.println(c2);
		System.out.println();
		System.out.println(c1.equals(c3));
		System.out.println(c1.equals(c2));
		System.out.println();
	}
}