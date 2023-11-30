package ExemploAplicacao;

import java.util.Scanner;

public class Loja {
    private static void inserirManga(TabelaHashManga tabela, Scanner scanner) {
        System.out.print("ID do Manga: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Título do Manga: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor do Manga: ");
        String autor = scanner.nextLine();

        Manga manga = new Manga(id, titulo, autor);
        tabela.insert(manga);
        System.out.println("Manga inserido com sucesso!");
    }
    private static void removerManga(TabelaHashManga tabela, Scanner scanner){
        System.out.print("ID do Manga a remover: ");
        int id = scanner.nextInt();

        try {
            Manga manga = tabela.search(id);
            tabela.remove(manga);
            System.out.println("Manga removido com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void buscarManga(TabelaHashManga tabela, Scanner scanner) {
        System.out.print("ID do Manga a buscar: ");
        int id = scanner.nextInt();

        try {
            Manga manga = tabela.search(id);
            System.out.println("Manga encontrado: " + manga.getTitulo() + " por " + manga.getAutor());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        TabelaHashManga tabelaMangas = new TabelaHashManga(10); // Supondo um tamanho fixo para simplificar

        while (true) {
            System.out.println("\n--- Loja de Mangás ---");
            System.out.println("1. Inserir Manga");
            System.out.println("2. Remover Manga");
            System.out.println("3. Buscar Manga");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    inserirManga(tabelaMangas, scanner);
                    break;
                case 2:
                    removerManga(tabelaMangas, scanner);
                    break;
                case 3:
                    buscarManga(tabelaMangas, scanner);
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        /*
            Esse é um exemplo bem básico da implementação de uma tabelahash em um caso real. Utilizamos uma versão que aceita
            um objeto para representamos mangas, mas poderia servir para varios tipos diferentes, agora estamos implementando
            uma loja de mangas que precisa de uma busca eficiente de seus produtos e a tabela atende bem esse quesito, de forma
            rápida e simples de ser implementada.
         */






    }
}
