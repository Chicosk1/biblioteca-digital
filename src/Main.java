public class Main {
    public static void main(String[] args) throws Exception {
        // Formatar a data de nascimento usando o método estático
        String dataNascimentoFormatada = Autor.formatarDataNascimento(25, 6, 1903);
                
        // Criar um objeto Autor utilizando a data formatada
        Autor autor = new Autor("George Orwell", "Britânico", dataNascimentoFormatada);
                
        // Exibir os detalhes do autor
        System.out.println("Nome: " + autor.getNomeAutor());
        System.out.println("Data de Nascimento: " + autor.dataNascimentoAutor);
    }
}
