package br.edu.uepb.eda.atividade04;

public class TabelaHash implements TabelaHash_IF {

    private LinkedList[] table;
    private int size;

    public TabelaHash(int size) {
        this.size = size;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList();
        }
    }

    @Override
    public void insert(Integer element) {
        int index = hash(element);
        table[index].insert(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int index = hash(element);
        table[index].remove(element);
    }

    public class ElementNotFoundException extends Exception {

        public ElementNotFoundException(String message) {
            super(message);
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        int index = hash(element);
        return table[index].search(element);
    }

    private int hash(Integer element) {
        return element % size;
    }

@Override
public String print() {
    String print = "";

    for (int i = 0; i < size; i++) {
        print += i + ": ";
        Integer[] array = table[i].toArray();
        if (array.length > 0) {
            print += array[0];
            for (int j = 1; j < array.length; j++) {
                print += ", " + array[j];
            }
        }
        print += "\n";
    }
    return print;
}



    // Lista Encadeada - Atividade 3

    public class LinkedList {
        protected Integer data;
        protected LinkedList next;

        public LinkedList() {
            data = null;
            next = null;
        }

        public boolean isEmpty() {
            return this.data == null;
        }

        public Integer size() {
            return sizeRecursive(this);
        }

        private int sizeRecursive(LinkedList current) {
            if (current.data == null) {
                return 0;
            }
            return 1 + sizeRecursive(current.next);
        }

        public int search(Integer element) throws Exception {
            return searchRecursive(this, element);
        }

        private int searchRecursive(LinkedList current, Integer element) throws Exception {
            if (current.data == null) {
                throw new Exception("Element not found.");
            }
            if (current.data.equals(element)) {
                return element;
            }
            return searchRecursive(current.next, element);
        }

        public void insert(Integer element) {
            LinkedList newNode = new LinkedList();
            newNode.data = this.data;
            newNode.next = this.next;

            this.data = element;
            this.next = newNode;
        }

        public void remove(Integer element) {
            removeRecursive(this, element);
        }

        private void removeRecursive(LinkedList current, Integer element) {
            if (current.data != null) {
                if (current.data.equals(element)) {
                    current.data = current.next.data;
                    current.next = current.next.next;
                } else {
                    removeRecursive(current.next, element);
                }
            }
        }

        public Integer[] toArray() {
            Integer[] array = new Integer[size()];
            toArrayRecursive(this, array, 0);
            return array;
        }

        private void toArrayRecursive(LinkedList current, Integer[] array, int index) {
            if (current.data != null) {
                array[index] = current.data;
                if (current.next != null) {
                    toArrayRecursive(current.next, array, index + 1);
                }
            }
        }
        
        
        
    }
}
