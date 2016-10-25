package br.ufrpe.repositorios ;

public class IndiceOutofBoundsException extends Exception{

	private int indiceOut;
	
	public IndiceOutofBoundsException(int indiceOut, String m){
		super(m);
		this.indiceOut = indiceOut;
		
	}
	public int getIndiceOut(){
		return this.indiceOut;
	}

}