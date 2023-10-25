/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.uepb.eda.atividade03;

/**
 *
 * @author jeffgabriiel
 */

public class FilaComPilhas implements Fila_IF {

    private PilhaComLista pilha_1;
    private PilhaComLista pilha_2;

    public FilaComPilhas() {
        this.pilha_1 = new PilhaComLista();
        this.pilha_2 = new PilhaComLista();
    }

   @Override
	public void enqueue(Integer element) throws Exception {
		if (isFull()) {
			throw new Exception("Fila está cheia.");
		} else {
			while(!pilha_1.isEmpty()) {
				pilha_2.push(pilha_1.pop());
			}
			pilha_2.push(element);
			while(!pilha_2.isEmpty()) {
				pilha_1.push(pilha_2.pop());
			}
		}
	}

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Não é possível remover (está vazia).");
        }else {
			int dequeued = pilha_1.pop();
			return dequeued;
		}
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }else {
			int Head = pilha_1.top();
			return Head;
		}
    }

    @Override
    public boolean isEmpty() {
        return pilha_1.isEmpty() && pilha_2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return pilha_1.isFull();
    }
}