package br.edu.uepb.eda.atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {

    private ListaEncadeada next;
    private Integer value;

    public ListaEncadeada getNext() {
        return next;
    }

    public Integer getValue() {
        return value;
    }

    public ListaEncadeada(){
        next = null;
        value = null;
    }

    @Override
    public boolean isEmpty() {
        return isNil();
    }

    @Override
    public int size() {
        if(isEmpty()) return 0;

        return 1+next.size();
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
    
        if (value.equals(element)) {
            return value;
        }
    
        if (!isNil()) {
            Integer result = next.search(element);
            if (result != null) {
                return result;
            }
        }
        
        return null;
    }
    

    @Override
    public void insert(Integer element) {
        ListaEncadeada aux = new ListaEncadeada();
        aux.value = value;
        aux.next = next;

        next = aux;
        value = element;
    }

    @Override
    public void remove(Integer element) {
        if(isEmpty())
            return;

        if(value == element){
            value = next.value;
            next = next.next;
        }
        else{
            next.remove(element);
        }
    }

    @Override
    public int[] toArray() {
        int tam = size();
        int[] array = new int[tam];

        toArrayRecursivo(this, array, 0);

        return array;
    }
    public void toArrayRecursivo(ListaEncadeada lista, int[] array, int inicio){
        if(lista.isEmpty()) return;
        array[inicio] = lista.value;
        toArrayRecursivo(lista.next, array, ++inicio);
    }

    public boolean isNil(){
        return next == null && value == null;
    }
    
}
