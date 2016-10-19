package br.ufrpe;

import java.time.LocalDate;

public class Caixa {
	public static class Dia{
		private double balcao;
		private LocalDate dia;
		public Dia(){
			balcao = 0;
			dia = LocalDate.now();
		}
		public double getCaixa() {
			return balcao;
		}
		public LocalDate getDia() {
			return dia;
		}
		public void addCaixa(double valor){
			balcao += valor;
		}
	}
	private Dia[] caixa;
	private LocalDate hoje;
	private static Caixa c;
	private int i;
	private Caixa(){
		caixa = new Dia[1];
		i= 0;
	}
	public static synchronized Caixa getInstance(){
		if (c == null) {
			c = new Caixa();
		}
		return c;
	}
	public void addCaixa(double valor, LocalDate hoje){
		boolean res = false;
		Dia c;
		LocalDate ultimoDia;
		boolean ok = false;
		if (i-1 >= 0) {
			if (caixa[i-1] != null) {
				ultimoDia = caixa[i-1].getDia();
				if (ultimoDia.getYear() == hoje.getYear() && ultimoDia.getMonthValue() == hoje.getMonthValue() && ultimoDia.getDayOfMonth() == hoje.getDayOfMonth()) {
					ok = true;
				}
				if (ok) {
					c = caixa[i-1];				
				}else{
					c = new Dia();
					res = true;
				}		
			}else{
				ultimoDia = caixa[i-1].getDia();
				if (ultimoDia.getYear() == hoje.getYear() && ultimoDia.getMonthValue() == hoje.getMonthValue() && ultimoDia.getDayOfMonth() == hoje.getDayOfMonth()) {
					ok = true;
				}
				if (caixa[i-1] != null && ok) {
					c = caixa[i-1];
				}else{	
					c = new Dia();		
					res = true;
				}
			}
		}else{
			if (caixa[i] != null) {
				ultimoDia = caixa[i].getDia();
				if (ultimoDia.getYear() == hoje.getYear() && ultimoDia.getMonthValue() == hoje.getMonthValue() && ultimoDia.getDayOfMonth() == hoje.getDayOfMonth()) {
					ok = true;
				}
				if (ok) {
					c = caixa[i];				
				}else{
					c = new Dia();
					res = true;
				}		
			}else{
				c = new Dia();
				res = true;
			}
		}
		c.addCaixa(valor);
		if (res) {
		//	System.out.println("ok");
			addDia(c);			
		}
	}
	private void addDia(Dia d){
		caixa[i] = d;
		i++;
		if(i == caixa.length){
			duplicarVetor();
		}
	}
	private void duplicarVetor(){
		int tam = 2*i;
		Dia vetor[] = new Dia[tam];
		for(int i = 0; i < this.i;i++){
			vetor[i] = caixa[i];
		}
		caixa = vetor;
	}
	public double valorArrecadadoHoje(LocalDate hoje){
		for(int i = 0; i < this.i;i++){
			System.out.println(i + ">"+ caixa[i].getCaixa());
		}
		double res = 0;
		boolean ok = false;
		LocalDate ultimoDia;
		
		if (i-1 >= 0) {
			if (caixa[i-1] != null) {
				ultimoDia = caixa[i-1].getDia();
			//System.out.println(hoje.equals(ultimoDia));
				if (ultimoDia.getYear() == hoje.getYear() && ultimoDia.getMonthValue() == hoje.getMonthValue() && ultimoDia.getDayOfMonth() == hoje.getDayOfMonth()) {
					ok = true;
				}
				//System.out.println(ok);
				if (ok) {
					System.out.println("ok1");
					System.out.println(">" + i);
					res =  caixa[i-1].getCaixa();				
				}else{
					System.out.println("ok2");
					System.out.println(">" + i);
					res = 0;
				}
			}else{
				System.out.println("Ok3");
				System.out.println(">" + i);
				res = 0;
			}
		}else{
			if (caixa[i] != null) {
				ultimoDia = caixa[i].getDia();
		
				if (ultimoDia.getYear() == hoje.getYear() && ultimoDia.getMonthValue() == hoje.getMonthValue() && ultimoDia.getDayOfMonth() == hoje.getDayOfMonth()) {
					ok = true;
				}else
				if (ok) {
					System.out.println("ok4");
					System.out.println(">" + i);
					res = caixa[i].getCaixa();					
				}else{
					System.out.println("ok5");
					System.out.println(">" + i);
					res =0;
				}
			}else{
				System.out.println("ok6");
				System.out.println(">" + i);
				res = 0;				
			}
		}
		return res;
	}
}