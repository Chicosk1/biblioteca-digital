package servicos;
import java.util.List;

import modelos.Livro;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca(List<Livro> livros) {
        this.livros = livros;
    }

    public void listarLivrosDoAutor(String nomeAutor) {
        for (Livro livro : livros) {
            if (livro.getAutorLivro().getNomeAutor().equalsIgnoreCase(nomeAutor)) {
                System.out.println(livro.getTituloLivro());
            }
        }
    }
}
