package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {

	protected Integer valor;
	protected ListaEncadeada prox;
	protected int tamanho;

	ListaEncadeada(){
		this.valor = null;
		this.prox = null;
	}
	ListaEncadeada(Integer elemento, ListaEncadeada proximo, int tam){
		this.valor = elemento;
		this.prox = proximo;
		this.tamanho = tam;
	}

	public boolean isEmpty() {
		if(this.valor == null) {
			return true;
		}else {
			return false;
		}
	}

	public int size() {
		if(this.valor == null) {
			return 0;
		}
		return this.tamanho;
	}

	public Integer search(Integer element) throws Exception {
		if(this.isEmpty()) {
			throw new Exception("ELEMENTO NÃO ENCONTRADO");
		}else if(this.valor.equals(element)) {
			return valor;
		}else {
			return this.prox.search(element);
		}
	}

	public void insert(Integer element) {
		if(this.isEmpty()) {
			this.prox = new ListaEncadeada();
			this.valor = element;
			this.tamanho = 1;
		}else {
			this.prox = new ListaEncadeada(this.valor, this.prox, this.tamanho);
			this.valor = element;
			this.tamanho++;
		}
	}

	public void remove(Integer element) {
		if(this.isEmpty()) {
			System.out.println("VAZIA");
			return;
		}else if(this.valor.equals(element)) {
			this.valor = this.prox.valor;
			this.prox = this.prox.prox;
			this.tamanho--;
			return;
		}else {
			this.tamanho--;
			this.prox.remove(element);
			return;
		}
	}

	public int[] toArray_aux(int[] array, ListaEncadeada lista, int contagem) {
		if(!lista.isEmpty()) {
			array[contagem] = lista.valor;
			contagem++;
			return toArray_aux(array, lista.prox, contagem);
		}else {
			return array;
		}
	}

	public int[] toArray() {
		if(!this.isEmpty()) {
			int[] result = new int[this.size()];
			return toArray_aux(result, this, 0);
		}
		return null;
	}

}
