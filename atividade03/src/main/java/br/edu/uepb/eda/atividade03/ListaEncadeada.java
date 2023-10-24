package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF{
    protected Integer data;
    protected ListaEncadeada next;

    @Override
    public boolean isEmpty() {
        if (this.data == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return 1 + this.next.size();
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (isEmpty()) {
            throw new Exception("Elemento não encontrado!");
        } else {
            if (data.equals(element)) {
                return this.data;
            } else {
                return next.search(element);
            }
        }
    }

    @Override
    public void insert(Integer element) {
        ListaEncadeada current = new ListaEncadeada();

        current.data = this.data;
        current.next = this.next;

        this.data = element;
        this.next = current;
    }

    @Override
    public void remove(Integer element) {
        if (isEmpty()) {
            return;
        } else {
            if (this.data.equals(element)) {
                this.data = next.data;
                this.next = next.next;
            } else {
                this.next.remove(element);
            }
        }
    }

    @Override
    public int[] toArray() {
       int[] result = new int[size()];
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

