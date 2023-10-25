package br.edu.uepb.eda.atividade03;
public class Node{
    
    public Integer info;
    public Node proximo;

 // construtor
    public Node(Integer info){
        this.info = info;
        this.proximo = null;
    }


    // get e set
    public Integer getInfo(){
        return info;
    }


    public void setInfo(Integer info){
        this.info = info;
    }

    public Node getProximo(){
        return proximo;
    }

    public void setProximo(Node proximo){
        this.proximo = proximo;
    }



}
