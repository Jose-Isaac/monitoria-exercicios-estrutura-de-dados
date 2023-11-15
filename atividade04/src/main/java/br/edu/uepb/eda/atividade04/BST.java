package atividade04;

import java.util.ArrayList;
import java.util.List;

public class BST implements BST_IF {
    private Integer data;
    private BST direita, esquerda;

    public BST() {
        this.data = null;
        this.esquerda = this.direita = null;
    }

    @Override
    public void insert(Integer element) {
        if (data == null) {
            data = element;
        } else {
            if (element < data) {
                if (esquerda == null) {
                    esquerda = new BST();
                }
                esquerda.insert(element);
            } else if (element > data) {
                if (direita == null) {
                    direita = new BST();
                }
                direita.insert(element);
            }
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (data == null) {
            throw new Exception("Não encontrado");
        }
        if (element.equals(data)) {
            return data;
        } else if (element < data && esquerda != null) {
            return esquerda.search(element);
        } else if (element > data && direita != null) {
            return direita.search(element);
        }
        throw new Exception("Ñão encontrado");
    }

    @Override
    public int[] preOrder() {
        List<Integer> resultado = new ArrayList<>();
        preOrderRec(resultado);
        return resultado.stream().mapToInt(Integer::intValue).toArray();
    }

    private void preOrderRec(List<Integer> resultado) {
        if (data != null) {
            resultado.add(data);
            if (esquerda != null) {
                esquerda.preOrderRec(resultado);
            }
            if (direita != null) {
                direita.preOrderRec(resultado);
            }
        }
    }

    @Override
    public int[] order() {
        List<Integer> resultado = new ArrayList<>();
        orderRec(resultado);
        return resultado.stream().mapToInt(Integer::intValue).toArray();
    }

    private void orderRec(List<Integer> resultado) {
        if (esquerda != null) {
            esquerda.orderRec(resultado);
        }
        if (data != null) {
            resultado.add(data);
        }
        if (direita != null) {
            direita.orderRec(resultado);
        }
    }

    @Override
    public int[] postOrder() {
        List<Integer> resultado = new ArrayList<>();
        postOrderRec(resultado);
        return resultado.stream().mapToInt(Integer::intValue).toArray();
    }

    private void postOrderRec(List<Integer> resultado) {
        if (esquerda != null) {
            esquerda.postOrderRec(resultado);
        }
        if (direita != null) {
            direita.postOrderRec(resultado);
        }
        if (data != null) {
            resultado.add(data);
        }
    }

    @Override
    public boolean isComplete() {
        int index = 0;
        int contador = countNodes();
        return isCompleteRec(index, contador);
    }

    private boolean isCompleteRec(int index, int contador) {
        if (index >= contador) {
            return false;
        }
        boolean leftComplete = (esquerda == null) || esquerda.isCompleteRec(2 * index + 1, contador);
        boolean rightComplete = (direita == null) || direita.isCompleteRec(2 * index + 2, contador);
        return leftComplete && rightComplete;
    }

    private int countNodes() {
        int contador = 0;
        if (data != null) {
            contador = 1;
            if (esquerda != null) {
                contador += esquerda.countNodes();
            }
            if (direita != null) {
                contador += direita.countNodes();
            }
        }
        return contador;
    }
}