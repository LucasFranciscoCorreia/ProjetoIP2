package br.ufrpe.test;
import java.time.LocalDate;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.repositorios.RepositorioAnimal;
public class testAnimal {
	public static void main(String[] args) {
		Endereco end = new Endereco();
		LocalDate aniversario = LocalDate.of(1996, 7, 26);
		RepositorioAnimal rep = RepositorioAnimal.getInstance();
		Cliente c = new Cliente("101.575.184-93", aniversario, "Lucas", "Correia", end );
		Animal a1 = new Animal(true, "Husky", "Cachorro",c , 37.0, 1.6);
		Animal a2 = new Animal(true, "Husky", "Cachorro", c, 37.0, 1.6);
		Animal a3 = new Animal(true, "Persa", "Gato", c, 1.6, 0.42);
		
		System.out.println("**Cadastrar**");
		System.out.println(rep.adicionar(a1));
		System.out.println();
		System.out.println(rep.adicionar(a2));
		System.out.println();
		System.out.println(rep.adicionar(a3));
		System.out.println();
		
		System.out.println("**Remover**");
		System.out.println(rep.remover(a3));
		System.out.println(rep.remover(a3));
		
		System.out.println("**Atualizar**");
		a2 = new Animal(true, "Marsupial", "Chinchila", c, 0.67, 0.17);
		System.out.println(rep.atualizar(a3, a2));
		System.out.println();
		System.out.println(rep.atualizar(a1, a2));
		System.out.println();
		
		System.out.println("**Recuperar**");
		System.out.println(rep.adicionar(rep.recuperar(c.getCpf(),"Gato")));
		System.out.println(rep.adicionar(rep.recuperar(c.getCpf(), "Gato")));
		System.out.println(rep.adicionar(rep.recuperar(c.getCpf(), "Cachorro")));
		System.out.println();
		
		System.out.println("**Apresentar**");
		for (int i = 0; i < rep.Size(); i++) {
			System.out.println(rep.getPet(i));
			System.out.println();
		}
	}
}