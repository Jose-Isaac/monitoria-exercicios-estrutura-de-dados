
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaHash implements TabelaHash_IF {

    private static final int TAMANHO_TABELA = 8;
    private List<List<Integer>> tabela;

    public TabelaHash(int tamanho) {
        this.tabela = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            this.tabela.add(new LinkedList<>());
        }
    }

    @Override
    public void insert(Integer element) {
        int indice = calcularIndice(element);
        tabela.get(indice).add(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int indice = calcularIndice(element);
        if (!tabela.get(indice).remove(element)) {
            throw new Exception("Elemento não encontrado na tabela.");
        }
    }

    @Override
    public int search(Integer element) throws Exception {
        int indice = calcularIndice(element);
        List<Integer> lista = tabela.get(indice);
        if (lista.contains(element)) {
            return element;
        } else {
            throw new Exception("Elemento não encontrado na tabela.");
        }
    }

    @Override
    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tabela.size(); i++) {
            result.append(i).append(": ");
            List<Integer> lista = tabela.get(i);
            for (int j = lista.size() - 1; j >= 0; j--) {
                result.append(lista.get(j)).append(", ");
            }
            if (!lista.isEmpty()) {
                result.delete(result.length() - 2, result.length());
            }
            result.append("\n");
        }
        return result.toString();
    }

    private int calcularIndice(Integer element) {
        return Math.abs(element.hashCode() % tabela.size());
    }
}