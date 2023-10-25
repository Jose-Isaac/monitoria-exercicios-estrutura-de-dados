package br.edu.uepb.eda.atividade03;
public class PilhaComLista implements Pilha_IF {

    private int limite = 10;
    private Node topo;
    private int tamanho;


    public PilhaComLista() {
        topo = null;
        tamanho = 0;
    }

    @Override
    public void push(Integer element) throws Exception {
        if (tamanho >= limite) {
            throw new Exception("A pilha está cheia. Não é possível adicionar mais elementos.");
        }

        Node novoNo = new Node(element);
        novoNo.info = element;
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia. Não é possível remover elementos.");
        }

        Integer num = topo.info;
        topo = topo.proximo;
        tamanho--;
        return num;
    }

    @Override
    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia.");
        }
        return topo.info;
    }

    @Override
    public boolean isEmpty() {
        return topo == null;
    }

    @Override
    public boolean isFull() {
        return tamanho >= limite;
    }
}
