package br.edu.uepb.eda.atividade03;

import java.util.List;

public class PilhaComLista implements Pilha_IF {

    private ListaEncadeada lista;

    public PilhaComLista(){
        lista = new ListaEncadeada();
    }

    @Override
    public void push(Integer element) throws Exception {
        if(isFull())
            throw new Exception("Pilha Cheia");
        lista.insert(element);
    }

    @Override
    public Integer pop() throws Exception {
        if(isEmpty())
            throw new Exception("Pilha Vazia");
        
        int top = top();
        lista.remove(top);
        return top;
    }

    @Override
    public Integer top() throws Exception {
        if(isEmpty())
            throw new Exception("Pilha Vazia");

        ListaEncadeada aux = lista;

        while(!aux.getNext().isNil()){
            aux = aux.getNext();
        }
        return aux.getValue();
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public boolean isFull() {
        return lista.size() == 10;
    }
    
}
