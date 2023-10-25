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

    private PilhaComLista p1;
    private PilhaComLista p2;

    public FilaComPilhas() {
        this.p1 = new PilhaComLista();
        this.p2 = new PilhaComLista();
    }

   @Override
	public void enqueue(Integer element) throws Exception {
		if (isFull()) {
			throw new Exception("Fila está cheia.");
		} else {
			while(!p1.isEmpty()) {
				p2.push(p1.pop());
			}
			p2.push(element);
			while(!p2.isEmpty()) {
				p1.push(p2.pop());
			}
		}
	}

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Nao da para remover pois esta vazia.");
        }else {
			int dequeued = p1.pop();
			return dequeued;
		}
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila esta vazia.");
        }else {
			int Head = p1.top();
			return Head;
		}
    }

    @Override
    public boolean isEmpty() {
        return p1.isEmpty() && p2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return p1.isFull();
    }
}