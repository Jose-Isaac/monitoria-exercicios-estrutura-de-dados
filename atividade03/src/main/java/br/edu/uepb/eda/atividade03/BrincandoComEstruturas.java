package br.edu.uepb.eda.atividade03;

public class BrincandoComEstruturas {

    public static void main(String[] args) throws Exception {

        System.out.println("Brincando com main.ListaEncadeada...");
        ListaEncadeada_IF minhaLista = new ListaEncadeada();
        System.out.println("minhaLista.isEmpty() : " + minhaLista.isEmpty());
        System.out.println("minhaLista.size() == 0 : " + (minhaLista.size() == 0));

        System.out.println("Inserindo 100...");
        minhaLista.insert(100);

        System.out.println("minhaLista.size() == 1 : " + (minhaLista.size() == 1));
        System.out.println("minhaLista.toArray()[0] == 100 : " + (minhaLista.toArray()[0] == 100));

        System.out.println("Inserindo 200...");
        minhaLista.insert(200);
        System.out.println("minhaLista.size() == 2 : " + (minhaLista.size() == 2));
        System.out.println("minhaLista.toArray()[0] == 200 : " + (minhaLista.toArray()[0] == 200));
        System.out.println("minhaLista.toArray()[1] == 100 : " + (minhaLista.toArray()[1] == 100));

        System.out.println("Inserindo 300...");
        minhaLista.insert(300);
        System.out.println("minhaLista.size() == 3 : " + (minhaLista.size() == 3));
        System.out.println("minhaLista.toArray()[0] == 300 : " + (minhaLista.toArray()[0] == 300));
        System.out.println("minhaLista.toArray()[1] == 200 : " + (minhaLista.toArray()[1] == 200));
        System.out.println("minhaLista.toArray()[2] == 100 : " + (minhaLista.toArray()[2] == 100));

        System.out.println("Removendo 100...");
        minhaLista.remove(100);

        System.out.println("minhaLista.size() == 2 : " + (minhaLista.size() == 2));
        System.out.println("minhaLista.toArray()[0] == 300 : " + (minhaLista.toArray()[0] == 300));
        System.out.println("minhaLista.toArray()[1] == 200 : " + (minhaLista.toArray()[1] == 200));

        System.out.println("Removendo 300...");
        minhaLista.remove(300);
        System.out.println("minhaLista.size() == 1 : " + (minhaLista.size() == 1));
        System.out.println("minhaLista.toArray()[0] == 200 : " + (minhaLista.toArray()[0] == 200));
        System.out.println("minhaLista.search(200) == 200 : " + (minhaLista.search(200) == 200));
        System.out.println();

        System.out.println("Brincando com main.PilhaComLista...");
        Pilha_IF minhaPilha = new PilhaComLista();
        minhaPilha.push(100);
        minhaPilha.push(200);
        System.out.println("minhaPilha.top() == 200 = " + (minhaPilha.top() == 200));
        System.out.println("(minhaPilha.pop() == 200) = " + (minhaPilha.pop() == 200));
        System.out.println("(minhaPilha.pop() == 100) = " + (minhaPilha.pop() == 100));
        System.out.println("(minhaPilha.isEmpty()) = " + (minhaPilha.isEmpty()));
        System.out.println();


        System.out.println("Brincando com main.FilaComPilhas...");
        Fila_IF minhaFila = new FilaComPilhas();
        minhaFila.enqueue(100);
        minhaFila.enqueue(200);
        System.out.println("(minhaFila.head() == 100 = " + (minhaFila.head() == 100));
        System.out.println("minhaFila.dequeue() == 100 = " + (minhaFila.dequeue() == 100));
        System.out.println("(minhaFila.dequeue() == 200) = " + (minhaFila.dequeue() == 200));
        System.out.println("(minhaFila.isEmpty()) = " + (minhaFila.isEmpty()));

        // OBS.: Espera-se que nenhum print mostre 'false' na tela!

    }

}
