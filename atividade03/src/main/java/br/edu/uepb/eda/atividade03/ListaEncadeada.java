package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
    protected Integer data;
    protected ListaEncadeada next;

    public ListaEncadeada() {
        data = null;
        next = null;
    }

    public boolean isEmpty() {
        return this.data == null;
    }

    public int size() {
        return sizeRecursive(this);
    }

    private int sizeRecursive(ListaEncadeada current) {
        if (current.data == null) {
            return 0;
        }

        return 1 + sizeRecursive(current.next);
    }

    public Integer search(Integer element) throws Exception {
        return searchRecursive(this, element);
    }

    private Integer searchRecursive(ListaEncadeada current, Integer element) throws Exception {
        if (current.data == null) {
            throw new Exception("Elemento não encontrado");
        }

        if (current.data.equals(element)) {
            return element;
        }

        return searchRecursive(current.next, element);
    }

    public void insert(Integer element) {
        ListaEncadeada newNode = new ListaEncadeada();
        newNode.data = this.data;
        newNode.next = this.next;

        this.data = element;
        this.next = newNode;
    }

    public void remove(Integer element) {
        removeRecursive(this, element);
    }

    private void removeRecursive(ListaEncadeada current, Integer element) {
        if (current.data != null) {
            if (current.data.equals(element)) {
                current.data = current.next.data;
                current.next = current.next.next;
            } else {
                removeRecursive(current.next, element);
            }
        }
    }

    public int[] toArray() {
        int[] array = new int[size()];
        toArrayRecursive(this, array, 0);
        return array;
    }

    private void toArrayRecursive(ListaEncadeada current, int[] array, int index) {
        if (current.data != null) {
            array[index] = current.data;
            if (current.next != null) {
                toArrayRecursive(current.next, array, index + 1);
            }
        }
    }
}
