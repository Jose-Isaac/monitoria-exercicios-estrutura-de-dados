package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
	private Node head;

	public ListaEncadeada() {
		head = null;
	}

	private class Node {
		Integer data;
		Node next;

		Node(Integer data) {
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return sizeRecursive(head);
	}

	private int sizeRecursive(Node current) {
		if (current == null) {
			return 0;
		}
		return 1 + sizeRecursive(current.next);
	}

	public Integer search(Integer element) throws Exception {
		return searchRecursive(head, element, 0);
	}

	private int searchRecursive(Node current, Integer element, int index) throws Exception {
		if (current == null) {
			throw new Exception("Elemento não encontrado na lista");
		}
		if (current.data.equals(element)) {
			return element;
		}
		return searchRecursive(current.next, element, index + 1);
	}

	public void insert(Integer element) {
		Node newNode = new Node(element);
		newNode.next = head;
		head = newNode;
	}

	public void remove(Integer element) {
		head = removeRecursive(head, element);
	}

	private Node removeRecursive(Node current, Integer element) {
		if (current == null) {
			return null;
		}
		if (current.data.equals(element)) {
			return current.next;
		}
		current.next = removeRecursive(current.next, element);
		return current;
	}

	public int[] toArray() {
		int size = size();

		int[] array = new int[size];
		toArrayRecursive(head, array, 0);
		return array;
	}

	private void toArrayRecursive(Node current, int[] array, int index) {
		if (current == null) {
			return;
		}
		array[index] = current.data;
		toArrayRecursive(current.next, array, index + 1);
	}
}