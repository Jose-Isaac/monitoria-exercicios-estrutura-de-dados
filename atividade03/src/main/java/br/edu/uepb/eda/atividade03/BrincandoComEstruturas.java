package br.edu.uepb.eda.atividade03;

public class BrincandoComEstruturas {

	public static void main(String[] args) throws Exception {
		// MOSTRANDO TUDO TRUE NA TELA, CÓDIGO ESTÁ FUNCIONANDO

		//Começando com a lista encadeada
		System.out.println("# Brincando com ListaEncadeada #");
		ListaEncadeada_IF minhaLista = new ListaEncadeada();

		//Testanto condições iniciais:
		System.out.println(minhaLista.size() == 0);
		System.out.println(minhaLista.isEmpty());

		//Mostrando Funcionamentos dos métodos insert, search e size
		minhaLista.insert(200);
		System.out.println(minhaLista.size() == 1);
		minhaLista.insert(300);
		System.out.println(minhaLista.search(200) == 200);
		minhaLista.insert(900);
		System.out.println(minhaLista.search(300) == 300);
		minhaLista.insert(400);
		System.out.println(minhaLista.search(400) == 400);
		minhaLista.insert(500);

		//minhaLista.search(500); //Mostrará a exceção pois não vai achar

		//Removendo e mostrando modificação de tamanho (Remove e size)
		/*
		 * OBS: O método remove utiliza o método search antes de iniciar para
		 * saber se o elemento pedido para ser removido está na lista encadeada,
		 * se não estiver ele mostrará a exceção
		*/
		System.out.println(minhaLista.size() == 5);
		minhaLista.remove(minhaLista.search(300));
		System.out.println(minhaLista.size() == 4);
		minhaLista.remove(minhaLista.search(900));
		System.out.println(minhaLista.size() == 3);
		//minhaLista.remove(minhaLista.search(100)); //Mostrará a exceção pois não vai achar


		//Mostrando a funcionalidade toArray
		minhaLista.insert(600);
		System.out.println(minhaLista.toArray()[0] == 600);
		minhaLista.insert(700);
		System.out.println(minhaLista.toArray()[0] == 700);
		System.out.println(minhaLista.toArray()[1] == 600);

		System.out.println();

		//Agora demonstrando Pilha com lista
		System.out.println("# Brincando com PilhaComLista #");
		Pilha_IF minhaPilha = new PilhaComLista();

		//Método top e pop
		minhaPilha.push(100);
		minhaPilha.push(200);
		System.out.println(minhaPilha.top() == 200);
		System.out.println(minhaPilha.pop() == 200);
		System.out.println(minhaPilha.pop() == 100);

		//Método isEmpty
		System.out.println(minhaPilha.isEmpty());
		//minhaPilha.top(); //Forçando o Exception do .top
		//minhaPilha.pop(); //Forçando o Exception do .pop

		//Enchendo a pilha
		int i;
		for(i = 1; i <= 10; i++) {
			minhaPilha.push(i);
		}

		//Método isFull
		System.out.println(minhaPilha.isFull());
		// minhaPilha.push(11); //Forçando o Exception do .push

		System.out.println();

		//Por último, demonstrando Fila com pilhas
		System.out.println("# Brincando com FilaComPilhas #");
		Fila_IF minhaFila = new FilaComPilhas();

		//Testando métodos enqueue, head e dequeue
		minhaFila.enqueue(100);
		minhaFila.enqueue(200);
		System.out.println(minhaFila.head() == 100);
		System.out.println(minhaFila.dequeue() == 100);
		System.out.println(minhaFila.dequeue() == 200);

		//Testando o isEmpty
		System.out.println(minhaFila.isEmpty());
		//minhaFila.dequeue(); //Forçando o Exception do .dequeue
		//minhaFila.head(); //Forçando o Exception do .head

		//Enchendo a pilha
		for(i = 1; i <= 10; i++) {
			minhaFila.enqueue(i);
		}

		//Método isFull
		System.out.println(minhaPilha.isFull());
		//minhaFila.enqueue(11); //Forçando o Exception do .push


		System.out.println();


		//OBS.: Espera-se que nenhum print mostre 'false' na tela!

	}
}
