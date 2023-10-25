package br.edu.uepb.eda;

import br.edu.uepb.eda.atividade03.ListaEncadeada_IF;

public class ListaEncadeada implements ListaEncadeada_IF {
    public ListaEncadeada prox;
    public Integer valor;
    public ListaEncadeada(){}
    public ListaEncadeada(Integer v){
        this.valor = v;
        this.prox = null;
    }
    @Override
    public boolean isEmpty() {
        return valor==null;
    }

    @Override
    public int size() {
        if(isEmpty()){
            return 0;
        }else{
            return 1+prox.size();
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if(isEmpty()){
            return 0;
        }else{
            if(valor.equals(element)){
                return valor;
            }else{
                return prox.search(element);
            }
        }
    }

    @Override
    public void insert(Integer element) {
        ListaEncadeada nova = new ListaEncadeada(element);
        nova.valor = valor;
        nova.prox = prox;

        this.valor = element;
        this.prox = nova;
    }

    @Override
    public void remove(Integer element) {
        if (valor.equals(element)){
            valor = prox.valor;
            prox = prox.prox;
        }else{
            prox.remove(element);
        }

    }

    @Override
    public int[] toArray() {
        int[] result = new int[size()];
        toArray(result,this,0);
        return result;
    }

    private void toArray(int[] result, ListaEncadeada no,int index) {
        if (!no.isEmpty()){
            result[index] = no.valor;
            toArray(result,no.prox, index + 1);
        }
    }

}
