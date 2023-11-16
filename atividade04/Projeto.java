package atividade04;

import java.util.Random;
import java.util.Scanner;

public class Projeto {

    public static class User {

        public User() {

        }

        public String name;
        public String check_in_date;
        public String check_out_date;
        public int room_number;
        public int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCheck_in_date() {
            return check_in_date;
        }

        public void setCheck_in_date(String check_in_date) {
            this.check_in_date = check_in_date;
        }

        public String getCheck_out_date() {
            return check_out_date;
        }

        public void setCheck_out_date(String check_out_date) {
            this.check_out_date = check_out_date;
        }

        public int getRoom_number() {
            return room_number;
        }

        public void setRoom_number(int room_number) {
            this.room_number = room_number;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    }

    public static void main(String[] args) throws Exception {
        // A Pousada Gatchá é extremamente famosa na região do sul do Brasil.
        // Com a inovação da Pousada Gatchá, o cliente terá a experiência de descansar
        // em um quarto completamente aleatório, escolhido pelo mais puro RNG.
        // Pagando uma pequena taxa, o cliente poderá sortear novamente o número do seu
        // quarto.
        // A problemática é: O novo garoto do Ti, Joãozinho, queria uma demonstração de
        // uma forma de armazenar os IDs das reservas de uma pousada, então fizemos este
        // código para ele.
        TabelaHash hashTable = new TabelaHash(10);
        User usuario = new User();
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();

        Boolean stop = false;
        while (stop != true) {
            System.out
                    .println("1- Fazer uma reserva \n2- Cancelar a reserva \n3- Printar a tabela Hash e fechar o menu");

            System.out.print("\nEscolha: ");

            switch (sc.nextInt()) {
                case 1:
                    usuario.setId(rng.nextInt(100) + 1);
                    hashTable.insert(usuario.getId());

                    System.out.print("Nome do usuário: ");
                    usuario.setName(sc.next());

                    usuario.setRoom_number(rng.nextInt(50) + 1);
                    System.out.println("\nNúmero do quarto sorteado: " + usuario.getRoom_number());

                    System.out.println(
                            "Deseja pagar uma taxa para sortear o número do quarto novamente? \n1- Sim\n2- Não");
                    System.out.print("\nResposta: ");
                    int reroll = sc.nextInt();
                    while (reroll != 2) {

                        usuario.setRoom_number(rng.nextInt(50) + 1);
                        System.out.println("Número do quarto sorteado: " + usuario.getRoom_number());

                        System.out.println(
                                "Deseja pagar uma taxa para sortear o número do quarto novamente? \n1- Sim\n2-Não");
                        System.out.print("\nResposta: ");
                        reroll = sc.nextInt();
                    }

                    System.out.print("Data de check-in (dd/mm/aaaa): ");
                    usuario.setCheck_in_date(sc.next());

                    System.out.print("Data de check-out (dd/mm/aaaa): ");
                    usuario.setCheck_out_date(sc.next());

                    System.out.printf("ID da reserva: %s\n", usuario.getId());
                    System.out.println("------------------\n");

                    break;

                case 2:
                    hashTable.remove(usuario.getId());
                    System.out.println("Reserva removida com sucesso!");
                    break;

                case 3:
                    try {
                        System.out.println("Lista de reservas: \n" + hashTable.search(usuario.getId()));
                    } catch (Exception e) {
                        System.out.println("Elemento não encontrado!\n");
                    }
                    stop = true;
                    break;

            }
        }

        System.out.print("Lista de reservas: \n" + hashTable.print());

    }
}
