package br.edu.uepb.eda.atividade03;

import java.util.Stack;

public class PilhaComLista implements Pilha_IF {
    private Stack<Integer> items;

    public PilhaComLista() {
        this.items = new Stack<>();
    }

    @Override
    public void push(Integer element) throws Exception {
        items.push(element);
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha vazia");
        }
        return items.pop();
    }

    @Override
    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha vazia");
        }
        return items.peek();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}

class FilaComPilha implements Pilha_IF {
    private PilhaComLista pilha;

    public FilaComPilha() {
        this.pilha = new PilhaComLista();
    }

    @Override
    public void push(Integer element) throws Exception {
        pilha.push(element);
    }

    @Override
    public Integer pop() throws Exception {
        return pilha.pop();
    }

    @Override
    public Integer top() throws Exception {
        return pilha.top();
    }

    @Override
    public boolean isEmpty() {
        return pilha.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}