package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
    private final int maxTamanho = 10;
    private ListaEncadeada stack = new ListaEncadeada();

    @Override
    public void push(Integer element) throws Exception {
        if (this.isFull()) {
            throw new Exception("A pilha está cheia");
        }
        this.stack.insert(element);
    }

    @Override
    public Integer pop() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("A pilha está vazia");
        }

        int element = this.top();
        this.stack.remove(element);

        return element;
    }

    @Override
    public Integer top() throws Exception {
        if (this.stack.isEmpty()) {
            throw new Exception("A pilha está vazia");
        }
        return this.stack.data;
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return this.maxTamanho == this.stack.size();
    }

    
}

