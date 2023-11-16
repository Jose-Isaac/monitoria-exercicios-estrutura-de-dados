package br.edu.uepb.eda.atividade04;

import java.util.LinkedList;
import java.util.Scanner;

public class Projeto implements TabelaHash_IF {

    private LinkedList<Integer>[] tabela;
    private int size;

    public Projeto(int size) {
        this.tabela = new LinkedList[size];
        this.size = size;
        for (int index = 0; index < size; index++) {
            tabela[index] = new LinkedList<>();
        }
    }

    private int Hash(Integer element) {
        return element % size;
    }

    @Override
    public void insert(Integer element) {
        int index = Hash(element);
        tabela[index].addFirst(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int index = Hash(element);
        if (tabela[index] == null) {
            throw new Exception("Elemento nao encontrado na tabela");
        }
        if (!tabela[index].remove(element)) {
            throw new Exception("Elemento nao encontrado na tabela");
        }
    }

    @Override
    public Integer search(Integer element) throws Exception {
        int index = Hash(element);
        if (tabela[index].contains(element)) {
            return element;
        } else {
            throw new Exception("Elemento nao encontrado na tabela");
        }
    }

    @Override
    public String print() {
        StringBuilder resultado = new StringBuilder();
        for (int index = 0; index < size; index++) {
            resultado.append(index).append(": ");
            if (!tabela[index].isEmpty()) {
                for (Integer elem : tabela[index]) {
                    resultado.append(elem).append(", ");
                }
                resultado.setLength(resultado.length() - 2);
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Projeto estoque = new Projeto(10);

        int opcao;
        do {
            System.out.println("=== Sistema de Gerenciamento de Estoque ===");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Buscar produto");
            System.out.println("4. Exibir estoque");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o codigo do produto a ser adicionado: ");
                    int codigoProduto = scanner.nextInt();
                    estoque.insert(codigoProduto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o codigo do produto a ser removido: ");
                    int codigoRemover = scanner.nextInt();
                    try {
                        estoque.remove(codigoRemover);
                        System.out.println("Produto removido com sucesso!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Digite o codigo do produto a ser buscado: ");
                    int codigoBuscar = scanner.nextInt();
                    try {
                        int resultado = estoque.search(codigoBuscar);
                        System.out.println("Produto encontrado: " + resultado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("=== Estoque Atual ===");
                    System.out.println(estoque.print());
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Ate logo!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}

