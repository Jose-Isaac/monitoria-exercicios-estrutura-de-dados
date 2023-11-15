package atividade04;

public class TabelaHash implements TabelaHash_IF {

	protected Integer size;
	protected ListaEncadeada[] hashTable;

	public TabelaHash(int size) {
		this.size = size;
		this.hashTable = new ListaEncadeada[this.size];
		
		for (int i = 0; i < size; i++) {
            this.hashTable[i] = new ListaEncadeada();
        }
	}

	@Override
	public void insert(Integer element) {
		hashTable[hashFunction(element)].insert(element);
	}

	@Override
	public void remove(Integer element) throws Exception {
		if (search(element)==element) {
			hashTable[hashFunction(element)].remove(element);
		} else {
			throw new Exception("Não foi possível remover o elemento já que ele não consta na tabela.");
		}
	}

	@Override
	public int search(Integer element) throws Exception {
		if (hashTable[hashFunction(element)].isEmpty()) {
			throw new Exception("Não há elementos na posição indicada da tabela!");
		} else {
			if (hashTable[hashFunction(element)].search(element) == element) {
				return element;
			} else {
				throw new Exception("Elemento não encontrado na tabela!");
			}
		}
	}

	@Override
	public String print() {
		StringBuilder result = new StringBuilder();

        for (int i = 0; i < size; i++) {
            result.append(i).append(": ");
            
            if (hashTable[i].isEmpty()) {
                result.append("\n");
                continue;
            }
            
            ListaEncadeada current = hashTable[i];

            while (current.data != null) {
            	result.append(current.data);
            	if (current.next.data != null) {
                    result.append(", ");
                }
                current = current.next;
            }
            result.append("\n");
        }
        return result.toString();
	}

	public int hashFunction(Integer element) {
		return element % size;
	}

}
