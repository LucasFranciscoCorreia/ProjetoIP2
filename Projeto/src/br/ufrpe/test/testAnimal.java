package br.ufrpe.test;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;

import br.ufrpe.beans.Animal;
import br.ufrpe.beans.Cliente;
import br.ufrpe.beans.Endereco;
import br.ufrpe.repositorios.RepositorioAnimal;


public class testAnimal {
	public static void main(String[] args) {
		
		RepositorioAnimal repoAnimal = RepositorioAnimal.getInstance();
		LocalDate nascimento = LocalDate.now();
		Endereco ende = new Endereco();
		Cliente dono = new Cliente("2938249", nascimento, "Raissa", "Camelo", ende);
		
		boolean state = true;
		
		
		do{
			Scanner sc = new Scanner(System.in);
			String answer = "";
			
			System.out.println("Deseja Adicionar um novo animal? (pet-cliente) (S/N)");
			answer = sc.next();
			answer.toLowerCase();
			
			if(answer.equals("s")){
				  
				 String especie;
				 String raca;
				 double peso;
				 double tamanho;
				 String nome;
				
				System.out.println("Digite o nome Animal: ");
				nome = sc.next();
				System.out.println("Digite a especie do animal: ");
				especie = sc.next();
				System.out.println("Digite a raca do Animal: ");
				raca = sc.next();
				System.out.println("Digite o peso do Animal: ");
				peso = sc.nextDouble();
				System.out.println("Digite o tamanho do Animal: ");
				tamanho = sc.nextDouble();
				Animal animal = new Animal(true, especie, raca, dono, peso, tamanho, nome);
				repoAnimal.adicionar(animal);
				
				
				
			}
			else{
				state = false;
			}
			
		}while(state);
		
		System.out.println("Saiu");
		System.out.println(repoAnimal.toString());
		
	}
}