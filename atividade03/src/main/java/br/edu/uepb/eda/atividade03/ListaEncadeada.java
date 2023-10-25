/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.uepb.eda.atividade03;

/**
 *
 * @author jeffgabriiel
 */

public class ListaEncadeada implements ListaEncadeada_IF {
	protected Integer data;
	protected ListaEncadeada next;
	
	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public ListaEncadeada getNext() {
		return next;
	}

	public void setNext(ListaEncadeada next) {
		this.next = next;
	}
	
	@Override
	public boolean isEmpty() {
		if(data == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		return 1 + next.size();
	}

	@Override
	public Integer search(Integer element) throws Exception {
		if (isEmpty()) {
			throw new Exception("Elemento não encontrado");
		} else {
			if (data.equals(element)) {
				return element;
			} else {
				return next.search(element);
			}
		}
	}

	@Override
	public void insert(Integer element) {
		if(isEmpty()) {
			data = element;
			next =  new ListaEncadeada();
		}else {
			ListaEncadeada new_node = new ListaEncadeada();
			new_node.setNext(next);
			new_node.setData(data);
			data = element;
			next = new_node;
		}
	}

	@Override
	public void remove(Integer element) {
		if(isEmpty()) {
			
		}else {
			if (data.equals(element)) {
				this.data = next.data;
				next = next.next;
			}else {
				next.remove(element);
			}
		}
		
	}

	@Override
	public int[] toArray() {
		 int[] result = new int[size()];
	     toArrayRecursivo(result, this, 0);
	     return result;
	}

	private int toArrayRecursivo(int[] result, ListaEncadeada lista_encadeada, int index) {
		
	     if (!lista_encadeada.isEmpty()) {
	          result[index] = lista_encadeada.data;
	          toArrayRecursivo(result, lista_encadeada.next, index+1);
	       }
	     return index;	
	}
}