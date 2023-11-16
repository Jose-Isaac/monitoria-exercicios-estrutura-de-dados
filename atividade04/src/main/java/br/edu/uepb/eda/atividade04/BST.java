package br.edu.uepb.eda.atividade04;

public class BST implements BST_IF {
    private No raiz;

    public BST() {
        this.raiz = null;
    }

    private class No {
        Integer valor;
        No esquerda;
        No direita;
    
        private No(Integer valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private int Size() {
		return SizeRec(raiz);
	}

	private int SizeRec(No raiz) {
		if (raiz == null) {
			return 0;
		}
		return 1 + SizeRec(raiz.esquerda) + SizeRec(raiz.direita);
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
            throw new Exception("Elemento nao encontrado na árvore.");
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
    public Integer[] preOrder() {
        Integer[] resultado = new Integer[Size()];
        preOrderRec(raiz, resultado, 0);
        return resultado;
    }

    private int preOrderRec(No raiz, Integer[] resultado, int index) {
        if (raiz != null) {
            resultado[index++] = raiz.valor;
            index = preOrderRec(raiz.esquerda, resultado, index);
            index = preOrderRec(raiz.direita, resultado, index);
        }

        return index;
    }

    @Override
    public Integer[] order() {
        Integer[] resultado = new Integer[Size()];
        orderRec(raiz, resultado, 0);
        return resultado;
    }

    private int orderRec(No raiz, Integer[] resultado, int index) {
        if (raiz != null) {
            index = orderRec(raiz.esquerda, resultado, index);
			resultado[index++] = raiz.valor;
			index = orderRec(raiz.direita, resultado, index);
        }

        return index;
    }

    @Override
    public Integer[] postOrder() {
        Integer[] resultado = new Integer[Size()];
        postOrderRec(raiz, resultado, 0);
        return resultado;
    }

    private int postOrderRec(No raiz, Integer[] resultado, int index) {
        if (raiz != null) {
            index = postOrderRec(raiz.esquerda, resultado, index);
            index = postOrderRec(raiz.direita, resultado, index);
            resultado[index++] = raiz.valor;
        }

        return index;
    }

    @Override
    public boolean isComplete() {
        int nos = contaNos(raiz);
        return isCompleteRecursive(raiz, 0, nos);
    }

    private boolean isCompleteRecursive(No raiz, int index, int nos) {
        if (raiz == null) {
            return true;
        }

        if (index >= nos) {
            return false;
        }

        return (isCompleteRecursive(raiz.esquerda, 2 * index + 1, nos) && isCompleteRecursive(raiz.direita, 2 * index + 2, nos));
    }

    private int contaNos(No raiz) {
        if (raiz == null) {
            return 0;
        }

        return 1 + contaNos(raiz.esquerda) + contaNos(raiz.direita);
    }
}

