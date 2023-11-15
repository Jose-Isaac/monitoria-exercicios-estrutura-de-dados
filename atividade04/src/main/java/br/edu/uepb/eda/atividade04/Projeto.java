package br.edu.uepb.eda.atividade04;

import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) {
        BST matriculaTree = new BST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n||Gerenciamento de Mátricula da UEPB||");
            System.out.println("(1) Adicionar Mátricula");
            System.out.println("(2) Buscar Mátricula)");
            System.out.println("(3) Exibir Mátriculas");
            System.out.println("(0) Sair");
            System.out.print("Opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Número da Mátricula que deseja adicionar: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();
                    matriculaTree.insert(matricula);
                    System.out.println("Mátricula Adicionada!");
                    break;
                case 2:
                    System.out.print("Número da Mátricula que deseja buscar: ");
                    int matriculaBuscar = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        int matriculaEncontrado = matriculaTree.search(matriculaBuscar);
                        System.out.println("Mátricula encontrada: " + matriculaEncontrado);
                    } catch (Exception e) {
                        System.out.println("Mátricula não encontrada no banco de dados.");
                    }
                    break;
                case 3:
                    Integer[] matriculasInOrder = matriculaTree.order();
                    System.out.println("\n--- MÁTRICULAS ---");
                    for (int matriculaLista : matriculasInOrder) {
                        System.out.println("Mátricula: " + matriculaLista);
                    }
                    break;
                case 0:
                    System.out.println("ENCERRADO.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inexistente.");
            }
        }
    }
}