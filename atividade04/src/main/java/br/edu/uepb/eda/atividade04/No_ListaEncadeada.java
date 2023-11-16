package br.edu.uepb.eda.atividade04;
public class No_ListaEncadeada<T>{
    T elemento;
    No_ListaEncadeada<T> proximo;

	
	public No_ListaEncadeada(T elemento) {
		super();
		this.elemento = elemento;
		this.proximo = null;
	}
	
	
	public No_ListaEncadeada(T elemento, No_ListaEncadeada<T> proximo) {
		super();
		this.elemento = elemento;
		this.proximo = proximo;
	}



	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public No_ListaEncadeada<T> getProximo() {
		return proximo;
	}
	public void setProximo(No_ListaEncadeada<T> proximo) {
		this.proximo = proximo;
	}


	@Override
	public String toString() {
		return "No [elemento=" + elemento + ", proximo=" + proximo + "]";
	}
    
}
