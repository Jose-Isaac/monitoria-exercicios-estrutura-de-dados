
public class HashNode{
    protected HashNode prox;
    protected Integer key;
    protected Integer value;

    public HashNode(Integer element, HashNode prox) {
        this.value = element;
        this.prox = prox;
    }

    public HashNode() {
        prox = null;
        value = null;
        key =null;
    }

    public boolean isEmpty() {
        return value == null;
    }


    public Integer size() {
        if (this.value == null) {
            return 0;
        } else if (this.prox == null) {
            return 1;
        }
        return this.prox.size() + 1;
    }


    public Integer search(Integer element) throws Exception {
        if(this.value==null) throw new Exception("Não encontrado.");
        if (this.value.equals(element)) {
            return element;
        }
        if (this.prox == null) {
            return 0;
        }
        return this.prox.search(element);
    }


    public void insert(Integer element) {
        HashNode noAtual = new HashNode(this.value, this.prox);
        this.value = element;
        this.prox = noAtual;

    }

    public void remove(Integer element) throws Exception {
        if(this.value==null) throw new Exception("Não encontrado.");
        if (this.value.equals(element)) {
            this.value = this.prox.value;
            this.prox = this.prox.prox;
        }
        else if (this.prox != null) {
            this.prox.remove(element);
        }

    }


    public int[] toArray() {
        int tamanho = size();
        int[] array = new int[tamanho];
        toArrayRecursive(this, array, 0, tamanho);
        return array;
    }

    public int[] toArrayRecursive(HashNode current_recursive, int[] arrayRecursive, int from, int to) {
        if (current_recursive != null && from < to) {
            arrayRecursive[from] = current_recursive.value;
            return toArrayRecursive(current_recursive.prox, arrayRecursive, from + 1, to);
        }
        return new int[] {};
    }

    @Override
    public String toString() {
        String stringHash="";
        HashNode aux = this;
        while(aux.prox!=null){
            if(aux.value==null){
                stringHash+="";
            }
            stringHash += aux.value;
            aux=aux.prox;
            if (aux.prox!=null) stringHash+=", ";
        }

        return stringHash;

    }
}
