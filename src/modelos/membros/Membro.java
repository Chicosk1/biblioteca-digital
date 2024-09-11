package modelos.membros;

import java.util.ArrayList;
import java.util.List;

import modelos.*;

public class Membro {

    private String nomeMembro;
    private int idMembro;
    private List<Livro> historicoEmprestimoMembro;

    // Construtor
    public Membro(String nomeMembro, int idMembro) {
        this.nomeMembro = nomeMembro;
        this.idMembro = idMembro;
        this.historicoEmprestimoMembro = new ArrayList<>();
    }
    
    // Getters
    public List<Livro> getHistoricoEmprestimoMembro() {
        return historicoEmprestimoMembro;
    }

    public String getNomeMembro() {
        return nomeMembro;
    }

    public int getIdMembro() {
        return idMembro;
    }

    // Método para registrar um emprestimo de livro realizado por um Membro
    public void registrarEmprestimo(Livro livro) {
        if (livro.isLivroDisponivel()) {
            historicoEmprestimoMembro.add(livro);
            livro.emprestarLivro();
        }else{
            System.out.println("Livro indisponível para empréstimo.");
        }

    }

    // Método para registar a devolução de um livro realizado por um Membro
    public void registrarDevolucao(Livro livro) {
        livro.devolverLivro();
        historicoEmprestimoMembro.remove(livro);
    }
}
