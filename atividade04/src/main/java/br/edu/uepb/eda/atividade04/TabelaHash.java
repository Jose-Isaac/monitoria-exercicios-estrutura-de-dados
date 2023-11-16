package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {
    public ListaEncadeada[] tabela;
    public int tamanho;
    TabelaHash(){}
    TabelaHash(int num){
        this.tamanho = num;
        this.tabela = new ListaEncadeada[tamanho];
        for (int i=0;i<tamanho;i++){
            tabela[i] = new ListaEncadeada();
        }
    }
    @Override
    public void insert(Integer element) {
        tabela[element%tamanho].insert(element);
    }
    @Override
    public void remove(Integer element) throws Exception {
        tabela[element%tamanho].remove(element);
    }
    @Override
    public int search(Integer element) throws Exception {
        return tabela[element%tamanho].search(element);
    }
    @Override
    public String print() {
        String str = "";
        Integer arr[];
        for(int i=0;i< tamanho;i++){
            str = str+(i+": ");
            arr = tabela[i].toArray();
            for (int j=0;j<tabela[i].size();j++){
                str = str+(arr[j].toString()+", ");
            }
            if (tabela[i].size()>0){
                str = str.substring(0,str.length()-2);
            }
            str = str+("\n");
        }
        return str;
    }
}
