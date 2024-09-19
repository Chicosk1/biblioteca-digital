package modelos;

public class Livro {

    private String  tituloLivro, isbnLivro;
    private Autor autorLivro;
    private boolean livroEmprestado = false;
    
    // Construtor
    public Livro(String tituloLivro, Autor autorLivro, String isbnLivro) {
        this.tituloLivro = tituloLivro;
        this.autorLivro = autorLivro;
        this.isbnLivro = isbnLivro;
        this.livroEmprestado = false;
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
    
    
    public boolean islivroEmprestado() {
        return livroEmprestado;
    }

    // Setters
    public void setEmprestado(boolean livroEmprestado) {
        this.livroEmprestado = livroEmprestado;
    }
    
    // Métodos
    public void emprestarLivro() {
        livroEmprestado = false;
        if (!livroEmprestado) {
            livroEmprestado = true;
            System.out.println("Livro emprestado com sucesso!");
        }else{
            System.out.println("Livro indisponível.");
        }
    }

    public void devolverLivro() {
        if (livroEmprestado){
            livroEmprestado = false;
            System.out.println("Livro Devolvido com Sucesso.");
        }else{
            System.out.println("Livro não estava emprestado");
        }
    }

    public void verificarDisponibilidade() {
        if (livroEmprestado == true) {
            System.out.println("Livro emprestado");
        }else{
            System.out.println("Livro disponivel.");
        }
    }
}
