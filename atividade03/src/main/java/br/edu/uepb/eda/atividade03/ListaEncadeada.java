package br.edu.uepb.eda.atividade03;
public class ListaEncadeada implements ListaEncadeada_IF{

	private Node head;
    private Node tail;
    private int size;

    public ListaEncadeada() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Integer search(Integer element) throws Exception {
        Integer result = searchRecursive(head, element);
        if (result != null) {
            return result;
        } else {
            throw new Exception("Null");
        }

    }

    private Integer searchRecursive(Node node, Integer element){
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
        Node newNode = new Node(element, head);
        if(size == 1) {
            tail = head;
        }
        head = newNode;
        size++;
    }

    @Override
    public void remove(Integer element) {
        head = removeRecursive(head, element);
        if (size != 0) {
            size--;
        }
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
    public int[] toArray() {
    	int[] array = new int[size];
        toArrayRecursive(head, array, 0);
        return array;
    }

    private void toArrayRecursive(Node node, int[] array, int index) {
        if (node == null) {
            return;
        }
        array[index] = node.data;
        toArrayRecursive(node.next, array, index + 1);
    }
}

