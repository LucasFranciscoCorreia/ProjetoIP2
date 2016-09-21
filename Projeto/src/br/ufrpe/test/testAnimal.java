package br.ufrpe.test;
import java.util.ArrayList;

import br.ufrpe.beans.Animal;
import br.ufrpe.repositorios.RepositorioAnimal;
public class testAnimal {
	public static void main(String[] args) {
		Animal a = new Animal(true, "Pastor Alemão", "Cachorro", "José", "101.575.184-93", 1.25f, 47.9f);
		System.out.println(a);
		System.out.println();
		Animal b = new Animal(true, "Pastor Alemão", "Cachorro", "Joao", "101.575.184-93", 1.25f, 47.9f);
		System.out.println(a.equals(b));
		System.out.println();
		RepositorioAnimal rep = new RepositorioAnimal(a);
		rep.adicionar(b);
		for (int i = 0; i < rep.Size(); i++) {
			System.out.println(rep.getPet(i));
			System.out.println();
		}
		rep.remover(rep.getPet(1));
		System.out.println();
		for (int i = 0; i < rep.Size(); i++) {
			System.out.println(rep.getPet(i));
			System.out.println();
		}
		rep.atualizar(a, b);
		for (int i = 0; i < rep.Size(); i++) {
			System.out.println(rep.getPet(i));
		}
		
		RepositorioAnimal rep2 = new RepositorioAnimal(a);
		for (int i = 0; i < rep2.Size(); i++) {
			System.out.println(rep2.getPet(i));
			System.out.println();
		}
		rep2.remover(rep2.getPet(0));
		System.out.println();
		for (int i = 0; i < rep2.Size(); i++) {
			System.out.println(rep2.getPet(i));
			System.out.println();
		}
		rep2.atualizar(a, b);
		System.out.println();
		for (int i = 0; i < rep2.Size(); i++) {
			System.out.println(rep2.getPet(i));
		}
		Animal v[] = new Animal[2];
		v[0] = a;
		v[1] = b;
		
		RepositorioAnimal rep3 = new RepositorioAnimal(v);
		for (int i = 0; i < rep3.Size(); i++) {
			System.out.println(rep3.getPet(i));
			System.out.println();
		}
		rep3.remover(rep3.getPet(1));
		
		for (int i = 0; i < rep3.Size(); i++) {
			System.out.println(rep3.getPet(i));
			System.out.println();
		}
		rep3.atualizar(a, b);
		
		for (int i = 0; i < rep3.Size(); i++) {
			System.out.println(rep3.getPet(i));
		}
		ArrayList<Animal> array = new ArrayList<>();
		array.add(a);
		array.add(b);
		RepositorioAnimal rep4 = new RepositorioAnimal(array);
		System.out.println("----------------------------");
		for (int i = 0; i < rep4.Size(); i++) {
			System.out.println(rep4.getPet(i));
			System.out.println();
		}
		rep4.remover(rep4.getPet(1));

		System.out.println("---------------------------------------");
		for (int i = 0; i < rep4.Size(); i++) {
			System.out.println(rep4.getPet(i));
			System.out.println();
		}
		System.out.println("-------------------------------------");
		rep4.atualizar(a, b);
		for (int i = 0; i < rep4.Size(); i++) {
			System.out.println(rep4.getPet(i));
		}
	}
}