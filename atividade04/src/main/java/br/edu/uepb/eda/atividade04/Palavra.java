package br.edu.uepb.eda.atividade04;
public class Palavra {

    protected String palavra;
    protected String significado;

    public Palavra(String palavra, String significado) {
        this.palavra = palavra;
        this.significado = significado;
    }

    public String getPalavra() {
        return palavra;
    }

    public String getSignificado() {
        return significado;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void setSignificado(String significado) {
        this.significado = significado;
    }

    @Override
    public String toString() {
        return palavra + "(" + significado + ")";
    }
}
