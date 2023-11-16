package br.edu.uepb.eda.atividade04;

public class ListaEncadeada {
    protected Integer data;
    protected ListaEncadeada next;

    public boolean isEmpty() {
        if (this.data == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        if (this.isEmpty()) {
            return 0;
        } else {
            return 1 + this.next.size();
        }
    }

    public Integer search(Integer element) throws Exception {
        if (this.isEmpty()) {
            throw new Exception("Elemento não encontrado!");
        } else {
            if (this.data.equals(element)) {
                return this.data;
            } else {
                return this.next.search(element);
            }
        }
    }

    public void insert(Integer element) {
        ListaEncadeada current = new ListaEncadeada();

        current.data = this.data;
        current.next = this.next;

        this.data = element;
        this.next = current;
    }

    public void remove(Integer element) {
        if (this.isEmpty()) {
            return;
        } else {
            if (this.data.equals(element)) {
                this.data = this.next.data;
                this.next = this.next.next;
            } else {
                this.next.remove(element);
            }
        }
    }

    
    public int[] toArray() {
       int[] result = new int[this.size()];
       toArray(result, this,0);
       return result;
    }

    private void toArray(int[] vetor, ListaEncadeada node, int i) {
        if (!node.isEmpty()) {
            vetor[i] = node.data;
            toArray(vetor, node.next, i+1);
        }
    }
}
