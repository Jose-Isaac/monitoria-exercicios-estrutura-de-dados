package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF{
    private ListaEncadeada top;
    private int size;

    public PilhaComLista() {
        top = null;
        size = 0;
    }

    @Override
    public void push(Integer element) throws Exception {
        if (size > 10) {
            throw new Exception("Capacidade maxima da pilha atingida.");
        }

        ListaEncadeada newNode = new ListaEncadeada();
        newNode.data = element;
        
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        
        size++;
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha esta vazia");
        }

        int elementoRemovido = top.data;
        top = top.next;

        size--;

        return elementoRemovido;
    }

    @Override
    public Integer top() throws Exception {
        if (isEmpty()) {
           throw new Exception("A pilha esta vazia");
        }

        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return size > 10;
    }
    
}
