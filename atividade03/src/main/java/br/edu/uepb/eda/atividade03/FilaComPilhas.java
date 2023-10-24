package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF{

    private PilhaComLista pilha1;
    private PilhaComLista pilha2;

    public FilaComPilhas() {
        pilha1 = new PilhaComLista();
        pilha2 = new PilhaComLista();
    }

    @Override
    public void enqueue(Integer element) throws Exception {
        while (!pilha2.isEmpty()) {
            pilha1.push(pilha2.pop());
        }

        pilha1.push(element);
    
        while (!pilha1.isEmpty()) {
            pilha2.push(pilha1.pop());
        }
    }

    @Override
    public Integer dequeue() throws Exception {
        if (pilha2.isEmpty()){
            throw new Exception("A fila esta vazia");
        }

        return pilha2.pop();
    }

    @Override
    public Integer head() throws Exception {
        if (pilha2.isEmpty()){
            throw new Exception("A fila esta vazia");
        }
    
        return pilha2.top();
    }

    @Override
    public boolean isEmpty() {
        return pilha2.isEmpty();
    }

    @Override
    public boolean isFull() {
        return pilha2.isFull();
    }
    
}
