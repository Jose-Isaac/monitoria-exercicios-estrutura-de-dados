package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
    protected ListaEncadeada next;
    protected Integer dado;

    public ListaEncadeada() {
        dado = null;
        next = null;
    }

    public boolean isEmpty() {
        return this.dado == null;
    }

    public int size() {
        return sizeRecursivo(this);
    }

    private int sizeRecursivo(ListaEncadeada current) {
        if (current.dado == null) {
            return 0;
        }
        return 1 + sizeRecursivo(current.next);
    }

    public Integer search(Integer elemento) throws Exception {
        return searchRecursivo(this, elemento);
    }

    private int searchRecursivo(ListaEncadeada current, Integer elemento) throws Exception {
        if (current.dado == null) {
            throw new Exception("O elemento não foi encontrado.");
        }
        if (current.dado.equals(elemento)) {
            return elemento;
        }
        return searchRecursivo(current.next, elemento);
    }

    public void insert(Integer elemento) {
        ListaEncadeada novoNo = new ListaEncadeada();
        novoNo.dado = this.dado;
        novoNo.next = this.next;

        this.dado = elemento;
        this.next = novoNo;
    }

    public void remove(Integer elemento) {
        removeRecursivo(this, elemento);
    }

    private void removeRecursivo(ListaEncadeada current, Integer elemento) {
        if (current.dado != null) {
            if (current.dado.equals(elemento)) {
                current.dado = current.next.dado;
                current.next = current.next.next;
            } else {
                removeRecursivo(current.next, elemento);
            }
        }
    }

    public int[] toArray() {
        int[] array = new int[size()];
        toArrayRecursivo(this, array, 0);
        return array;
    }

    private void toArrayRecursivo(ListaEncadeada current, int[] array, int index) {
        if (current.dado != null) {
            array[index] = current.dado;
            if (current.next != null) {
                toArrayRecursivo(current.next, array, index + 1);
            }
        }
    }
}
