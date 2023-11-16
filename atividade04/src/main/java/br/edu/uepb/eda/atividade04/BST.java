package br.edu.uepb.eda.atividade04;

public class BST implements BST_IF {
    protected No raiz;

    public BST() {
        this.raiz = null;
    }

    public No getRaiz() {
        return raiz;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public int height(No no) {
        if (no == null)
            return 0;
        return 1 + Math.max(height(no.getEsq()), height(no.getDir()));
    }

    public int size() {
        return size(raiz);
    }

    private int size(No raiz) {
        if (raiz == null)
            return 0;
        return 1 + size(raiz.getEsq()) + size(raiz.getDir());
    }

    public void insert(Integer element) {
        this.raiz = insertRec(this.raiz, element);
    }

    // Inserção implementada de maneira recursiva
    private No insertRec(No raiz, Integer element) {
        if (raiz == null) {
            return new No(element);
        } else if (element < raiz.getDado()) {
            raiz.setEsq(insertRec(raiz.getEsq(), element));
        } else if (element > raiz.getDado()) {
            raiz.setDir(insertRec(raiz.getDir(), element));
        }
        return raiz;
    }

    public Integer search(Integer element) throws Exception {
        Integer resultado = searchRec(this.raiz, element);
        if (resultado == null) {
            throw new Exception("Elemento inexistente na árvore");
        }
        return resultado;
    }

    // Busca implementada de maneira recursiva
    public Integer searchRec(No raiz, Integer element) {
        if (raiz == null || raiz.getDado() == element) {
            return raiz != null ? raiz.getDado() : null;
        }

        if (element < raiz.getDado()) {
            return searchRec(raiz.getEsq(), element);
        } else {
            return searchRec(raiz.getDir(), element);
        }
    }

    // Percursos realizados de maneira recursiva (Pré-ordem, pós-ordem, em-ordem)

    // PRÉ-ORDEM
    public Integer[] preOrder() {
        Integer[] resultado = new Integer[size()];
        preOrderRec(this.raiz, resultado, 0);
        return resultado;
    }

    private int preOrderRec(No raiz, Integer[] array, int index) {
        if (raiz != null) {
            array[index++] = raiz.getDado();
            index = preOrderRec(raiz.getEsq(), array, index);
            index = preOrderRec(raiz.getDir(), array, index);
        }
        return index;
    }

    // EM-ORDEM
    public Integer[] order() {
        Integer[] resultado = new Integer[size()];
        orderRec(this.raiz, resultado, 0);
        return resultado;
    }

    private int orderRec(No raiz, Integer[] array, int index) {
        if (raiz != null) {
            index = orderRec(raiz.getEsq(), array, index);
            array[index++] = raiz.getDado();
            index = orderRec(raiz.getDir(), array, index);
        }
        return index;
    }

    // PÓS-ORDEM
    public Integer[] postOrder() {
        Integer[] resultado = new Integer[size()];
        postOrderRec(this.raiz, resultado, 0);
        return resultado;
    }

    private int postOrderRec(No raiz, Integer[] array, int index) {
        if (raiz != null) {
            index = postOrderRec(raiz.getEsq(), array, index);
            index = postOrderRec(raiz.getDir(), array, index);
            array[index++] = raiz.getDado();
        }
        return index;
    }

    public boolean isComplete() {
    return isCompleteRec(this.raiz);
}

private boolean isCompleteRec(No raiz) {
    if (raiz == null) {
        return true;
    }

    if (raiz.getEsq() != null && raiz.getDir() != null) {
    
        return isCompleteRec(raiz.getEsq()) && isCompleteRec(raiz.getDir());
    } else if (raiz.getEsq() == null && raiz.getDir() == null) {
    
        return true;
    } else {
    
        return false;
    }
}
}
