package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;

public class BST implements BST_IF {
    private No raiz;

    public BST() {
        this.raiz = null;
    }

    @Override
    public void insert(Integer element) {
        if(this.raiz == null) {
            this.raiz = new No(element);
        }else {
            No novoNo = new No(element);
            insertRec(this.raiz, novoNo);
        }
    }

    private void insertRec(No no, No novoNo) {
        if(novoNo.valor > no.valor) {
            if(no.direita == null) {
                no.direita = novoNo;
            }else {
                insertRec(no.direita, novoNo);
            }
        }else {
            if(no.esquerda == null) {
                no.esquerda = novoNo;
            }else {
                insertRec(no.esquerda, novoNo);
            }
        }
    }
    
    @Override
    public Integer search(Integer element) throws Exception {
        return searchRec(this.raiz, element);
    }

    private Integer searchRec(No raiz, Integer element) throws Exception {
        if (raiz == null) {
            throw new Exception("Elemento não encontrado na árvore.");
        }
    
        if (element == raiz.valor) {
            return element;
        } else if (element < raiz.valor) {
            return searchRec(raiz.esquerda, element);
        } else {
            return searchRec(raiz.direita, element);
        }
    }

    @Override
    public int[] preOrder() {
        ArrayList<Integer> resultado = new ArrayList<>();
        preOrderRec(raiz, resultado);
        return resultado.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preOrderRec(No raiz, ArrayList<Integer> resultado) {
        if (raiz != null) {
            resultado.add(raiz.valor);
            preOrderRec(raiz.esquerda, resultado);
            preOrderRec(raiz.direita, resultado);
        }
    }

    @Override
    public int[] order() {
        ArrayList<Integer> resultado = new ArrayList<>();
        orderRec(raiz, resultado);
        return resultado.stream().mapToInt(Integer::intValue).toArray();
    }

    private void orderRec(No raiz, ArrayList<Integer> resultado) {
        if (raiz != null) {
            orderRec(raiz.esquerda, resultado);
            resultado.add(raiz.valor);
            orderRec(raiz.direita, resultado);
        }
    }

    @Override
    public int[] postOrder() {
        ArrayList<Integer> resultado = new ArrayList<>();
        postOrderRec(raiz, resultado);
        return resultado.stream().mapToInt(Integer::intValue).toArray();
    }

    private void postOrderRec(No raiz, ArrayList<Integer> resultado) {
        if (raiz != null) {
            postOrderRec(raiz.esquerda, resultado);
            postOrderRec(raiz.direita, resultado);
            resultado.add(raiz.valor);
        }
    }

    @Override
    public boolean isComplete() {
        return isCompleteRec(raiz, 0, contaNos(raiz));
    }

    private boolean isCompleteRec(No raiz, int index, int nos) {
        if (raiz == null) {
            return true;
        }

        if (index >= nos) {
            return false;
        }

        return (isCompleteRec(raiz.esquerda, 2 * index + 1, nos) && isCompleteRec(raiz.direita, 2 * index + 2, nos));
    }

    private int contaNos(No raiz) {
        if (raiz == null) {
            return 0;
        }

        return 1 + contaNos(raiz.esquerda) + contaNos(raiz.direita);
    }
}