package br.edu.uepb.eda.atividade04;

import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) {
        BST contatoTree = new BST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Gerenciamento de Contatos ===");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Buscar Contato");
            System.out.println("3. Exibir Todos os Contatos");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Número de Telefone do Contato: ");
                    int telefone = scanner.nextInt();
                    scanner.nextLine();
                    contatoTree.insert(telefone);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Número de Telefone do Contato a ser buscado: ");
                    int telefoneBuscar = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        int contatoEncontrado = contatoTree.search(telefoneBuscar);
                        System.out.println("Contato encontrado: " + contatoEncontrado);
                    } catch (Exception e) {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 3:
                    int[] contatosInOrder = contatoTree.order();
                    System.out.println("\n--- Lista de Contatos ---");
                    for (int telefoneContato : contatosInOrder) {
                        System.out.println("Telefone: " + telefoneContato);
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
