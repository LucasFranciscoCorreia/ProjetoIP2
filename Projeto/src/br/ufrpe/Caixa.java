package br.ufrpe;

import java.time.LocalDate;

public class Caixa {
	public static class Dia{
		private double balcao;
		private LocalDate dia;
		public void setDia(LocalDate dia) {
			this.dia = dia;
		}
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
	public static Caixa getInstance(){
		if (c == null) {
			c = new Caixa();
		}
		return c;
	}
	public void addCaixa(double valor){
		boolean res = false;
		hoje = LocalDate.now();
		Dia c;
		LocalDate ultimoDia;
		boolean ok = false;
		if (i-1 >= 0) {
			if (caixa[i-1] != null) {
				if (hoje.equals(caixa[i-1].getDia()))
					ok = true;
				if (ok) {
					c = caixa[i-1];				
				}else{
					c = new Dia();
					c.setDia(hoje);
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
					c.setDia(hoje);
					res = true;
				}		
			}else{
				c = new Dia();
				c.setDia(hoje);
				res = true;
			}
		}
		c.addCaixa(valor);
		if (res) {
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
		Dia vetor[] = new Dia[caixa.length*2];
		for(int i = 0; i < this.i;i++){
			vetor[i] = caixa[i];
		}
		caixa = vetor;
	}
	public double valorArrecadadoHoje(){
		double res = 0;
		hoje = LocalDate.now();
		boolean ok = false;
		if (i-1 >= 0) {
			if (caixa[i-1] != null) {
				if(hoje.equals(caixa[i-1].getDia()))
					ok = true;
				if (ok) {
					res =  caixa[i-1].getCaixa();				
				}else{
					res = 0;
				}
			}else{
				res = 0;
			}
		}else{
			if (caixa[i] != null) {
				if(hoje.equals(caixa[i].getDia()))
					ok = true;
				if (ok) {
					res = caixa[i].getCaixa();					
				}else{
					res =0;
				}
			}else{
				res = 0;				
			}
		}
		return res;
	}
}