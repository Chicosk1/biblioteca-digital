package modelos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Autor {

    private String nomeAutor, nacionalidadeAutor;
    private Date dataNascimentoAutor;
    private List<Livro> livros;

    // Construtor
    public Autor(String nomeAutor, String nacionalidadeAutor, Date dataNascimentoAutor) {
        this.nomeAutor = nomeAutor;
        this.nacionalidadeAutor = nacionalidadeAutor;
        this.dataNascimentoAutor = dataNascimentoAutor;
        this.livros = new ArrayList<>();
    }

    // Getter
    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getNacionalidadeAutor() {
        return nacionalidadeAutor;
    }

    public Date getDataNascimentoAutor() {
        return dataNascimentoAutor;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    // Método para adicionar livro a um autor específico
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
}
