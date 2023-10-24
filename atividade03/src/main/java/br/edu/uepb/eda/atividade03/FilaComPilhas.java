package br.edu.uepb.eda.atividade03;

public class FilaComPilhas implements Fila_IF {

    PilhaComLista p1,p2 = new PilhaComLista();
 

    public FilaComPilhas() {
        p1 = new PilhaComLista(); 
        p2 = new PilhaComLista(); 
    }
    @Override
    public void enqueue(Integer element) throws Exception {
        while(!p1.isEmpty()) {
            p2.push(p1.pop());

        }
        p2.push(element);
        while(!p2.isEmpty()) {
            p1.push(p2.pop());
        }

    }
    @Override
    public int dequeue() throws Exception{
        return p1.pop();
    }
    public int head() throws Exception {
    		if (p1.isEmpty()) {
    			throw new Exception("Fila vazia.");
    		} else {
    			int Head = p1.top();
    			return Head;
    		}

    }    

    @Override
    public boolean isEmpty() {
        return p1.isEmpty();
    }

    @Override
    public boolean isFull() {
        return p1.isFull();
    }

}

