public class Livro {
    //Declaração Inicial das Váriaveis
    private String  tituloLivro, isbnLivro;
    private Autor autorLivro;
    private boolean livroDisponivel;

    //Construtor
    public Livro(String tituloLivro, String isbnLivro, Autor autorLivro, boolean livroDisponivel) {
        this.tituloLivro = tituloLivro;
        this.isbnLivro = isbnLivro;
        this.autorLivro = autorLivro;
        this.livroDisponivel = livroDisponivel;
    }

    public Livro(String string, Autor autor1, String string2) {
        //TODO Auto-generated constructor stub
    }

    //Getters
    public Autor getAutorLivro() {
        return autorLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    //Métodos
    public boolean emprestarLivro() {
        if (livroDisponivel == true) {
            return true;
        }else{
            return false;
        }
    }

    public void devolverLivro() {
        livroDisponivel = true;
    }

    public boolean verificarDisponibilidade() {
        return livroDisponivel;
    }
}
