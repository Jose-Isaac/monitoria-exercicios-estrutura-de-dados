
package br.edu.uepb.eda.atividade01;

public class Busca implements Busca_IF {

    public int[] geraVetorNumericoOrdenado(int tamanho) { // Método para gerar um vetor numérico ordenado de tamanho
                                                          // especificado.
        int vetor[] = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = i + 1;
        }
        System.out.println("Gerou o vetor ordenado.\n");
        return vetor;
    }

    public boolean buscaLinear_iterativa(int[] numeros, int k) { // Busca linear: percorre o vetor comparando posicão
                                                                 // por posição.
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == k) {
                return true;
            }
        }
        return false;
    }

    public boolean buscaLinear_recursiva(int[] numeros, int k) { // Busca linear recursiva: chama a função auxiliar
                                                                 // recursiva.
        return buscaLinearRecursivaAux(numeros, k, 0);
    }

    public boolean buscaLinearRecursivaAux(int[] numeros, int k, int indice) { // Metodo auxiliar recursivo para busca
                                                                               // linear.
        if (indice == numeros.length) {
            return false;
        }
        if (numeros[indice] == k) {
            return true;
        }
        return buscaLinearRecursivaAux(numeros, k, indice + 1);
    }

    public boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k) { // Busca bidirecional: percorre o vetor da
                                                                            // esquerda e da direita em direção ao meio
                                                                            // ao mesmo tempo.
        int sup = numeros.length - 1;
        int inf = 0;

        while (inf <= sup) {
            if (numeros[inf] == k || numeros[sup] == k) {
                return true;
            }
            sup--;
            inf++;
        }
        return false;
    }

    public boolean buscaBinaria_iterativa(int[] numeros, int k) { // Busca binária: busca dividindo o vetor varias
                                                                  // vezes.
        int inf = 0;
        int sup = numeros.length - 1;
        while (inf <= sup) {
            int meio = (inf + sup) / 2;
            if (k == numeros[meio]) {
                return true;
            } else if (k < numeros[meio]) {
                sup = meio - 1;
            } else {
                inf = meio + 1;
            }
        }
        return false;
    }

    public boolean buscaBinaria_recursiva(int[] numeros, int k) { // Busca binária recursiva: chama a função auxiliar
                                                                  // recursiva.
        return buscaBinariaRecursivaAux(numeros, k, 0, numeros.length - 1);
    }

    private boolean buscaBinariaRecursivaAux(int[] numeros, int k, int sup, int inf) { // Metodo auxiliar recursivo para
                                                                                       // busca binária.
        if (sup > inf) {
            return false;
        }
        int meio = (sup + inf) / 2;
        if (k == numeros[meio]) {
            return true;
        }
        if (k < numeros[meio]) {
            return buscaBinariaRecursivaAux(numeros, k, sup, meio - 1);
        }
        return buscaBinariaRecursivaAux(numeros, k, meio + 1, inf);
    }
}