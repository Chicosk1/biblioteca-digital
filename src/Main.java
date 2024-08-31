import java.time.LocalDate;
public class Main {
    public static void main(String[] args) throws Exception {
        Autor autor1 = new Autor("George Orwell", "Britânico", "1903/06/25");
        Livro livro1 = new Livro("1984", autor1, "123-456-789");

        Membro membro1 = new Estudante("João Silva", "S123", "Ciência da Computação");
        Membro membro2 = new Professor("Maria Oliveira", "P456", "Literatura");

        membro1.registrarEmprestimo(livro1);

        System.out.println("Disponibilidade de '1984': " + livro1.verificarDisponibilidade());

        membro1.registrarDevolucao(livro1);

        System.out.println("Disponibilidade de '1984' após devolução: " + livro1.verificarDisponibilidade());
    }
}
