package br.edu.uepb.eda.atividade04;
public class ListaEncadeada <T> {
    private No_ListaEncadeada<T> inicio;
	private No_ListaEncadeada<T> ultimo;
	private int tamanho=0; 
	
	

	public void adiciona(T elemento) {
		No_ListaEncadeada<T> celula=new No_ListaEncadeada<T>(elemento); 
		if (this.tamanho==0) {
			this.inicio=celula; 
			
		}else {
			this.ultimo.setProximo(celula); 
			
		}
		this.ultimo=celula; 
		this.tamanho++;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	public boolean busca(T elemento) {
	    No_ListaEncadeada<T> atual = inicio;

	    while (atual != null) {
	        if (atual.elemento.equals(elemento)) {
	            return true;  
	        }
	        atual = atual.proximo;
	    }

	    return false;  
	    
	    
	  
	        }
	
	 public void remove(T elemento) {
	        if (inicio == null) {
	            System.out.println("Lista vazia. Não há nada para remover.");
	            return;
	        }

	        
	        if (inicio.elemento.equals(elemento)) {
	            inicio = inicio.proximo;
	            System.out.println("Elemento removido: " + elemento);
	            return;
	        }

	        No_ListaEncadeada<T> atual = inicio;
	        No_ListaEncadeada<T> anterior = null;

	    
	        while (atual != null && !atual.elemento.equals(elemento)) {
	            anterior = atual;
	            atual = atual.proximo;
	        }

	        
	        if (atual != null) {
	            anterior.proximo = atual.proximo;
	            System.out.println("Elemento removido: " + elemento);
	        } else {
	            System.out.println("Elemento não encontrado na lista.");
	        }
	    }
	 public No_ListaEncadeada<T> getPrimeiro() {
	        return this.inicio;
	    }
    
}
