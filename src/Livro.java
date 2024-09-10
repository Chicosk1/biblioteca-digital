public class Livro {
    // Váriaveis Iniciais
    private String  tituloLivro, isbnLivro;
    private Autor autorLivro;
    private boolean livroDisponivel;

    // Construtor
    public Livro(String tituloLivro, Autor autorLivro, String isbnLivro) {
        this.tituloLivro = tituloLivro;
        this.autorLivro = autorLivro;
        this.isbnLivro = isbnLivro;
        this.livroDisponivel = true;
    }

    // Getters
    public Autor getAutorLivro() {
        return autorLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public boolean isLivroDisponivel() {
        return livroDisponivel;
    }

    // Método para emprestar o livro se estiver disponível
    public void emprestarLivro() {
        if (livroDisponivel) {
            livroDisponivel = false;
            System.out.println("Livro emprestado!");
        }else{
            System.out.println("Livro indisponível.");
        }
    }

    // Método para devolver o livro
    public void devolverLivro() {
        livroDisponivel = true;
        System.out.println("Livro devolvido com sucesso!");
    }

    // Método para verificar a disponibilidade do livro
    public void verificarDisponibilidade() {
        if (livroDisponivel) {
            System.out.println("Livro disponível.");
        }else{
            System.out.println("Livro indisponível.");
        }
    }
}
