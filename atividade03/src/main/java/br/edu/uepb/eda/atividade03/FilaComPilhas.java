package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {
    private PilhaComLista p1 = new PilhaComLista();
    private PilhaComLista p2 = new PilhaComLista();
    
    @Override
    public void enqueue(Integer element) throws Exception {
        if(isFull()) throw new Exception("A fila está cheia.");         
        else if (p1.isEmpty()) {
            while (!p2.isEmpty()) {
                p1.push(p2.pop());
            }
        }
        p1.push(element);
        if (p2.isEmpty()) {
            while (!p1.isEmpty()) {
                p2.push(p1.pop());
            }
        } 
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) throw new Exception("A fila está vazia.");        
        return p2.pop();
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) throw new Exception("A fila está vazia.");
        else if (p2.isEmpty()) {
            while (!p1.isEmpty()) {
                p2.push(p1.pop());
            }
        }
        return p2.top();
    }

    @Override
    public boolean isEmpty() {
        return p1.isEmpty() && p2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return p1.isFull() || p2.isFull();
    }
}