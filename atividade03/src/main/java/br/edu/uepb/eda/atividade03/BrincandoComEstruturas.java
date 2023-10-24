package atividade03;

public class BrincandoComEstruturas {

	public static void main(String[] args) {
		
		System.out.println("Brincando com ListaEncadeada...");
		ListaEncadeada_IF minhaLista = new ListaEncadeada();
		System.out.println(minhaLista.isEmpty());
		System.out.println(minhaLista.size() == 0);
		minhaLista.insert(100);
		System.out.println(minhaLista.size() == 1);
		System.out.println(minhaLista.toArray()[0] == 100);
		minhaLista.insert(200);
		System.out.println(minhaLista.size() == 2);
		System.out.println(minhaLista.toArray()[0] == 200);
		System.out.println(minhaLista.toArray()[1] == 100);
		minhaLista.insert(300);
		System.out.println(minhaLista.size() == 3);
		System.out.println(minhaLista.toArray()[0] == 300);
		System.out.println(minhaLista.toArray()[1] == 200);
		System.out.println(minhaLista.toArray()[2] == 100);
		minhaLista.remove(100);
		System.out.println(minhaLista.size() == 2);
		System.out.println(minhaLista.toArray()[0] == 300);
		System.out.println(minhaLista.toArray()[1] == 200);
		minhaLista.remove(300);
		System.out.println(minhaLista.size() == 1);
		System.out.println(minhaLista.toArray()[0] == 200);
		try {
			System.out.println(minhaLista.search(200) == 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		System.out.println();
		
		System.out.println("Brincando com PilhaComLista...");
		Pilha_IF minhaPilha = new PilhaComLista();
		try {
			minhaPilha.push(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		try {
			minhaPilha.push(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		try {
			System.out.println(minhaPilha.top() == 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		try {
			System.out.println(minhaPilha.pop() == 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		try {
			System.out.println(minhaPilha.pop() == 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		System.out.println(minhaPilha.isEmpty());
		System.out.println();
		
		System.out.println("Brincando com FilaComPilhas...");
		Fila_IF minhaFila = new FilaComPilhas();
		try {
			minhaFila.enqueue(100);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
		try {
	    	minhaFila.enqueue(200);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }try {
	    	System.out.println(minhaFila.head() == 100);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }try {
	    	System.out.println(minhaFila.dequeue() == 100);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }try {
	    	System.out.println(minhaFila.dequeue() == 200);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
		System.out.println(minhaFila.isEmpty());
		System.out.println();
				
		//OBS.: Espera-se que nenhum print mostre 'false' na tela!

	}

}