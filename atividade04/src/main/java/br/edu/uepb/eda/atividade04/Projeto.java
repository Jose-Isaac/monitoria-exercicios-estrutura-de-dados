package br.edu.uepb.eda.atividade04;

import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        Dicionario dicionario = new Dicionario(26);
        int opcao = 0;

        do {
            printMenu();
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    System.out.println("Insira a palavra:");
                    String palavra = sc.nextLine();
                    System.out.println("Insira o significado:");
                    String significado = sc.nextLine();
                    dicionario.insert(palavra, significado);
                    System.out.println("Palavra inserida com sucesso");
                    break;
                case 2:
                    System.out.println("Insira a palavra:");
                    palavra = sc.nextLine();
                    dicionario.remove(palavra);
                    System.out.println("Palavra removida com sucesso");
                    break;
                case 3:
                    System.out.println("Insira a palavra:");
                    palavra = sc.nextLine();
                    try {
                        System.out.println(dicionario.search(palavra));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(dicionario.print());
                    break;
                case 5:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opçao invalida.");
            }
        } while (opcao != 5);

        sc.close();

    }

    public static void printMenu() {
        System.out.println("----- DICIONARIO DE PALAVRAS -----");
        System.out.println("1 - Inseririr palavra");
        System.out.println("2 - Remover palavra");
        System.out.println("3 - Procurar palavra");
        System.out.println("4 - Imprimir dicionário");
        System.out.println("5 - Sair");
        System.out.println("Insira a opção desejada:");
    }
}
