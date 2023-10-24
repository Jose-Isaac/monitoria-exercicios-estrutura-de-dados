package atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
	protected Integer data;
	protected ListaEncadeada next;
	
	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public ListaEncadeada getNext() {
		return next;
	}

	public void setNext(ListaEncadeada next) {
		this.next = next;
	}
	
	@Override
	public boolean isEmpty() {
		if(data == null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		if(isEmpty()) {
			return 0;
		}
		return 1 + next.size();
	}

	@Override
	public Integer search(Integer element) throws Exception {
		if(isEmpty()) {
			return 0;
		}else {
			if(data.equals(element)) {
				return element;
			}
			else {
				return next.search(element);
			}
		}	
	}

	@Override
	public void insert(Integer element) {
		if(isEmpty()) {
			data = element;
			next =  new ListaEncadeada();
		}else {
			ListaEncadeada newNode = new ListaEncadeada();
			newNode.setNext(next);
			newNode.setData(data);
			data = element;
			next = newNode;
		}
	}

	@Override
	public void remove(Integer element) {
		if(isEmpty()) {
			
		}else {
			if (data.equals(element)) {
				this.data = next.data;
				next = next.next;
			}else {
				next.remove(element);
			}
		}
		
	}

	@Override
	public Integer[] toArray() {
		 Integer[] resultado = new Integer[size()];
	     toArrayRecursivo(resultado, this, 0);
	     return resultado;
	}

	private int toArrayRecursivo(Integer[] result, ListaEncadeada listaEncadeada, int index) {
		
	     if (!listaEncadeada.isEmpty()) {
	          result[index] = listaEncadeada.data;
	          toArrayRecursivo(result, listaEncadeada.next, index+1);
	       }
	     return index;	
	}

	
}
	

