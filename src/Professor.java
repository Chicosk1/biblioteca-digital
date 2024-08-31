public class Professor extends Membro{
    //Váriaveis Iniciais
    private String departamentoProfessor;
    
    //Construtor
    public Professor(String nomeMembro, String idMembro, String departamentoProfessor) {
        super(nomeMembro, idMembro);
        this.departamentoProfessor = departamentoProfessor;
    }
}
