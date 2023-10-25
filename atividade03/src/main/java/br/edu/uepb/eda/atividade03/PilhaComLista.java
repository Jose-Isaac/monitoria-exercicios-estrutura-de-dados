package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {

    private final int limite = 10;
    private Node head;
    private ListaEncadeada lista;

    public PilhaComLista() {
        head = null;
        lista = new ListaEncadeada();
    }

    @Override
    public void push(Integer element) throws Exception {
        if (lista.size() >= limite) {
            throw new Exception("A pilha está cheia. Não é possível adicionar mais elementos.");
        }
        lista.insert(element);
        head = lista.searchHead();
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia. Não é possível remover elementos.");
        }

        Integer top = head.data;
        lista.remove(head.data);
        head = lista.searchHead();
        return top;
    }

    @Override
    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia.");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return lista.size() == 0;
    }

    @Override
    public boolean isFull() {
        return lista.size() >= limite;
    }
}
