package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
    private Node head;
    private int size;

    private class Node {
        Integer data;
        Node next;

        Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Integer search(Integer element) throws Exception {
        return searchRecursive(head, element, 0);
    }

    private int searchRecursive(Node current, Integer element, int index) throws Exception {
        if (current == null) {
            throw new Exception("Valor não encontrado.");
        }
        else if (current.data.equals(element)) {
            return current.data;
        }
        return searchRecursive(current.next, element, index + 1);
    }

    @Override
    public void insert(Integer element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public void remove(Integer element) {
        head = removeRecursive(head, element);
    }

    private Node removeRecursive(Node current, Integer element) {
        if (current == null) {
            return null;
        }
        else if (current.data.equals(element)) {
            size--;
            return current.next;
        }
        current.next = removeRecursive(current.next, element);
        return current;
    }

    @Override
    public int[] toArray() {
        int[] arr = new int[size];
        Node current = head;
        for(int i = 0; current != null; current = current.next, i++){
            arr[i] = current.data;            
        }
        return arr;
    }     
}