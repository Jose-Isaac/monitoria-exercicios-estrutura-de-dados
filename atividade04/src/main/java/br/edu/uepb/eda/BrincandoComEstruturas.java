import java.util.Random;

public class BrincandoComEstruturas {

    public static void main(String[] args) throws Exception {

        System.out.println("Brincando com BST...");
        BST_IF minhaArvore = new BST(); // Altere para a implementação concreta MinhaBST
        minhaArvore.insert(8);
        System.out.println(minhaArvore.isComplete());
        System.out.println(Arrays.toString(minhaArvore.preOrder()).equals("[8]"));
        System.out.println(Arrays.toString(minhaArvore.order()).equals("[8]"));
        System.out.println(Arrays.toString(minhaArvore.postOrder()).equals("[8]"));
        minhaArvore.insert(12);
        System.out.println(!minhaArvore.isComplete());

        // Restante do código...

        System.out.println();

        System.out.println("Brincando com TabelaHash...");
        TabelaHash_IF minhaTabelaHash = new TabelaHash(8);
        System.out.println(minhaTabelaHash.print().equals("0: \n1: \n2: \n3: \n4: \n5: \n6: \n7: \n"));

        // Restante do código...

        System.out.println();

        //OBS.: Espera-se que nenhum print mostre 'false' na tela!
        //é usada para encontrar o maior número na lista que seja menor do que o valor de referência (neste caso, 9).
        BST_IF bst = new BST(); // Altere para a implementação concreta MinhaBST

        int[] numeros = gerarListaAleatoria();

        int valorReferencia = 9;

        for (int num : numeros) {
            bst.insert(num);
        }

        Integer maiorMenorValor = encontrarMaiorMenorValor(bst, valorReferencia);

        if (maiorMenorValor != null) {
            System.out.println("O maior número menor que " + valorReferencia + " na lista é: " + maiorMenorValor);
        } else {
            System.out.println("Nenhum número menor que " + valorReferencia + " foi encontrado na lista.");
        }
    }

    private static int[] gerarListaAleatoria() {
        Random random = new Random();
        int tamanho = random.nextInt(10) + 5; // Gerar uma lista com 5 a 14 números
        int[] numeros = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            numeros[i] = random.nextInt(50); // Gerar números aleatórios entre 0 e 49
        }

        return numeros;
    }

    private static Integer encontrarMaiorMenorValor(BST_IF bst, int valorReferencia) {
        int resultado = Integer.MIN_VALUE;
        BST_IF atual = bst;

        while (atual != null) {
            if (atual.data < valorReferencia) {
                resultado = atual.data;
                atual = atual.getLeftChild(); // Use o método apropriado para obter o filho à esquerda
            } else {
                atual = atual.getRightChild(); // Use o método apropriado para obter o filho à direita
            }
        }

        return resultado;
    }
}