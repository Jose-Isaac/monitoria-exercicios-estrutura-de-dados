package br.edu.uepb.eda.atividade04;

public class BST implements BST_IF {
	
	protected Integer valor;
	protected BST filhoEsq;
	protected BST filhoDir;
	protected BST pai; 
	
	// Fiz uma abordagem em que o tamanho só é alterado na raiz da árvore
	protected int tamanho;
	
	public BST() {
		this.valor = null;
		this.filhoEsq = null;
		this.filhoDir = null;
		this.pai = null;
		this.tamanho = 0;
	}
	
	public BST(int val, BST pai) {
		this.valor = val;
		this.filhoEsq = null;
		this.filhoDir = null;
		this.pai = pai;
	}
	
	// Métodos auxiliares para implementação
	private boolean isEmpty() {
		if(this.valor == null && this.pai == null) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isRoot() {
		if(this.valor != null && this.pai == null) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean isLeaf() {
		if(this.filhoEsq == null && this.filhoDir == null && this.valor != null) {
			return true;
		}else {
			return false;
		}
	}
	
	private void aumentarTamArvore() {
		if(this.isRoot()) {
			this.tamanho++;
		}else {
			this.pai.aumentarTamArvore();
		}
	}
	
	private int altura(BST node) {
		
		if(node == null) {
			return 0;
		}else {
			int alturaEsq = altura(node.filhoEsq);
			int alturaDir = altura(node.filhoDir);
			
			if(alturaEsq > alturaDir) {
				return (alturaEsq + 1);
			}else {
				return (alturaDir + 1);
			}
		}
		
	}

	@Override
	public void insert(Integer element) {
		
		if(this.isEmpty()) {
			this.valor = element;
			aumentarTamArvore();
		}else if(this.isRoot() && this.filhoEsq == null && element < this.valor) {
			this.filhoEsq = new BST(element, this);
			aumentarTamArvore();
		}else if(this.isRoot() && this.filhoDir == null && element > this.valor) {
			this.filhoDir = new BST(element, this);
			aumentarTamArvore();
		}else {
			if(element < this.valor) {
				
				if(this.filhoEsq == null) {
					this.filhoEsq = new BST(element, this);
					aumentarTamArvore();
				}else {
					this.filhoEsq.insert(element);
				}
				
			}else {
				
				if(this.filhoDir == null) {
					this.filhoDir = new BST(element, this);
					aumentarTamArvore();
				}else {
					this.filhoDir.insert(element);
				}
				
			}
		}
		
	}

	@Override
	public Integer search(Integer element) throws Exception {
		
		if(this.valor.equals(element)) {
			return this.valor;
		}else if(element < this.valor) {
			
			if(this.filhoEsq == null) {
				throw new Exception("ELEMENTO NÃO ENCONTRADO");
			}else {
				return this.filhoEsq.search(element);
			}
			
		}else {
			
			if(this.filhoDir == null) {
				throw new Exception("ELEMENTO NÃO ENCONTRADO");
			}else {
				return this.filhoDir.search(element);
			}
			
		}
		
	}
	
	private int preenchimentoArrayPreOrder(int[] Array, int i) {
		
		Array[i] = this.valor;
		i++;
		
		if(this.filhoEsq != null) {
			i = filhoEsq.preenchimentoArrayPreOrder(Array, i);
		}
		
		if(this.filhoDir != null) {
			i = filhoDir.preenchimentoArrayPreOrder(Array, i);
		}
		
		return i;
		
	}

	@Override
	public int[] preOrder() {
		
		int[] valores = new int[this.tamanho];
		preenchimentoArrayPreOrder(valores, 0);
		return valores;
		
	}
	
	private int preenchimentoArrayOrder(int[] Array, int i) {
		
		if(this.filhoEsq != null) {
			i = filhoEsq.preenchimentoArrayOrder(Array, i);
		}
		
		Array[i] = this.valor;
		i++;
		
		if(this.filhoDir != null) {
			i = filhoDir.preenchimentoArrayOrder(Array, i);
		}
		
		return i;
		
	}

	@Override
	public int[] order() {
		
		int[] valores = new int[this.tamanho];
		preenchimentoArrayOrder(valores, 0);
		return valores;
		
	}
	
	private int preenchimentoArrayPostOrder(int[] Array, int i) {
		
		if(this.filhoEsq != null) {
			i = filhoEsq.preenchimentoArrayPostOrder(Array, i);
		}
		
		if(this.filhoDir != null) {
			i = filhoDir.preenchimentoArrayPostOrder(Array, i);
		}
		
		Array[i] = this.valor;
		i++;
		
		return i;
		
	}

	@Override
	public int[] postOrder() {
		
		int[] valores = new int[this.tamanho];
		preenchimentoArrayPostOrder(valores, 0);
		return valores;
		
	}
	
	private boolean verificaCompleto(BST node, int nivel, int altura) {
	    // Se a árvore estiver vazia, ela é considerada completa
	    if (node.isEmpty()) {
	        return true;
	    }

	    // Se um nó não tiver um filho, ele deve ser uma folha
	    if (node.isLeaf()) {
	        return (nivel + 1 == altura);
	    }

	    // Se um nó tiver apenas um filho, ele não pode ser completo
	    if (node.filhoEsq == null || node.filhoDir == null) {
	        return false;
	    }

	    // Verifique recursivamente os filhos esquerdo e direito
	    return verificaCompleto(node.filhoEsq, nivel + 1, altura) && verificaCompleto(node.filhoDir, nivel + 1, altura);
	}

	@Override
	public boolean isComplete() {
		
	    int altura = altura(this);
	    return verificaCompleto(this, 0, altura);
	    
	}

}
