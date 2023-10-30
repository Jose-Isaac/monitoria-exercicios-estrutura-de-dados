package atividade03;

public class Node{
	private Integer data;
	private Node next;
	
	public Node(Integer data) {
		this.data = data;
		this.next = null;
	}
	
	public boolean isNil() {
        return data == -1;
    }

	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}

	public Integer getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
