package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
    private Node head;
    private int size;
    private static final int MAX_CAPACITY = 10;

    private class Node {
        Integer data;
        Node next;

        Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public void push(Integer element) throws Exception {
        if (isFull()) throw new Exception("A pilha está cheia.");        
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) throw new Exception("A pilha está vazia.");
        int value = head.data;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public Integer top() throws Exception {
        if (isEmpty()) throw new Exception("A pilha está vazia.");
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == MAX_CAPACITY;
    }
}