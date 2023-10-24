/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade03;

/**
 *
 * @author jeffgabriiel
 */

import java.util.EmptyStackException;

public class PilhaComLista implements Pilha_IF {
    private Node top; // O topo da pilha
    private int size; // Tamanho atual da pilha
    private static final int MAX_CAPACITY = 10; // Capacidade máxima da pilha

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
        if (isFull()) {
            throw new Exception("A pilha está cheia (overflow).");
        }

        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int element = top.data;
        top = top.next;
        size--;
        return element;
    }

    @Override
    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return top.data;
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
