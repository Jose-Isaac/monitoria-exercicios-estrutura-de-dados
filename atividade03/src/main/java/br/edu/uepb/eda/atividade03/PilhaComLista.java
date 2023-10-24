package br.edu.uepb.eda.atividade03;

public class PilhaComLista implements Pilha_IF {
    private ListaEncadeada lista;
    private int tamanho;
    private Integer topo;
    
    
    public PilhaComLista() {
    
    	this.lista = new ListaEncadeada();
    	this.tamanho = 0;
    	this.topo = null;
    }
    
    
    public void push(Integer element) throws Exception {
		if(this.tamanho == 10){
			throw new Exception("Stack Overflow!! Tamanho máximo da pilha é 10");
		}
    	lista.insert(element);  
    	this.topo = element;
    	this.tamanho++;
    }

	@Override
	public Integer pop() throws Exception {
		if(this.tamanho==0) {
			throw new Exception("Stack Underflow!! Não tem elementos aqui");
		}
		Integer old_topo = this.topo;
		lista.remove(this.topo);
		this.topo = lista.getData();
		this.tamanho--;
		return old_topo;
	}

	@Override
	public Integer top() throws Exception {
		if(this.tamanho==0) {
			throw new Exception("Não tem elementos aqui");
		}
		return this.topo;
	}

	@Override
	public boolean isEmpty() {
		if(this.tamanho==0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.tamanho==10) {
			return true;
		}	
		
		return false;
	}
    
}
