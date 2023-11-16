package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {

    public final int LIMITE = 10;
    private ListaEncadeada lista;

    public PilhaComLista() {
        lista = new ListaEncadeada();
    }

    @Override
    public void push(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception("A pilha está cheia. Não é possível adicionar mais elementos.");
        }
        lista.insert(element);
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia. Não é possível remover elementos.");
        }
        Integer topElement = top();
        lista.remove(topElement);
        return topElement;
    }

    @Override
    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia.");
        }
        return lista.getHead().data;
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public boolean isFull() {
        return lista.size() >= limite;
    }
}
