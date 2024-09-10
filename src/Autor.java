import java.util.Date;

public class Autor {
    // Váriaveis Iniciais
    private String nomeAutor, nacionalidadeAutor;
    private Date dataNascimentoAutor;

    // Construtor
    public Autor(String nomeAutor, String nacionalidadeAutor, Date dataNascimentoAutor) {
        this.nomeAutor = nomeAutor;
        this.nacionalidadeAutor = nacionalidadeAutor;
        this.dataNascimentoAutor = dataNascimentoAutor;
    }

    // Getter
    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getNacionalidadeAutor() {
        return nacionalidadeAutor;
    }

    public Date getDataNascimentoAutor() {
        return dataNascimentoAutor;
    }
}
