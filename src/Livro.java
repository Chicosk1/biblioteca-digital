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

    //Getters
    public Autor getAutorLivro() {
        return autorLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    //Método para emprestar o livro se estiver disponível
    public boolean emprestarLivro() {
        if (livroDisponivel == true) {
            return true;
        }else{
            return false;
        }
    }

    //Método para devolver o livro
    public void devolverLivro() {
        livroDisponivel = true;
    }

    //Método para verificar a disponibilidade do livro
    public boolean verificarDisponibilidade() {
        return livroDisponivel;
    }
}
