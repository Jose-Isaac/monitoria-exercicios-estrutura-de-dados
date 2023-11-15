package br.edu.uepb.eda.atividade04;

import java.util.Scanner;

public class Projeto {
    public static void main(String[] args) throws Exception {
        /* 
         O projeto é uma agenda de numeros de telefones, no qual o objetivo
         é mapear os numeros para cada indice na tabela hash correspondente aquele número, pegando o seu primeiro digito e salvando o numero.
         Juntamente com outras manipulações, por exemplo o Buscar intervalos que
         utiliza o metódo print() da tabela hash para manipular intervalos.
        */

        Scanner scanner = new Scanner(System.in);
        TabelaHash tabela = new TabelaHash(10);

        boolean sair = false;
        int escolha;

        while (!sair) {
            System.out.println("======== Agenda Telefonica ========");
            System.out.println("1. Adicionar telefone");
            System.out.println("2. Remover Telefone");
            System.out.println("3. Buscar telefones");
            System.out.println("4. Buscar por intervalos");
            System.out.println("5. Ver lista e total telefones");
            System.out.println("6. Sair");
            System.out.println("==================================");

            try {
                System.out.print("Escolha: ");
                escolha = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                escolha = 0;
            }
            
            switch (escolha) {
                case 1:
                    System.out.print("Informe o numero: ");
                    try {
                        int numero = scanner.nextInt();
                        scanner.nextLine();
                        int primeiroDigito = Integer.parseInt(Integer.toString(numero).substring(0, 1));
                        tabela.insertForProject(primeiroDigito, numero);
                        System.out.println("----Número agendado----");
                    } catch (Exception e) {
                        System.out.println("Numero invalido ou Numero ja existe");
                        continue;
                    }
                    break;
                case 2:
                    System.out.print("Informe o numero para remover: ");
                    try {
                        int numero = scanner.nextInt();
                        scanner.nextLine();
                        int primeiroDigito = Integer.parseInt(Integer.toString(numero).substring(0, 1));
                        tabela.removeForProject(primeiroDigito, numero);
                        System.out.println("----Numero removido----");
                    } catch (Exception e) {
                        System.out.println("Numero invalido ou Numero nao encontrado");
                        continue;
                    }
                    break;
                case 3:
                    System.out.print("Informe o primeiro digito: ");
                    try {
                        int numero = scanner.nextInt();
                        scanner.nextLine();

                        buscarTelefones(tabela.print(), numero);
                    } catch (Exception e) {
                        System.out.println("Número inválido");
                        scanner.nextLine();
                        continue;
                    }
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Informe o intervalo 0-9: ");
                    try {
                        String intervalo = scanner.nextLine();
                        String[] lista = intervalo.split("-");
        
                        if (lista.length != 2) {
                            throw new IllegalArgumentException();
                        }
        
                        int min = Integer.parseInt(lista[0]);
                        int max = Integer.parseInt(lista[1]);
        
                        if (min > max || max > 9 || min < 0) {
                            throw new IllegalArgumentException();
                        }
        
                        buscarIntervalos(tabela.print(), min, max);
                    } catch (Exception e) {
                        System.out.println("Intervalo invalido");
                        continue;
                    }
                    break;
                case 5:
                    System.out.println("Total de numeros: " + tabela.total());
                    System.out.println(tabela.print());
                    break;
                case 6:
                    scanner.close();
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }
    }

    public static void buscarTelefones(String input, int indice){
        String[] linhas = input.split("\n");
        for (String linha : linhas) {
            String[] partes = linha.split(":");
            if (partes.length == 2) {
                int indicetest = Integer.parseInt(partes[0].trim());
                String valores = partes[1].trim();
                if (indicetest == indice) {
                    String[] valoresSeparados = valores.split(",");
                    for (String valor : valoresSeparados) {
                        System.out.println("* Telefone: " + valor.trim() + " *");
                    }
                }
            }
        }
    }

    public static void buscarIntervalos(String input, int min, int max) {
        String[] linhas = input.split("\n");
        for (String linha : linhas) {
            String[] partes = linha.split(":");
            if (partes.length == 2) {
                int indice = Integer.parseInt(partes[0].trim());
                String valores = partes[1].trim();

                if (indice >= min && indice <= max) {
                    String[] valoresSeparados = valores.split(",");
                    System.out.print(indice + ": ");
                    StringBuilder resultado = new StringBuilder();

                    for (String valor : valoresSeparados) {
                        String trimmedValor = valor.trim();
                        if (!trimmedValor.isEmpty()) {
                            resultado.append(trimmedValor).append(", ");
                        }
                    }

                    if (resultado.length() > 0) {
                        resultado.setLength(resultado.length() - 2);
                        System.out.println(resultado);
                    } else {
                        System.out.println();
                    }
                }
            }
        }
    }
    
}
