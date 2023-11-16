package br.edu.uepb.eda.atividade04;

public class Projeto_Node {

    protected String name;
    protected int copies;
    protected Projeto_Node left;
    protected Projeto_Node right;

    Projeto_Node () {}

    Projeto_Node (String name) {
        this.name = name;
        this.copies = 1;
        this.left = this.right = null;
    }

    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    }

    public int getCopies() {
        return copies;
    } public void setCopies(int copies) {
        this.copies = copies;
    }

    public Projeto_Node getLeft() {
        return left;
    } public void setLeft(Projeto_Node left) {
        this.left = left;
    }

    public Projeto_Node getRight() {
        return right;
    } public void setRight(Projeto_Node right) {
        this.right = right;
    }
}
