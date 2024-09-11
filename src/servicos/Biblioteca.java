package servicos;

import java.util.List;

import modelos.*;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca(List<Livro> livros) {
        this.livros = livros;
    }

    public void listarLivrosDoAutor(String nomeAutor) {

        // Loop percorrendo os livros que um autor possui
        for (Livro livro : livros) {
            if (livro.getAutorLivro().getNomeAutor().equalsIgnoreCase(nomeAutor)) {
                System.out.println(livro.getTituloLivro());
            }
        }

    }

    public boolean livroExiste(String isbn, String titulo) {

        // Loop verificando todos os livros do Array e validando se eles existem ou não
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
