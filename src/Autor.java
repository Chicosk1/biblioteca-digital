import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Autor {
    // Variáveis Iniciais
    private String nomeAutor, nacionalidadeAutor, dataNascimentoAutor;
    private List<Livro> livros;

    // Construtor
    public Autor(String nomeAutor, String nacionalidadeAutor, String dataNascimentoAutor) {
        this.nomeAutor = nomeAutor;
        this.nacionalidadeAutor = nacionalidadeAutor;
        this.dataNascimentoAutor = dataNascimentoAutor;
        this.livros = new ArrayList<>();
    }

    // Getter
    public String getNomeAutor() {
        return nomeAutor;
    }

    // Método para formatar a data de nascimento
    public static String formatarDataNascimento(int dia, int mes, int ano) {
        LocalDate data = LocalDate.of(ano, mes, dia);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatador);
    }

    // Método para adicionar um livro à lista de livros do autor
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Método para listar os livros do autor
    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o autor " + nomeAutor);
        }else{
            System.out.println("Livros do autor " + nomeAutor + ":");
            for (Livro livro : livros) {
                System.out.println("- " + livro.getTituloLivro());
            }
        }
    }
}
