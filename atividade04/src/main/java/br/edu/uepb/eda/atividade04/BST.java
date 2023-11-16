package br.edu.uepb.eda.atividade04;

import java.lang.ref.PhantomReference;

public class BST implements BST_IF {
    public Integer raiz;
    public BST esq;
    public BST dir;
    public int cont = 0;
    public BST (){}
    BST (Integer data){
        this.raiz = data;
    }
    public boolean isEmpty() {
        return this.raiz == null;
    }
    @Override
    public void insert(Integer element) {
        cont++;
        if(isEmpty()) {
            this.raiz = element;
        }else {
            if (element < raiz) {
                if (esq == null) {
                    esq = new BST(element);
                } else {
                    esq.insert(element);
                }
            } else if (element > raiz) {
                if (dir == null) {
                    dir = new BST(element);
                } else {
                    dir.insert(element);
                }
            } else {
                cont--;
            }
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if(isEmpty()) {
            throw new Exception("Árvore vazia!");
        }else {
            if(raiz.equals(element)) {
                return element;
            }else if(element < raiz && esq != null) {
                return esq.search(element);
            }else if(element > raiz && dir != null) {
                return dir.search(element);
            }else {
                throw new Exception("Não encontrado!");
            }
        }
    }

    @Override
    public Integer[] preOrder() {
        ListaEncadeada preOrder = new ListaEncadeada();
        preAux(preOrder,this);
        Integer integerArr[] = preOrder.toArray();
        Integer intArr[] = new Integer[cont];
        for (int i=0;cont>i;i++){
            intArr[i] = integerArr[cont-1-i];
        }
        return intArr;
    }
    public void preAux(ListaEncadeada lista,BST arvore){
        if(arvore != null) {
            lista.insert(arvore.raiz);
            preAux(lista,arvore.esq);
            preAux(lista,arvore.dir);
        }
    }
    @Override
    public Integer[] order() {
        ListaEncadeada order = new ListaEncadeada();
        orderAux(order,this);
        Integer integerArr[] = order.toArray();
        Integer intArr[] = new Integer[cont];
        for (int i=0;cont>i;i++){
            intArr[i] = integerArr[cont-1-i];
        }
        return intArr;
    }
    public void orderAux(ListaEncadeada lista,BST arvore){
        if(arvore != null) {
            orderAux(lista,arvore.esq);
            lista.insert(arvore.raiz);
            orderAux(lista,arvore.dir);
        }
    }
    @Override
    public Integer[] postOrder() {
        ListaEncadeada posOrder = new ListaEncadeada();
        posAux(posOrder,this);
        Integer integerArr[] = posOrder.toArray();
        Integer intArr[] = new Integer[cont];
        for (int i=0;cont>i;i++){
            intArr[i] = integerArr[cont-1-i];
        }
        return intArr;
    }
    public void posAux(ListaEncadeada lista,BST arvore){
        if(arvore != null) {
            posAux(lista,arvore.esq);
            posAux(lista,arvore.dir);
            lista.insert(arvore.raiz);
        }
    }
    @Override
    public boolean isComplete() {
        return isCompleteAux(this, 0, contaux(this));
    }

    private int contaux(BST bst) {
        if (bst == null) {
            return 0;
        } else {
            int esquerdacont = contaux(bst.esq);
            int direitacont = contaux(bst.dir);

            if (esquerdacont < direitacont)
                return esquerdacont + 1;
            else
                return direitacont + 1;
        }
    }

    private boolean isCompleteAux(BST bst, int index, int count) {
        if (bst == null && index == 0)
            return false;

        if (bst == null)
            return true;

        if (index == (count - 1))
            return bst.esq == null && bst.dir == null;

        else if (index > (count - 1))
            return false;

        return isCompleteAux(bst.esq, index + 1, count) && isCompleteAux(bst.dir, index + 1, count);
    }
}
