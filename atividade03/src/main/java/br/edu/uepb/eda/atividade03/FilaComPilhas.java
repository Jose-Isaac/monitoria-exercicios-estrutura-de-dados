package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {
    PilhaComLista p1 = new PilhaComLista();
    PilhaComLista p2 = new PilhaComLista();

    public void enqueue(Integer element) throws Exception {
        if(p1.isFull()){
            throw new Exception("A fila está cheia!");
        }
        while (!p1.isEmpty()) {
            p2.push(p1.pop());
        }
        p2.push(element);
        while (!p2.isEmpty()) {
            p1.push(p2.pop());
        }
    }

    public Integer dequeue() throws Exception {
        try {
            return p1.pop();
        } catch (Exception e) {
            throw new Exception("Pilha vazia. " + e);
        }
    }

    public Integer head() throws Exception {
        if(p1.isEmpty()) throw new Exception("Fila vazia.");
        return p1.top();
    }

    public boolean isEmpty() {
        return p1.isEmpty();
    }

    public boolean isFull() {
        return p1.isFull();
    }
}