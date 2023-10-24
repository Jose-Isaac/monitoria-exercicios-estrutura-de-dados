package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF{

	private Node head; 

    private class Node {

        Integer data;
        Node    next;

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
    public Integer size() {
        return sizeRecursive(head);
    }

    private Integer sizeRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.next);
    }

    @Override
    public Integer search(Integer element) throws Exception {
        return searchRecursive(head, element);
    }

    private Integer searchRecursive(Node node, Integer element) throws Exception {
        if (node == null) {
            return null;
        }
        if (node.data.equals(element)) {
            return element;
        }
        return searchRecursive(node.next, element);
    }

    @Override
    public void insert(Integer element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void remove(Integer element) {
        head = removeRecursive(head, element);
    }

    private Node removeRecursive(Node node, Integer element) {
        if (node == null) {
            return null;
        }
        if (node.data.equals(element)) {
            return node.next;
        }
        node.next = removeRecursive(node.next, element);
        return node;
    }

    @Override
    public Integer[] toArray() {
    	Integer[] array = new Integer[size()];
        toArrayRecursive(head, array, 0);
        return array;
    }

    private void toArrayRecursive(Node node, Integer[] array, Integer index) {
        if (node == null) {
            return;
        }
        array[index] = node.data;
        toArrayRecursive(node.next, array, index + 1);
    }
}

