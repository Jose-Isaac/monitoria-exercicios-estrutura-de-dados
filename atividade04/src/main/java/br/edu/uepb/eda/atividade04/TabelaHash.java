package  br.edu.uepb.eda.atividade04;
import java.util.LinkedList;


public class TabelaHash implements TabelaHash_IF{

    private static final int tam = 8;
    private LinkedList<Integer>[] tabela;

    public TabelaHash(Integer i) {
        this.tabela = new LinkedList[tam];
        for (int j = 0; j < tam; j++) {
            tabela[j] = new LinkedList<>();
        }
    }

    private int methash(Integer element) {
        return element % tam;
    }

    @Override
    public void insert(Integer element) {
        int index = methash(element);
        tabela[index].addFirst(element);
    }
    @Override
    public void remove(Integer element) throws Exception {
        int index = methash(element);
        if (tabela[index] == null) {
            throw new Exception("Elemento não encontrado na tabela");
        }
        if (!tabela[index].remove(element)) {
            throw new Exception("Elemento não encontrado na tabela");
        }
    }

    @Override

    public Integer search(Integer element) throws Exception {
        int index = methash(element);
        if (tabela[index].contains(element)) {
            return element;
        } else {
            throw new Exception("Elemento não encontrado na tabela");
        }
    }
    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tam; i++) {
            result.append(i).append(": ");
            if (!tabela[i].isEmpty()) {
                for (Integer elem : tabela[i]) {
                    result.append(elem).append(", ");
                }
                result.setLength(result.length() - 2);
            }
            result.append("\n");
        }
        return result.toString();
    }

}