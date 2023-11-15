package br.edu.uepb.eda.atividade04;

public class BST implements BST_IF{
    private Integer dado;
    private BST esquerda;
    private BST direita;
    private int Nodes;

    public BST(){
        this.dado = null;
        this.esquerda = null;
        this.direita = null;
        this.Nodes = 0;
    }

    @Override
    public void insert(Integer element) {
        try {
            search(element);
        } catch (Exception e) {
            if (dado == null) {
                dado = element;
            } else {
                if (element < dado) {
                    if (esquerda == null) {
                        esquerda = new BST();
                    }
                    esquerda.insert(element);
                } else {
                    if (direita == null) {
                        direita = new BST();
                    }
                    direita.insert(element);
                }
            }
            Nodes++;
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (dado == null) {
            throw new Exception("Elemento nao encontrado");
        }

        if (element == dado) {
            return dado;
        } else if (element < dado) {
            if (esquerda == null) {
                throw new Exception("Elemento nao encontrado");
            }
            return esquerda.search(element);
        } else {
            if (direita == null) {
                throw new Exception("Elemento nao encontrado");
            }
            return direita.search(element);
        }
    }

    @Override
    public int[] preOrder() {
        int[] result = new int[Nodes];
        preOrderRecursive(this, result, new int[]{0});
        return result;
    }

    @Override
    public int[] order() {
        int[] result = new int[Nodes];
        orderRecursive(this, result, new int[]{0});
        return result;
    }

    @Override
    public int[] postOrder() {
        int[] result = new int[Nodes];
        postOrderRecursive(this, result, new int[]{0});
        return result;
    }

    @Override
    public boolean isComplete() {
        int resultado = (int) Math.pow(2, getAltura(this) + 1) - 1;

        return Nodes == resultado;
    }

    private int getAltura(BST node) {
        if (node == null) {
            return -1;
        }
        return Math.max(getAltura(node.esquerda), getAltura(node.direita)) + 1;
    }

    private void preOrderRecursive(BST node, int[] result, int[] index) {
        if (node != null) {
            result[index[0]++] = node.dado;
            preOrderRecursive(node.esquerda, result, index);
            preOrderRecursive(node.direita, result, index);
        }
    }

    private void orderRecursive(BST node, int[] result, int[] index) {
        if (node != null) {
            orderRecursive(node.esquerda, result, index);
            result[index[0]++] = node.dado;
            orderRecursive(node.direita, result, index);
        }
    }

    private void postOrderRecursive(BST node, int[] result, int[] index) {
        if (node != null) {
            postOrderRecursive(node.esquerda, result, index);
            postOrderRecursive(node.direita, result, index);
            result[index[0]++] = node.dado;
        }
    }
}
