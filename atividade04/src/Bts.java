
import java.util.HashMap;
import java.util.Map;

public class Bts implements BST_IF {
    Integer data;
    Bts pai;
    Bts filho_esq;
    Bts filho_dir;
    String mes;

    //Usado na classe Projeto.main
    private Bts(Integer data, String mes){
        this(null, null, null, null,mes);
    }
    private  Bts(Integer data, Bts pai) {
        this(data, pai, null, null,null);
    }

    private  Bts(Integer data, Bts pai, String mes) {
        this(data, pai, null, null,mes);
    }
    public Bts() {
        this(null, null, null, null ,null);
    }

    public Bts(Integer data){
        this(data, null, null, null, null);
    }

    private Bts(Integer data, Bts pai, Bts filho_esq, Bts filho_dir,String mes) {
        this.data = data;
        this.pai = pai;
        this.filho_esq = filho_esq;
        this.filho_dir = filho_dir;
        this.mes = mes;
    }


    @Override
    public void insert(int element) {
        if(isEmpty()) {
            this.data = element;
        }
        else if (this.data.intValue() > element) {
            if (this.filho_esq != null) 
                this.filho_esq.insert(element);
            else 
                this.filho_esq = new Bts(element, this);

        } else if (this.data.intValue() < element){
            if (this.filho_dir != null)
                this.filho_dir.insert(element);
            else
                this.filho_dir = new Bts(element, this);

        }
    }

    public void insert(int element,String mes) {
        if(isEmpty()) {
            this.data = element;
            this.mes = mes;
        }
        else if (this.data.intValue() > element) {
            if (this.filho_esq != null)
                this.filho_esq.insert(element, mes);
            else
                this.filho_esq = new Bts(element, this, mes);

        } else if (this.data.intValue() < element){
            if (this.filho_dir != null)
                this.filho_dir.insert(element, mes);
            else
                this.filho_dir = new Bts(element, this, mes);
        }
    }

    public int remove(int element) throws Exception{
        if(this.data==null){
            throw new Exception("");
        }
        else if(element<(int) this.data){
            if ((this.filho_esq!=null)) this.filho_esq.remove(element);

            else throw new Exception("");
        } else if (element>(int) this.data) {
            if ((this.filho_dir!=null)) this.filho_dir.remove(element);
            else throw new Exception("");
        } else  {
            if(this.filho_dir==null && this.filho_esq==null){
                if((int) this.pai.data> this.data){
                    this.pai.filho_esq=null;
                }
                else this.pai.filho_dir=null;

            } else if (this.filho_dir!=null && this.filho_esq==null) {
                Bts substituto = this.filho_dir;
                Bts paiSubstituto = this;
                while(substituto.filho_dir !=null){
                    paiSubstituto=substituto;
                    substituto=this.filho_dir;
                }
                //Atual
                if((int) this.pai.data> this.data){
                    this.data=substituto.data;
                }
                else this.data=substituto.data;


                //Variáveis
                if((int) paiSubstituto.data> this.data){
                    paiSubstituto.filho_esq=null;
                }
                else paiSubstituto.filho_dir=null;

            }else if(this.filho_esq!=null && this.filho_dir==null){
                Bts substituto = this.filho_esq;
                Bts paiSubstituto = this;
                while(substituto.filho_dir !=null){
                    paiSubstituto=substituto;
                    substituto=this.filho_dir;
                }
                //Atual
                if((int) this.pai.data> this.data){
                    this.data=substituto.data;
                }
                else this.data=substituto.data;


                //Variáveis
                if((int) paiSubstituto.data> this.data){
                    paiSubstituto.filho_esq=null;
                }
                else paiSubstituto.filho_dir=null;

            }
        }

        return element;
    }

    @Override
    public Integer search(int element) throws Exception {
        if (this.data == null) throw new Exception("Elemento não encontrado!");
        if (this.data.equals(element)) {
            return element;
        }
        else if((int)this.data < element){
            if (this.filho_dir == null)
                throw new Exception("Elemento não encontrado!");

            if(this.filho_dir.isEmpty()){
                throw new Exception("Elemento não encontrado!");
            }
            return this.filho_dir.search(element);
        }
        else{
            if (this.filho_esq == null) 
                throw new Exception("Elemento não encontrado!");

            if(this.filho_esq.isEmpty()){
                throw new Exception("Elemento não encontrado!");
            }
            return this.filho_esq.search(element);
        }

    }
    public String mesesAbaixoDaMeta() {
        Map<String, Integer> map = new HashMap<>();
        preOrderRecursive(this.filho_esq, map);
        StringBuilder sb = new StringBuilder();
        map.forEach((mes, valor) -> {
            sb.append("Mês: " + mes + "\nValor: " + valor + "\n");
        });
        return sb.toString();
    }

    public String mesesAcimaDaMeta() {
        Map<String, Integer> map = new HashMap<>();
        preOrderRecursive(this.filho_dir, map);
        StringBuilder sb = new StringBuilder();
        map.forEach((mes, valor) -> {
            sb.append("Mês: " + mes + "\nValor: " + valor + "\n");
        });
        return sb.toString();
    }
    private int size(Bts tree) {
        if (tree == null) return 0;
        return 1 + size(tree.filho_esq) + size(tree.filho_dir);
    }

    public int size() {
        return size(this);
    }
    @Override
    public int[] preOrder() {
        int[] array = new int[size()];
        preOrderRecursive(this, array,0);
        return array;
    }

    private void preOrderRecursive(Bts tree,int[] array, int i) {
        if (tree == null) return;
        array[i++] = tree.data;
        preOrderRecursive(tree.filho_esq, array, i);
        preOrderRecursive(tree.filho_dir, array, i + size(tree.filho_dir));
    }

    private void preOrderRecursive(Bts tree, Map<String, Integer> map) {
        if (tree == null) return;
        map.put(tree.mes, tree.data);
        preOrderRecursive(tree.filho_esq, map);
        preOrderRecursive(tree.filho_dir, map);
    }

    @Override
    public int[] order() {
        int[] array = new int[size()];
        orderRecursive(this, array,0);
        return array;
    }

    private int orderRecursive(Bts tree, int[] array, int i){
        if (tree == null) return i;
        i = orderRecursive(tree.filho_esq, array, i);
        array[i++] = tree.data;
        i = orderRecursive(tree.filho_dir, array, i);
        return i;
    }

    @Override
    public int[] postOrder() {
        int[] array = new int[size()];
        postOrderRecursive(this, array,0);
        return array;
    }

    private int postOrderRecursive(Bts tree, int[] array, int i){
        if (tree == null) return i;
        i = postOrderRecursive(tree.filho_esq, array, i);
        i = postOrderRecursive(tree.filho_dir, array, i);
        array[i++] = tree.data;
        return i;
    }

    @Override
    public boolean isComplete() {
        int h = -1;
        for (Bts aux = this; aux != null; aux = aux.filho_esq) {
            h++;
        }
        int total = (int) (Math.pow(2, h + 1) - 1);
        return size() == total;
    }

    public boolean isEmpty(){
        return this.data == null;
    }

    @Override
    public String toString() {

        return mesesAbaixoDaMeta() + " " + mesesAcimaDaMeta();
    }
}
