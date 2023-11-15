package br.edu.uepb.eda.atividade04;

import java.util.ArrayList;

class No {
    int value;
    No left;
    No right;

    public No(int value) {
        this.value = value;
    }

}

public class BST implements BST_IF {
    private No raiz;

    private int tamanho;

    @Override
    public void insert(Integer element) {
        raiz = insert(raiz, element);
        tamanho++;

    }

    private No insert(No no, int element) {
        if (no == null) {
            return new No(element);

        } else if (element < no.value) {
            no.left = insert(no.left, element);

        } else if (element > no.value) {
            no.right = insert(no.right, element);
        }

        return no;

    }

    @Override
    public Integer search(Integer element) throws Exception {
        No no = search(raiz, element);

        if (no == null) {
            throw new Exception("Valor não encontrado");
        }

        return no.value;
    }

    private No search(No no, int element) {
        if (no == null || no.value == element) {
            return no;

        } else if (element < no.value) {
            return search(no.left, element);

        } else {
            return search(no.right, element);

        }

    }

    @Override
    public int[] preOrder() {
        ArrayList<Integer> lista = new ArrayList<>();
        preOrder(raiz, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();

    }

    private void preOrder(No no, ArrayList<Integer> lista) {
        if (no != null) {
            lista.add(no.value);
            preOrder(no.left, lista);
            preOrder(no.right, lista);
        }

    }

    @Override
    public int[] order() {
        ArrayList<Integer> lista = new ArrayList<>();
        order(raiz, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();
    }

    private void order(No no, ArrayList<Integer> lista) {
        if (no != null) {
            order(no.left, lista);
            lista.add(no.value);
            order(no.right, lista);
        }

    }

    @Override
    public int[] postOrder() {
        ArrayList<Integer> lista = new ArrayList<>();
        postOrder(raiz, lista);
        return lista.stream().mapToInt(Integer::intValue).toArray();

    }

    private void postOrder(No no, ArrayList<Integer> lista) {
        if (no != null) {
            postOrder(no.left, lista);
            postOrder(no.right, lista);
            lista.add(no.value);

        }

    }

    @Override
    public boolean isComplete() {
        return isCompleteRec(raiz, 0, countNodes(raiz));

    }

    private boolean isCompleteRec(No raiz, int indice, int contador) {
        if (raiz == null) {
            return true;
        }

        if (indice >= contador) {
            return false;
        }

        return isCompleteRec(raiz.left, 2 * indice + 1, contador) &&
                isCompleteRec(raiz.right, 2 * indice + 2, contador);
    }

    private int countNodes(No raiz) {
        if (raiz == null) {
            return 0;
        }

        return 1 + countNodes(raiz.left) + countNodes(raiz.right);
    }

}
