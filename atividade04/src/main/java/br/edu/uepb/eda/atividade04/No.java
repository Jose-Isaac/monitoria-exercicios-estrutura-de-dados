package br.edu.uepb.eda.atividade04;

public class No {
    Integer valor;
    No esquerda;
    No direita;

    public No(Integer valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public No getesquerda() {
        return esquerda;
    }

    public void setesquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getdireita() {
        return direita;
    }

    public void setdireita(No direita) {
        this.direita = direita;
    }
}