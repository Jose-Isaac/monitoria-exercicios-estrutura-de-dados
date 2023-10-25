package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {

    private ListaEncadeada top = new ListaEncadeada();
    // Usando uma variável auxiliar total, pois em casos em que o tamanho é
    // n->infinito, usar size seria custoso nos métodos isFull e Enqueue.
    protected static int total;

    public void push(Integer element) throws Exception {
        if (++PilhaComLista.total <= 10) {
            top.insert(element);
        } else
            throw new Exception();
    }

    public Integer pop() throws Exception {
        if (top.element == null) throw new Exception("A pilha está vazia");
        int value = top.element;

        top.remove(value);
        PilhaComLista.total--;
        return value;
    }

    public Integer top() throws Exception {
        if (top.isEmpty()) throw new Exception("A pilha está vazia.");
        return top.element;
    }

    public boolean isEmpty() {
        return top.element == null;
    }

    public boolean isFull() {
        return total == 10;
    }
}