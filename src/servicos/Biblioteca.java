package servicos;

import java.util.List;

import modelos.*;

public class Biblioteca {
    
    private List<Livro> livros;

    // Setters
    public Biblioteca(List<Livro> livros) {
        this.livros = livros;
    }

    // Métodos
    public void listarLivrosDoAutor(String autorListarEscolhido) {
        for (Livro livro : livros) {
            if (livro.getAutorLivro().getNomeAutor().equalsIgnoreCase(autorListarEscolhido)) {
                System.out.println(livro.getTituloLivro());
            }
        }

    }

    public boolean livroExiste(String isbn, String titulo) {
        for (Livro livro : livros) {
            if (livro.getIsbnLivro().equalsIgnoreCase(isbn)) {
                System.out.println("Erro: Já existe um livro com este ISBN.");
                return true;
            }
            if (livro.getTituloLivro().equalsIgnoreCase(titulo)) {
                System.out.println("Erro: Já existe um livro com este título.");
                return true;
            }
        }
        return false;
    }
}
