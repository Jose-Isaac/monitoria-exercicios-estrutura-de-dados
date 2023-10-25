package br.edu.uepb.eda;

import br.edu.uepb.eda.atividade03.Pilha_IF;

public class PilhaComLista implements Pilha_IF {
    public ListaEncadeada lista = new ListaEncadeada();
    @Override
    public void push(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception("Pilha cheia.");
        }
        lista.insert(element);
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha vazia.");
        }
        int top = lista.valor;
        lista.valor = lista.prox.valor;
        lista.prox = lista.prox.prox;
        return top;
    }

    @Override
    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("Pilha vazia.");
        }
        return lista.valor;
    }

    @Override
    public boolean isEmpty() {
        return lista.valor == null;
    }

    @Override
    public boolean isFull() {
        return lista.size()==10;
    }

}
