package br.edu.uepb.eda.atividade04;

public class BrincandoComArvoresAVLePV {
    public static void main(String[] args) {
        AVL arvoreAVL = new AVL();

        arvoreAVL.insert(1);
        arvoreAVL.insert(2);
        arvoreAVL.insert(3);
        arvoreAVL.insert(5);
        arvoreAVL.insert(11);
        arvoreAVL.insert(12);

        // Imprime a árvore em ordem
        System.out.print("Árvore AVL em inOrder: ");
        arvoreAVL.inOrder(arvoreAVL.getRoot());
        // Imprime a árvore em preordem
        System.out.print("\nÁrvore AVL em preOrder: ");
        arvoreAVL.preOrder(arvoreAVL.getRoot());
        // Imprime a árvore em posordem
        System.out.print("\nÁrvore AVL em posOrder: ");
        arvoreAVL.posOrder(arvoreAVL.getRoot());
        // Imprime a altura da árvore
        System.out.printf("\nAltura da Árvore: %d", arvoreAVL.getHeight());
        // Imprime a raiz da árvore
        System.out.printf("\nRaiz: %d", arvoreAVL.getRoot().key);

        arvoreAVL.insert(15);
        arvoreAVL.insert(25);
        arvoreAVL.insert(30);
        arvoreAVL.insert(35);
        arvoreAVL.insert(50);
        arvoreAVL.insert(70);

        System.out.println("\n");

        // Imprime a árvore em ordem
        System.out.print("Árvore AVL em inOrder: ");
        arvoreAVL.inOrder(arvoreAVL.getRoot());
        // Imprime a árvore em preordem
        System.out.print("\nÁrvore AVL em preOrder: ");
        arvoreAVL.preOrder(arvoreAVL.getRoot());
        // Imprime a árvore em posordem
        System.out.print("\nÁrvore AVL em posOrder: ");
        arvoreAVL.posOrder(arvoreAVL.getRoot());
        // Imprime a altura da árvore
        System.out.printf("\nAltura da Árvore: %d", arvoreAVL.getHeight());
        // Imprime a raiz da árvore
        System.out.printf("\nRaiz: %d", arvoreAVL.getRoot().key);

        System.out.println("\n");

        ArvorePV<Integer, String> arvorePV = new ArvorePV<>();

        // Inserção de elementos na árvore
        arvorePV.put(10, "Valor 5");
        arvorePV.put(5, "Valor 10");
        arvorePV.put(15, "Valor 30");
        arvorePV.put(3, "Valor 3");
        arvorePV.put(7, "Valor 7");

        // Busca por valores
        System.out.println("Valor para chave 10: " + arvorePV.get(5));
        System.out.println("Valor para chave 5: " + arvorePV.get(10));
        System.out.println("Valor para chave 15: " + arvorePV.get(15));
        System.out.println("Valor para chave 7: " + arvorePV.get(7));
    }
}