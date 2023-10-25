/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.uepb.eda.atividade03;

/**
 *
 * @author jeffgabriiel
 */

public class PilhaComLista implements Pilha_IF {
	
	private ListaEncadeada list;
	private int max_element = 10;
	
	public PilhaComLista() {
		this.list = new ListaEncadeada();
	}
	@Override
	public void push(Integer element) throws Exception {
		if (isFull()) {
			throw new Exception("A pilha esta cheia (owerflow).");
		}list.insert(element);
	}

	@Override
	public Integer pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("A pilha esta vazia (não da para remover).");
		}
		Integer top = top();
		list.remove(top);
		return top;
	}

	@Override
	public Integer top() throws Exception {
	    if (isEmpty()) {
	        throw new Exception("A pilha está vazia!");
	    }
	    return list.data;
	}


	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return list.size() >= max_element;
	}
}