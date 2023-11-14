package br.edu.uepb.eda.atividade04;

import java.util.Scanner;

public class Projeto {

    class Game {
        String name;
        String platform;
        int year;
    }

    public class GameLinkedList {
        protected Game data;
        protected GameLinkedList next;

        public boolean isEmpty() {
            return this.data == null;
        }

        public int size() {
            if (this.isEmpty())
                return 0;

            return 1 + this.next.size();
        }

        public Game search(String name) throws Exception {
            if (this.isEmpty())
                throw new Exception("Esse jogo não existe na lista");

            if (this.data.name.equals(name))
                return this.data;

            return this.next.search(name);
        }

        public void insert(Game element) {
            GameLinkedList current = new GameLinkedList();
            current.data = this.data;
            current.next = this.next;

            this.data = element;
            this.next = current;
        }

        public void remove(Game element) {
            if (this.isEmpty())
                return;

            if (this.data.equals(element)) {
                this.data = this.next.data;
                this.next = this.next.next;
            } else {
                this.next.remove(element);
            }
        }

        public Game[] toArray() {
            Game[] array = new Game[this.size()];

            toArray(array, this, 0);

            return array;
        }

        private static void toArray(Game[] array, GameLinkedList GameLinkedList, int i) {
            if (!GameLinkedList.isEmpty()) {
                array[i] = GameLinkedList.data;
                toArray(array, GameLinkedList.next, i + 1);
            }
        }
    }

    public class GameTable {
        private GameLinkedList[] table;
        private int length;

        public GameTable(int length) {
            this.length = length;
            this.table = new GameLinkedList[length];

            for (int i = 0; i < this.table.length; i++) {
                this.table[i] = new GameLinkedList();
            }

        }

        public void insert(Game game) {
            int i = game.name.length() % this.length;

            this.table[i].insert(game);
        }

        public void remove(Game game) throws Exception {
            int i = game.name.length() % this.length;

            this.table[i].remove(game);
        }

        public Game search(String name) throws Exception {
            int i = name.length() % this.length;

            return this.table[i].search(name);
        }

        public String print() {
            String stringToPrint = "";

            for (int i = 0; i < this.table.length; i++) {
                Game[] games = this.table[i].toArray();

                stringToPrint += i + ": ";

                for (int j = 0; j < games.length; j++) {
                    if (j + 1 == games.length) {
                        stringToPrint += games[j].name;
                    } else {
                        stringToPrint += games[j].name + ", ";
                    }
                }

                stringToPrint += "\n";
            }

            return stringToPrint;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameTable gameTable = new Projeto().new GameTable(11);

        addGames(gameTable);

        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir Jogo");
            System.out.println("2. Remover Jogo");
            System.out.println("3. Pesquisar Jogo");
            System.out.println("4. Mostrar Tabela");
            System.out.println("5. Sair");
            System.out.print("\nEscolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Game novoJogo = new Projeto().new Game();

                    System.out.print("Nome do jogo: ");
                    novoJogo.name = scanner.nextLine();

                    System.out.print("Plataforma: ");
                    novoJogo.platform = scanner.nextLine();

                    System.out.print("Ano de lançamento: ");
                    novoJogo.year = scanner.nextInt();

                    gameTable.insert(novoJogo);
                    break;

                case 2:
                    System.out.print("Nome do jogo a ser removido: ");
                    String nomeJogoRemover = scanner.nextLine();

                    try {
                        Game jogoRemover = gameTable.search(nomeJogoRemover);
                        gameTable.remove(jogoRemover);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Nome do jogo a ser pesquisado: ");
                    String nomeJogoPesquisar = scanner.nextLine();

                    try {
                        Game jogoPesquisado = gameTable.search(nomeJogoPesquisar);
                        System.out.println("Jogo encontrado: " + jogoPesquisado.name + " Plataforma: "
                                + jogoPesquisado.platform + " Ano: " + jogoPesquisado.year);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\nTabela de Jogos:");
                    System.out.println(gameTable.print());
                    System.out.println("Pressione Enter para voltar ao menu.");
                    scanner.nextLine(); // Aguarda o Enter para prosseguir
                    break;

                case 5:
                    System.out.println("Encerrando o programa. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    public static void addGames(GameTable gameTable) {
        Game[] jogos = new Game[13];

        jogos[0] = new Projeto().new Game();
        jogos[0].name = "God of War";
        jogos[0].platform = "PlayStation";
        jogos[0].year = 2005;

        jogos[1] = new Projeto().new Game();
        jogos[1].name = "God of War II";
        jogos[1].platform = "PlayStation";
        jogos[1].year = 2007;

        jogos[2] = new Projeto().new Game();
        jogos[2].name = "GTA San Andreas";
        jogos[2].platform = "Multiplataforma";
        jogos[2].year = 2004;

        jogos[3] = new Projeto().new Game();
        jogos[3].name = "PES 2018";
        jogos[3].platform = "Multiplataforma";
        jogos[3].year = 2017;

        jogos[4] = new Projeto().new Game();
        jogos[4].name = "Need for Speed Underground 2";
        jogos[4].platform = "Multiplataforma";
        jogos[4].year = 2004;

        jogos[5] = new Projeto().new Game();
        jogos[5].name = "Need for Speed Most Wanted";
        jogos[5].platform = "Multiplataforma";
        jogos[5].year = 2005;

        jogos[6] = new Projeto().new Game();
        jogos[6].name = "Dragon Ball Z Budokai Tenkaichi 3";
        jogos[6].platform = "PlayStation";
        jogos[6].year = 2007;

        jogos[7] = new Projeto().new Game();
        jogos[7].name = "Medal of Honor Vanguard";
        jogos[7].platform = "PlayStation";
        jogos[7].year = 2007;

        jogos[8] = new Projeto().new Game();
        jogos[8].name = "Far Cry 3";
        jogos[8].platform = "Multiplataforma";
        jogos[8].year = 2012;

        jogos[9] = new Projeto().new Game();
        jogos[9].name = "Bully";
        jogos[9].platform = "Multiplataforma";
        jogos[9].year = 2006;

        jogos[10] = new Projeto().new Game();
        jogos[10].name = "The Last Of Us";
        jogos[10].platform = "PlayStation";
        jogos[10].year = 2013;

        jogos[11] = new Projeto().new Game();
        jogos[11].name = "Red Dead Redemption";
        jogos[11].platform = "PlayStation";
        jogos[11].year = 2010;

        jogos[12] = new Projeto().new Game();
        jogos[12].name = "The Legend of Zelda: Breath of the Wild";
        jogos[12].platform = "Nintendo Switch";
        jogos[12].year = 2017;

        for (Game jogo : jogos) {
            gameTable.insert(jogo);
        }

        System.out.println("Jogos inseridos previamente na tabela.");
    }

}