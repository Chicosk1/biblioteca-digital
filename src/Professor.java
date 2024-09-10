public class Professor extends Membro{
    // Váriaveis Iniciais
    private String departamentoProfessor;
    
    // Construtor
    public Professor(String nomeMembro, int idMembro, String departamentoProfessor) {
        super(nomeMembro, idMembro);
        this.departamentoProfessor = departamentoProfessor;
    }

    // Getters
    public String getDepartamentoProfessor() {
        return departamentoProfessor;
    }
}
