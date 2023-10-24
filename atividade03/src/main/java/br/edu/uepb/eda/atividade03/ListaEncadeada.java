package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
    
    private Integer data;
    public Integer getData() {
		return data;
	}

	public ListaEncadeada getNext() {
		return next;
	}

	private ListaEncadeada next;

    public ListaEncadeada(){
        this.data = null;
        this.next = null;
    }

    public boolean isEmpty(){
        return data == null;
    }

	public int size(){
        if(isEmpty()){
            return 0;
        }
        return 1 + next.size();
    }


	public Integer search(Integer element) throws Exception{

        if (isEmpty()) {
            throw new Exception("Elemento não encontrado"); 
        }
        if (data.equals(element)) {
            return data; 
        }
        return next.search(element); 
    } 


	public void insert(Integer element){
        ListaEncadeada newNode = new ListaEncadeada();
        newNode.data = this.data;
        newNode.next = this.next;
        this.data = element;
        this.next = newNode;
    } //deve-se inserir no início da lista

	public void remove(Integer element){
        if(isEmpty()){
            return;
        }
        if(data.equals(element)){
            this.data = this.next.data;
            this.next = this.next.next;
        }
        else{
            next.remove(element);
        }
    }

	public int[] toArray(){
        int[] array = new int[size()];
        toArray(array, 0, this);
        return array;
        }

    private void toArray(int[] array, int index, ListaEncadeada current) {
        if (current.data != null) {
            array[index] = current.data;
            toArray(array, index + 1, current.next);
        }
    }
}
