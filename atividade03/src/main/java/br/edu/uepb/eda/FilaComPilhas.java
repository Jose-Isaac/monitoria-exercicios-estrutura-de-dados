package br.edu.uepb.eda;

import br.edu.uepb.eda.atividade03.Fila_IF;

public class FilaComPilhas implements Fila_IF {
    public PilhaComLista pilha01 = new PilhaComLista();
    public PilhaComLista pilha02 = new PilhaComLista();
    @Override
    public void enqueue(Integer element) throws Exception {
        if (isFull()){
            throw new Exception("Fila cheia.");
        }else {
            while (!pilha01.isEmpty()) {
                pilha02.push(pilha01.pop());
            }

            pilha02.push(element);

            while (!pilha02.isEmpty()) {
                pilha01.push(pilha02.pop());
            }

        }
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila vazia.");
        }else {
            return pilha01.pop();
        }
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new Exception("Fila vazia");
        }else {
            return pilha01.top();
        }
    }

    @Override
    public boolean isEmpty() {
        return pilha01.isEmpty();
    }

    @Override
    public boolean isFull() {
        return pilha01.isFull();
    }

}
