package atividade04;


public class ListaEncadeada{
	private Node head;
	private int size = 0;
	@SuppressWarnings("unused")
	private Node NIL;

	public ListaEncadeada() {
		head = null;
		NIL = new Node(-1);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return this.size;
	}

	public int search(int element) throws Exception {
		if (size == 0) {
			throw new Exception("Lista vazia");
		}
		Node current = head;
		while (!current.isNil()) {
			if (current.getData() == element) {
				return element;
			}
			current = current.getNext();
		}

		throw new Exception("Elemento nao encontrado");
	}

	public void insert(int element) {
		Node celulaNova = new Node(element);
		if (isEmpty()) {
			head = celulaNova;
		} else {
			celulaNova.setNext(head);
			head = celulaNova;
		}
		size++;
	}

	public String toString() {
		return "ListaEncadeada [head=" + head + "]";
	}

	public void remove(int element) {
		if (isEmpty()) {
			return;
		}
			if (head.getData() == element) {
				head = head.getNext();
				size--;
				return;
			}
			Node previousNode = head;
			Node currentNode = head.getNext();
			while (!currentNode.isNil()) {
				if (currentNode.getData() == element) {
					previousNode.setNext(currentNode.getNext());
					size--;
					return;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNext();
		}
		}
	

	public int[] toArray() {
		if (head == null) {
			return null;
		}

		int[] arr = new int[size];
		Node current = head;
		for (int i = 0; i < size; i++) {
			arr[i] = current.getData();
			current = current.getNext();
		}

		return arr;
	}

	public Node getHead() {
		return head;
	}
}