package modelos.membros;

public class Estudante extends Membro {

    private String cursoEstudante;

    
    // Construtor
    public Estudante(String nomeMembro, int idMembro, String cursoEstudante) {
        super(nomeMembro, idMembro);
        this.cursoEstudante = cursoEstudante;
    }

    // Getters
    public String getCursoEstudante() {
        return cursoEstudante;
    }
}
