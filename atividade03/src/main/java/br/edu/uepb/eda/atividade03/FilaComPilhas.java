package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF{

    private PilhaComLista inputStack = new PilhaComLista();
    private PilhaComLista outputStack = new PilhaComLista();

    @Override
    public void enqueue(Integer element) throws Exception {
        if (this.inputStack.isFull()) {
            throw new Exception("Fila cheira!");
        }
      
        while (!this.inputStack.isEmpty()) {
            this.outputStack.push(this.inputStack.pop());
        }
        
        outputStack.push(element);
        
        while (!this.outputStack.isEmpty()) {
            this.inputStack.push(this.outputStack.pop());
        }
    }

    @Override
    public Integer dequeue() throws Exception {
        if (this.inputStack.isEmpty()) {
            throw new Exception("A fila está vazia!");
        }

        return this.inputStack.pop();

    }

    @Override
    public Integer head() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("A fila está vazia!");
        }

        return this.inputStack.top();
    }

    @Override
    public boolean isEmpty() {
        return this.inputStack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.inputStack.isFull();
    }

    
}

