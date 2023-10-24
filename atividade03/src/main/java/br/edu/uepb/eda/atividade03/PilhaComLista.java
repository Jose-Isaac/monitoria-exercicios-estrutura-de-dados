package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {

    private ListaEncadeada top = new ListaEncadeada();
    // Usando uma variável auxiliar total, pois em casos em que o tamanho é
    // n->infinito, usar size seria custoso nos métodos isFull e Enqueue.
    protected static int total;

    @Override
    public void push(Integer element) throws Exception {
        if (++PilhaComLista.total <= 10) {
            top.insert(element);
        } else
            throw new Exception();
    }

    @Override
    public Integer pop() throws Exception {
        if (top.element == null)
            throw new Exception();
        int value = top.element;
        top.remove(value);
        PilhaComLista.total--;
        return value;
    }

    @Override
    public Integer top() throws Exception {
        return top.element;
    }

    @Override
    public boolean isEmpty() {
        return top.element == null;
    }

    @Override
    public boolean isFull() {
        return total == 10;
    }

}