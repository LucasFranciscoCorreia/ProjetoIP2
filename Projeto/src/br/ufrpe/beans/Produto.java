package br.ufrpe.beans;
public class Produto {
	private float preco;
	private String nome;
	private String tipo;
	private String codigo;
	private int estoque;	//De cada item
	public Produto(float preco, String nome, String tipo, String codigo, int estoque) {
		this.preco = preco;
		this.nome = nome;
		this.tipo = tipo;
		this.codigo = codigo;
		this.estoque = estoque;
	}	
	public Produto(String nome, String codigo){ //Pro Animal que nao eh vendivel :)
		this.nome = nome;
	}
	public void addEstoque(int qtd){
		int x = this.getEstoque();
		x += qtd;
		this.setEstoque(x);
	}	
	public float getPreco() {
		return preco;
	}	
	public void setPreco(float preco) {
		this.preco = preco;
	}	
	public String getNome() {
		return nome;
	}	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigo() {
		return codigo;
	}
	public int getEstoque() {
		return estoque;
	}	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}	
	public String toString(){
		String prod = String.format("Nome: %s \nPreço: %.2f\nCodigo %s\nTipo: %s\nEstoque: %d", nome,preco,codigo,tipo,estoque);
		return prod;  
	}

	public boolean equals(Produto prod) {
		
		boolean resultado = false;
		if (this.getCodigo()== prod.getCodigo() && this.getTipo().equals(prod.getTipo())){
			resultado = true;
		}
		return resultado;	
	}
}
