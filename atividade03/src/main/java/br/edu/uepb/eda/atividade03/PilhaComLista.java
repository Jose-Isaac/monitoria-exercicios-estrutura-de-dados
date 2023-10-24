package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
    private ListaEncadeada_IF lista;

    public PilhaComLista() {
        lista = new ListaEncadeada();
    }
    
    public void push(Integer element) throws Exception {
        lista.insert(element);
    }
    
    public Integer pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Pilha vazia!!!");
        }

        int elementoTopo = top();
        lista.remove(elementoTopo);
        return elementoTopo;
    }
    
    public Integer top() throws Exception {
        if(isEmpty()) {
            throw new Exception("Pilha vazia!!!");
        }

        int[] array = lista.toArray();
        return array[0];
    }
    
    public boolean isEmpty() {
        return lista.isEmpty();
    }
    
    public boolean isFull() {
        return false;
    }    
}




