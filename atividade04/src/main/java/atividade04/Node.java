package atividade04;



public class Node{
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	public boolean isNil() {
        return data == -1;
    }

	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

	public int getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
