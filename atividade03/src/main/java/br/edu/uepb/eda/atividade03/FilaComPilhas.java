package br.edu.uepb.eda.atividade03;


public class FilaComPilhas implements Fila_IF {
    private PilhaComLista pilha1; // Pilha para enfileirar os elementos.
    private PilhaComLista pilha2; // Pilha para desenfileirar os elementos.
    
    public FilaComPilhas() {
        this.pilha1 = new PilhaComLista();
        this.pilha2 = new PilhaComLista();
    }
    
    @Override
    public void enqueue(Integer element) throws Exception {
        if(this.pilha1.isFull()){
            throw new Exception("QueueOverFlow");
        }

        while(!this.pilha1.isEmpty()){
            int data = this.pilha1.pop();
            this.pilha2.push(data);
        }

        this.pilha1.push(element);

        while(!this.pilha2.isEmpty()){
            int data = this.pilha2.pop();
            this.pilha1.push(data);
        }
    }
    
    @Override
    public Integer dequeue() throws Exception {
        if(this.pilha1.isEmpty()){
            throw new Exception("QueueUnderFlow");
        }
        return this.pilha1.pop();
    }
    
    @Override
    public Integer head() throws Exception {
        if(this.pilha1.isEmpty()){
            throw new Exception("is empty");
        }
        return this.pilha1.top();
    }
    
    @Override
    public boolean isEmpty() {
        return this.pilha1.isEmpty();
    }
    
    @Override
    public boolean isFull() {
        return this.pilha1.isFull();
    }
}