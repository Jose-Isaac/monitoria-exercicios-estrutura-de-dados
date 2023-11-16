package br.edu.uepb.eda.atividade04;

public class BSTContato{
    public Contato raiz;
    public BSTContato esq;
    public BSTContato dir;
    BSTContato (){}
    BSTContato (Contato data){
        this.raiz = data;
    }
    public boolean isEmpty() {
        return this.raiz == null;
    }
    public void insert(Contato element) {
        if(isEmpty()) {
            this.raiz = element;
        }else {
            if (element.nome.compareToIgnoreCase(raiz.nome)<0) {
                if (esq == null) {
                    esq = new BSTContato(element);
                } else {
                    esq.insert(element);
                }
            } else if (element.nome.compareToIgnoreCase(raiz.nome)>0) {
                if (dir == null) {
                    dir = new BSTContato(element);
                } else {
                    dir.insert(element);
                }
            } else {
                System.out.println("Nome já existe");
            }
        }
    }
    public Contato search(Contato element) throws Exception {
        if(isEmpty()) {
            return null;
        }else {
            if(raiz.nome.compareToIgnoreCase(element.nome)==0) {
                return element;
            }else if(element.nome.compareToIgnoreCase(raiz.nome) < 0 && esq != null) {
                return esq.search(element);
            }else if(element.nome.compareToIgnoreCase(raiz.nome) > 0 && dir != null) {
                return dir.search(element);
            }else {
                return null;
            }
        }
    }
}
