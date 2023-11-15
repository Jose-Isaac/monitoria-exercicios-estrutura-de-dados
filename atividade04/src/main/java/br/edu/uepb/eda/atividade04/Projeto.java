package br.edu.uepb.eda.atividade04;

import java.util.HashMap;
import java.util.Map;

public class Projeto {
	private class Livro {
		String isbn;
		String titulo;
		String autor;
		int anoPublicacao;

		public Livro(String isbn, String titulo, String autor, int anoPublicacao) {
			this.isbn = isbn;
			this.titulo = titulo;
			this.autor = autor;
			this.anoPublicacao = anoPublicacao;
		}
	}

	private Map<String, Livro> tabelaLivros;

	public Projeto() {
		this.tabelaLivros = new HashMap<>();
	}

	// Inserir um novo livro na Tabela de Hash
	public void inserirLivro(String isbn, String titulo, String autor, int anoPublicacao) {
		Livro novoLivro = new Livro(isbn, titulo, autor, anoPublicacao);
		tabelaLivros.put(isbn, novoLivro);
	}

	// Buscar um livro por ISBN
	public Livro buscarLivro(String isbn) {
		return tabelaLivros.get(isbn);
	}

	// Listar todos os livros de um autor
	public void listarLivrosPorAutor(String autor) {
		System.out.println("Livros do autor " + autor + ":");
		for (Livro livro : tabelaLivros.values()) {
			if (livro.autor.equals(autor)) {
				System.out.println("ISBN: " + livro.isbn + ", Título: " + livro.titulo + ", Ano de Publicação: "
						+ livro.anoPublicacao);
			}
		}
	}

	// Remover um livro da Tabela de Hash
	public void removerLivro(String isbn) {
		tabelaLivros.remove(isbn);
	}

	// Verificar a existência de um livro por ISBN
	public boolean verificarExistenciaLivro(String isbn) {
		return tabelaLivros.containsKey(isbn);
	}

	public static void main(String[] args) {
		Projeto biblioteca = new Projeto();

		biblioteca.inserirLivro("978-3-16-148410-0", "Dom Casmurro", "Machado de Assis", 1899);
		biblioteca.inserirLivro("978-0-14-243723-0", "1984", "George Orwell", 1949);
		biblioteca.inserirLivro("978-0-06-112008-4", "To Kill a Mockingbird", "Harper Lee", 1960);

		Livro livroEncontrado = biblioteca.buscarLivro("978-0-14-243723-0");
		if (livroEncontrado != null) {
			System.out.println("Livro encontrado: " + livroEncontrado.titulo);
		} else {
			System.out.println("Livro não encontrado.");
		}

		biblioteca.listarLivrosPorAutor("Machado de Assis");

		biblioteca.removerLivro("978-3-16-148410-0");

		boolean existeLivro = biblioteca.verificarExistenciaLivro("978-3-16-148410-0");
		System.out.println("O livro ainda existe? " + existeLivro);
	}
}