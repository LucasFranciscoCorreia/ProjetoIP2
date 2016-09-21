package br.ufrpe.beans;
public class Endereco {
	private String rua;
	private String complemento;
	private short numero;
	private String cep;
	private String cidadeUF;
	public Endereco(){
		rua = "";
		complemento = "";
		cep = "";
		cidadeUF = "";
	}
	public Endereco(String rua, String complemento, short numero, String cep, String cidadeUF) {
		this.rua = rua;
		this.complemento = complemento;
		this.numero = numero;
		this.cep = cep;
		this.cidadeUF = cidadeUF;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public short getNumero() {
		return numero;
	}
	public void setNumero(short numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidadeUF() {
		return cidadeUF;
	}
	public void setCidadeUF(String cidadeUF) {
		this.cidadeUF = cidadeUF;
	}
	public String toString(){
		String res = String.format("\nCidade-UF: %s\nRua: %s\nNumero: %d\nCEP: %s\nComplemento", cidadeUF, rua, numero, cep, complemento);
		return res;
	}
	public boolean equals(Endereco outro){
		boolean res = false;
		if(this.rua.equals(outro.getRua())
				&& this.cep.equals(outro.getCep())
				&& this.cidadeUF.equals(outro.getCidadeUF())
				&& this.complemento.equals(outro.getComplemento())
				&& this.numero == outro.getNumero()){
			res = true;
		}
		return res;
	}
}