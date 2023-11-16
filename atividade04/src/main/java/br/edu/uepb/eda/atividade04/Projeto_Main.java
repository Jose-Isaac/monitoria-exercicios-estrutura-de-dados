package br.edu.uepb.eda.atividade04;

public class Projeto_Main {

    public static void main(String[] args) throws Exception {

        /* Comentários sobre o projeto:
         * Descrição:
         * Se trata de um mini sistema de gerenciamento de uma biblioteca utilizando uma árvore binária de busca.
         * O Node além da String nome, e os filhos esquerdo e direito também possui o atributo 'copies', sinalizando
         * quantas cópias da obra a biblioteca possui. Os métodos da classe BST são: insert, search, remove,
         * order (retorna uma lista indicando a quantidade de cópias e o título do livros), compare (indica onde o nó
         * está ou para onde irá), count_nos (retorna o número de livros sem considerar a quantidade de cópias) e
         * altura (calcula a altura iniciando do 0).
         *
         * Algumas limitações:
         * 1. O método compare() é utilizado diversas vezes, o tempo de execução com muitos valores pode não ser dos
         * melhores, pois, dentro dele há um for que é interrompido ou quando encontra a string "menor" ou quando
         * i = tamanho da menor string, ou seja, um custo linear.
         * 2. O ideal para esse tipo de aplicação seria a ávore AVL, e isso se dá por dois pontos: em uma biblioteca
         * há muitas consultas, seria execelente garantirmos o custo como O(log n), além disso, existem muitos livros
         * iniciados com a letra "O" ou "A", caso o primeiro livro a ser inserido seja próximo a uma delas, eventualmente
         * a árvore irá pesar muito para umm dos lados, portanto, pretendo implementar a AVL no futuro.
         *
         * Considerações finais:
         * Foi um projeto rápido e muito proveitoso para mim, considerando que costumo manipular apenas números,
         * e não strings em meus projetos.
         * */

        Projeto_BST livros = new Projeto_BST();

        livros.insert("O Guia do Mochileiro das Galáxias - Douglas Adams");
        livros.insert("O Nome do Vento - Patrick Rothfuss");
        livros.insert("Frankenstein - Mary Shelley");
        livros.insert("Cosmos - Carl Sagan");
        livros.insert("O Senhor dos Anéis 1 - A Sociedade do Anel - J.R.R. Tolkien");
        livros.insert("1984 - George Orwell");
        livros.insert("Chronos: Viajantes do Tempo - Rysa Walker");
        livros.insert("O Senhor dos Anéis 2 - As Duas torres - J.R.R. Tolkien");
        livros.insert("A Mão Esquerda da Escuridão - Ursula K. Le guin");
        livros.insert("Frankenstein - Mary Shelley");
        livros.insert("O Guia do Mochileiro das Galáxias - Douglas Adams");
        livros.insert("O Senhor dos Anéis 3 - O Retorno do Rei - J.R.R. Tolkien");
        livros.insert("1984 - George Orwell");
        livros.insert("Androides Sonham com Ovelhas Elétricas? - Philip K. Dick");
        livros.insert("O Senhor dos Anéis 1 - A Sociedade do Anel - J.R.R. Tolkien");
        livros.insert("Lab Girl - Hope Jahren");
        livros.insert("A Longa Viagem a um Pequeno Planeta Hostil - Becky Chambers");
        livros.insert("Kindred: Laços de Sangue - Octavia Butler");
        livros.insert("Kindred: Laços de Sangue - Octavia Butler");
        livros.insert("As Cavernas de Aço - Isaac Asimov");
        livros.insert("Androides Sonham com Ovelhas Elétricas? - Philip K. Dick");
        livros.insert("O Conto da Aia - Margaret Atwood");
        livros.insert("O Guia do Mochileiro das Galáxias - Douglas Adams");
        livros.insert("Matadouro 5 - Kurt Vonnegut");
        livros.insert("O Guia do Mochileiro das Galáxias - Douglas Adams");
        livros.insert("A Longa Viagem a um Pequeno Planeta Hostil - Becky Chambers");
        livros.insert("Encontro com Rama - Arthur C. Clarke");
        livros.insert("Androides Sonham com Ovelhas Elétricas? - Philip K. Dick");

        System.out.println("INSERÇÕES");
        for (String a: livros.order()) {
            System.out.println(a);
        }

        System.out.println("\nCHECANDO O SEARCH");
        System.out.println(livros.search("Matadouro 5 - Kurt Vonnegut") == "Matadouro 5 - Kurt Vonnegut");
        System.out.println(livros.search("O Guia do Mochileiro das Galáxias - Douglas Adams") == "O Guia do Mochileiro das Galáxias - Douglas Adams");
        System.out.println(livros.search("1984 - George Orwell") == "1984 - George Orwell");
        System.out.println(livros.search("Frankenstein - Mary Shelley") == "Frankenstein - Mary Shelley");
        System.out.println(livros.search("Chronos: Viajantes do Tempo - Rysa Walker") == "Chronos: Viajantes do Tempo - Rysa Walker");
        System.out.println(livros.search("Encontro com Rama - Arthur C. Clarke") == "Encontro com Rama - Arthur C. Clarke");

        livros.remove("O Senhor dos Anéis 3 - O Retorno do Rei - J.R.R. Tolkien");
        livros.remove("Cosmos - Carl Sagan");
        livros.remove("O Nome do Vento - Patrick Rothfuss");
        livros.remove("Kindred: Laços de Sangue - Octavia Butler");
        livros.remove("Encontro com Rama - Arthur C. Clarke");
        livros.remove("Cosmos - Carl Sagan");
        livros.remove("O Guia do Mochileiro das Galáxias - Douglas Adams");
        livros.remove("O Guia do Mochileiro das Galáxias - Douglas Adams");
        livros.remove("O Guia do Mochileiro das Galáxias - Douglas Adams");
        livros.remove("O Guia do Mochileiro das Galáxias - Douglas Adams");

        System.out.println("\nAPÓS REMOÇÕES");
        for (String a: livros.order()) {
            System.out.println(a);
        }
    }
}
