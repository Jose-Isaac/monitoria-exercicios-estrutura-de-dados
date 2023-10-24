/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade03;

/**
 *
 * @author jeffgabriiel
 */

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
    public Integer size() {
        return size;
    }

    @Override
    public Integer search(Integer element) {
        return searchRecursive(head, element, 0);
    }

    private Integer searchRecursive(Node current, Integer element, int index) {
        if (current == null) {
            return null;
        } else if (current.data.equals(element)) {
            return element;
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
        head = removeRecursively(head, element);
    }

    private Node removeRecursively(Node current, Integer element) {
        if (current == null) {
            return null;
        } else if (current.data.equals(element)) {
            size--;
            return current.next;
        }

        current.next = removeRecursively(current.next, element);
        return current;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[size];
        toArrayRecursively(head, array, 0);
        return array;
    }

    private void toArrayRecursively(Node current, int[] array, int index) {
        if (current == null) {
            return;
        }

        array[index] = current.data;
        toArrayRecursively(current.next, array, index + 1);
    }
}
