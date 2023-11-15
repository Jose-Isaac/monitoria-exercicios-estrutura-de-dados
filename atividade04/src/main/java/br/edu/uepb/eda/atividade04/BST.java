package atividade04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST implements BST_IF {

    private static class No {
        int valor;
        No esquerda;
        No direita;
        No(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private No raiz;

    public BST() {
        this.raiz = null;
    }

    @Override
    public void insert(int elemento) {
        raiz = insertRecursive(raiz, elemento);
    }

    private No insertRecursive(No raiz, int elemento) {
        if (raiz == null) {
            raiz = new No(elemento);
            return raiz;
        }

        if (elemento < raiz.valor) {
            raiz.esquerda = insertRecursive(raiz.esquerda, elemento);
        } else if (elemento > raiz.valor) {
            raiz.direita = insertRecursive(raiz.direita, elemento);
        }

        return raiz;
    }

    @Override
    public int search(int elemento) throws Exception {
        No result = searchRecursive(raiz, elemento);
        if (result == null) {
            throw new Exception("elemento não encontrado.");
        }
        return result.valor;
    }

    private No searchRecursive(No raiz, int elemento) {
        if (raiz == null || raiz.valor == elemento) {
            return raiz;
        }

        if (elemento < raiz.valor) {
            return searchRecursive(raiz.esquerda, elemento);
        }

        return searchRecursive(raiz.direita, elemento);
    }

    private List<Integer> preOrderTraversal(No raiz) {
        List<Integer> result = new ArrayList<>();
        if (raiz != null) {
            result.add(raiz.valor);
            result.addAll(preOrderTraversal(raiz.esquerda));
            result.addAll(preOrderTraversal(raiz.direita));
        }
        return result;
    }

    @Override
    public int[] preOrder() {
        List<Integer> traversal = preOrderTraversal(raiz);
        return traversal.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> inOrderTraversal(No raiz) {
        List<Integer> result = new ArrayList<>();
        if (raiz != null) {
            result.addAll(inOrderTraversal(raiz.esquerda));
            result.add(raiz.valor);
            result.addAll(inOrderTraversal(raiz.direita));
        }
        return result;
    }

    @Override
    public int[] order() {
        List<Integer> traversal = inOrderTraversal(raiz);
        return traversal.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> postOrderTraversal(No raiz) {
        List<Integer> result = new ArrayList<>();
        if (raiz != null) {
            result.addAll(postOrderTraversal(raiz.esquerda));
            result.addAll(postOrderTraversal(raiz.direita));
            result.add(raiz.valor);
        }
        return result;
    }

    @Override
    public int[] postOrder() {
        List<Integer> traversal = postOrderTraversal(raiz);
        return traversal.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public boolean isComplete() {
        if (raiz == null) {
            return true;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        boolean encontrouNoNulo = false;

        while (!fila.isEmpty()) {
            No atual = fila.poll();

            if (atual != null) {
                if (encontrouNoNulo) {
                    return false; // Se encontrou um nó nulo após um nó não nulo, a árvore não é completa
                }

                fila.add(atual.esquerda);
                fila.add(atual.direita);
            } else {
                encontrouNoNulo = true;
            }
        }

        return true;
    }
}
