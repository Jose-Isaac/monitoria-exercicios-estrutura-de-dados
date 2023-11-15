package br.edu.uepb.eda.atividade04;

public class No {
    private Integer dado;
    private No esq, dir;

    public No(Integer dado) {
        this.dado = dado;
        this.esq = this.dir = null;
    }

    public No(Integer dado, No esq, No dir) {
        this.dado = dado;
        this.esq = esq;
        this.dir = dir;
    }

    public Integer getDado() {
        return dado;
    }

    public No getEsq() {
        return esq;
    }

    public No getDir() {
        return dir;
    }

    public void setDado(Integer dado) {
        this.dado = dado;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public boolean isNIL() {
        return this.dado == null;
    }
}
