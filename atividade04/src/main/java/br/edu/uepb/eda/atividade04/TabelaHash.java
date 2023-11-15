package br.edu.uepb.eda.atividade04;
import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF{
	protected  int tam; 
    protected ListaEncadeada[] tabela; 

    public TabelaHash(int tam) {
		this.tam = tam;
		this.tabela = new ListaEncadeada[tam];

		for (int i = 0; i < tam; i++) {
            this.tabela[i] = new ListaEncadeada();
        }
	}

    private int methash(Integer element) {
        return element % tam; 
    }

    @Override
    public void insert(Integer element) {

        tabela[methash(element)].insert(element); 
    }
    @Override
    public void remove(Integer element) throws Exception {

        if (search(element) == element) {
        	tabela[methash(element)].remove(element); 
            
        }
        else {
        	throw new Exception("Elemento não encontrado na tabela");
        }
    }

    @Override
 
    public Integer search(Integer element) throws Exception {

        if (tabela[methash(element)].isEmpty()) {
        	 throw new Exception("Elemento não encontrado na tabela, está vazia");
     
        }  else {
			if (hashTable[hashFunction(element)].search(element) == element) {
				return element;
			} else {
				throw new Exception("Elemento não encontrado na tabela!");
			}
		}
		
    }
    @Override
    public String print() {
    	String resultado = new String();
		for (int i=0; i<tam; i++) {
			resultado += i + ": ";
			if (!tabela[i].isEmpty()) {
				Integer[] t = tabela[i].toArray();
				for (int j=0; j<tabela[i].size(); j++) {
					if (j == tabela[i].size()-1) {
						resultado += t[j];
					} else {
						resultado += t[j] + ", ";
					}
				}
			}
			resultado += "\n";
		}
		return resultado;
	}

}
