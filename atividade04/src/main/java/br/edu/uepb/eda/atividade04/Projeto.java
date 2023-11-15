package br.edu.uepb.eda.atividade04;

import java.util.Scanner;
import java.util.Random;

public class Projeto {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int option, key, floors, apartmentsPerFloor;
        Random generateRandomNumber = new Random();

        System.out.println("---------------- Gerenciamento de alugueis de apartamentos ----------------\n\n");

        System.out.print("Informe o número de andares do prédio: ");
        floors = scanner.nextInt();

        System.out.print("Informe a quantidade de apartamentos por andar: ");
        apartmentsPerFloor = scanner.nextInt();

        TabelaHash_IF apartments = new TabelaHash(floors * apartmentsPerFloor);

        do {
            System.out.println("\nSelecione a operação que deseja fazer:");
            System.out.println("[1] Alugar apartamento aleatório");
            System.out.println("[2] Encerrar aluguel do apartamento");
            System.out.println("[3] Buscar informações de um apartamento");
            System.out.println("[4] Vuzualizar situação dos apartamentos");
            System.out.println("[5] Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    key = generateRandomNumber.nextInt(floors * apartmentsPerFloor);
                    try {
                        while (apartments.search(key) == key) {
                            key = generateRandomNumber.nextInt(floors * apartmentsPerFloor);
                        }
                    } catch (Exception e) {
                        System.out.printf("\nNúmero do apartamento alugado: %d\n", key);
                    }
                    apartments.insert(key);
                    System.out.println("\nApartamento alugado com sucesso!");
                    break;

                case 2:
                    System.out.println("\nQual o número do apartamento que deseja encerrar o aluguel?");
                    int desocupar = scanner.nextInt();
                    try {
                        apartments.remove(desocupar);
                        System.out.println("Aluguel encerrado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Processo inválido. Apartamento informado não está no sistema!");
                    }
                    break;

                case 3:
                    System.out.println("\nQual o número do apartamento que deseja buscar?");
                    int buscar = scanner.nextInt();
                    try {
                        if (apartments.search(buscar) == buscar) {
                            System.out.printf("O apartamento está ocupado!\n");
                        }
                    } catch (Exception e) {
                        System.out.println("Processo inválido. Apartamento informado não está no sistema!");
                    }
                    break;

                case 4:
                    System.out.println("\nDescrições dos apartamentos:");
                    System.out.println(apartments.print());
                    break;

                case 5:
                    System.out.println("\nObrigado por utilizar nosso sistama de gerenciamento. Volte sempre!");
                    break;

                default:
                    System.out.println("\nOperação inexistente! Tente mais uma vez.");
                    break;
            }
        } while (option != 5);
    }

}
