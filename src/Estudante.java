public class Estudante extends Membro {
    //Váriaveis Iniciais
    private String cursoEstudante;

    //Construtor
    public Estudante(String nomeMembro, String idMembro, String cursoEstudante) {
        super(nomeMembro, idMembro);
        this.cursoEstudante = cursoEstudante;
    }
}
