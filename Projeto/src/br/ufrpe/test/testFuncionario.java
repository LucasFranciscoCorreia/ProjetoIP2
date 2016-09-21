package br.ufrpe.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import br.ufrpe.beans.Endereco;
import br.ufrpe.beans.Funcionario;
import br.ufrpe.repositorios.RepositorioFuncionario;
public class testFuncionario {
	public static void main(String[] args) {
		Endereco end1 = new Endereco();
		LocalDateTime entrada = LocalDateTime.now();
		Funcionario f1 = new Funcionario("Lucas", "101.575.184-93", end1, 3499f, entrada, "Balconista");
		Funcionario f2 = new Funcionario("Lucas", "101.575.184-93", end1, 3499f, entrada, "Balconista");
		System.out.println(f1);
		f1.setCargo("Veterinario");
		f1.setEntrada(LocalDateTime.now());
		f1.setNome("Jennifer");
		f1.setSalario(8499f);
		System.out.println();
		System.out.println(f1);
		System.out.println();
		System.out.println(f1.equals(f2));
		f2 = new Funcionario("Lucas", "101.575.184-94", end1, 3499f, entrada, "Balconista");
		System.out.println(f1.equals(f2));
		RepositorioFuncionario rep1 = new RepositorioFuncionario();
		rep1.cadastrar(f1);
		rep1.cadastrar(f2);
		for (int i = 0; i < rep1.Size(); i++) {
			System.out.println(rep1.buscar(i));
		}
		rep1.remover(f1);
		System.out.println();
		for(int i = 0; i < rep1.Size(); i++){
			System.out.println(rep1.buscar(i));
		}
		Funcionario v[] = new Funcionario[2];
		v[0] = f1;
		v[1] = f2;
		RepositorioFuncionario rep2 = new RepositorioFuncionario(v);
		for (int i = 0; i < rep2.Size(); i++) {
			System.out.println(rep2.buscar(i));
		}
		System.out.println();
		rep2.remover(f1);
		for (int i = 0; i < rep2.Size(); i++) {
			System.out.println(rep2.buscar(i));
		}
		System.out.println();
	}
}