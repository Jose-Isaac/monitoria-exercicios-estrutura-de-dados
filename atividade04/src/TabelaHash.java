public class TabelaHash implements TabelaHash_IF {
    public HashNode[] buckets;
    public int numOfBuckets;
    public int size;

    public TabelaHash(int i) {
        this.numOfBuckets = i;
        this.size = 0;
        buckets = new HashNode[numOfBuckets];
        for (int j = 0; j < numOfBuckets; j++) {
            buckets[j] = new HashNode();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int hashFuncion(int inteiro) {
        if (inteiro < this.numOfBuckets) return inteiro;

        return inteiro%numOfBuckets;
    }


    @Override
    public void insert(Integer element) {
        buckets[hashFuncion(element)].insert(element);
    }
//    [] - > e -> null
//    []-> null
//    []-null
    @Override
    public void remove(Integer element) throws Exception {
        buckets[hashFuncion(element)].remove(element);
    }

    @Override
    public int search(Integer element) throws Exception {
        return buckets[hashFuncion(element)].search(element);
    }

    @Override
    public String print() {
        String hashString="";
        for (int i=0;i<numOfBuckets;i++){
            hashString+= i +": " + this.buckets[i].toString() +"\n";
        }
        return hashString;
    }
    
}
