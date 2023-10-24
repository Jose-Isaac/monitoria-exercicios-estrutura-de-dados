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

public class FilaComPilhas implements Fila_IF {

    private PilhaComLista inputStack;  // Pilha de entrada
    private PilhaComLista outputStack; // Pilha de saída

    public FilaComPilhas() {
        inputStack = new PilhaComLista();
        outputStack = new PilhaComLista();
    }

    @Override
    public void enqueue(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception("A fila está cheia (overflow).");
        }

        inputStack.push(element);
    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.pop();
    }

    @Override
    public Integer head() throws Exception {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.top();
    }

    @Override
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    @Override
    public boolean isFull() {
        // A fila é considerada cheia apenas quando a pilha de entrada está cheia
        return inputStack.isFull();
    }
}
