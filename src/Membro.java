import java.util.ArrayList;
import java.util.List;
public class Membro {
    //Váriaveis Iniciais
    private String nomeMembro, idMembro;
    private List<Livro> historicoEmprestimoMembro;

    //Construtor
    public Membro(String nomeMembro, String idMembro) {
        this.nomeMembro = nomeMembro;
        this.idMembro = idMembro;
        this.historicoEmprestimoMembro = new ArrayList<>();
    }
    
    //Getters
    public List<Livro> getHistoricoEmprestimoMembro() {
        return historicoEmprestimoMembro;
    }

    //Métodos
    public void registrarEmprestimo(Livro livro) {
        if (livro.emprestarLivro()) {
            historicoEmprestimoMembro.add(livro);
        }else{
            System.out.println("Livro indisponível para empréstimo.");
        }

    }

    public void registrarDevolucao(Livro livro) {
        livro.devolverLivro();
        historicoEmprestimoMembro.remove(livro);
    }
}
