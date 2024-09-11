package biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import modelos.*;
import modelos.membros.*;
import servicos.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando autores
        Autor autor1 = new Autor("J.K. Rowling", "Britânico", new Date());
        Autor autor2 = new Autor("George Orwell", "Britânico", new Date());
        
        // Criando livros
        Livro livro1 = new Livro("Harry Potter", autor1, "123456");
        Livro livro2 = new Livro("1984", autor2, "654321");

        // Criando membros
        Membro estudante = new Estudante("Gabriel", 1, "Sistemas de Informação");
        Membro professor = new Professor("Josimar", 2, "Desenvolvimento de Aplicações");
        
        // Criando lista de livros
        List<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);

        // Criando a biblioteca
        Biblioteca biblioteca = new Biblioteca(livros);

        boolean sair = false;
        while (!sair) {
            System.out.println("\n----- Biblioteca Digital -----");
            System.out.println("1. Emprestar Livro");
            System.out.println("2. Devolver Livro");
            System.out.println("3. Listar Livros de um Autor");
            System.out.println("4. Ver Histórico de Empréstimos");
            System.out.println("5. Adicionar livros a um Autor");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            // Switch case das opções disponíveis
            switch (opcao) {
                case 1:

                    System.out.println("Qual membro está emprestando o livro?");
                    System.out.println("1. " + estudante.getNomeMembro() + " (Estudante)");
                    System.out.println("2. " + professor.getNomeMembro() + " (Professor)");
                    int membroEscolha = scanner.nextInt();
                    scanner.nextLine();

                    // Operador Ternário: condição ? valor verdadeiro : valor falso
                    Membro membroEmprestimo = membroEscolha == 1 ? estudante : professor;
                    
                    // Procurando o livro pelo código ISBN
                    System.out.println("Digite o ISBN do livro a ser emprestado:");
                    String isbnEmprestimo = scanner.nextLine();
                    Livro livroEmprestimo = buscarLivroPorISBN(livros, isbnEmprestimo);

                    // Validação para verificar se o livro já foi emprestado ou não
                    if (livroEmprestimo != null) {
                        membroEmprestimo.registrarEmprestimo(livroEmprestimo);
                        System.out.println(livroEmprestimo + " foi emprestado com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }

                    break;

                case 2:

                    System.out.println("Qual membro está devolvendo o livro?");
                    System.out.println("1. " + estudante.getNomeMembro() + " (Estudante)");
                    System.out.println("2. " + professor.getNomeMembro() + " (Professor)");
                    int membroDevolucaoEscolha = scanner.nextInt();
                    scanner.nextLine();
                    
                    // Operador Ternário: condição ? valor verdadeiro : valor falso
                    Membro membroDevolucao = membroDevolucaoEscolha == 1 ? estudante : professor;
                    
                    // Procurando o livro pelo código ISBN
                    System.out.println("Digite o ISBN do livro a ser devolvido:");
                    String isbnDevolucao = scanner.nextLine();
                    Livro livroDevolucao = buscarLivroPorISBN(livros, isbnDevolucao);

                    // Validação para verificar se o livro já foi devolvido ou não
                    if (livroDevolucao != null) {
                        membroDevolucao.registrarDevolucao(livroDevolucao);
                        System.out.println(livroDevolucao + " foi devolvido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }

                    break;

                case 3:

                    System.out.println("Digite o nome do autor:");
                    String nomeAutor = scanner.nextLine();

                    // Procurando os livros que um autor possui
                    biblioteca.listarLivrosDoAutor(nomeAutor);

                    break;

                case 4:

                    System.out.println("Qual membro deseja ver o histórico de empréstimos?");
                    System.out.println("1. " + estudante.getNomeMembro() + " (Estudante)");
                    System.out.println("2. " + professor.getNomeMembro() + " (Professor)");
                    int membroHistoricoEscolha = scanner.nextInt();
                    scanner.nextLine();

                    // Operador Ternário: condição ? valor verdadeiro : valor falso
                    Membro membroHistorico = membroHistoricoEscolha == 1 ? estudante : professor;

                    List<Livro> historico = membroHistorico.getHistoricoEmprestimoMembro();

                    // Validação para verificar se houve emprestimos ou não
                    if (historico.isEmpty()) {

                        System.out.println("Nenhum empréstimo registrado.");

                    } else {

                        System.out.println("Histórico de empréstimos:");

                        //Loop exibindo os livros de um histórico inteiro
                        for (Livro livro : historico) {
                            System.out.println(livro.getTituloLivro());
                        }
                    }

                    break;

                case 5:

                    System.out.println("Escolha o autor:");
                    System.out.println("1. " + autor1.getNomeAutor());
                    System.out.println("2. " + autor2.getNomeAutor());
                    int autorEscolha = scanner.nextInt();
                    scanner.nextLine();

                    // Operador Ternário: condição ? valor verdadeiro : valor falso
                    Autor autorEscolhido = autorEscolha == 1 ? autor1 : autor2;

                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();

                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    
                    // Validação para verificar se já existe o livro escolhido
                    if (!biblioteca.livroExiste(isbn,titulo)) {

                        // Adicionando livro ao autor
                        Livro novoLivro = new Livro(titulo, autorEscolhido, isbn);
                        autorEscolhido.adicionarLivro(novoLivro); 
                        livros.add(novoLivro); 
                        System.out.println("Livro adicionado com sucesso ao autor " + autorEscolhido.getNomeAutor());
                    
                    }else{

                        System.out.println("Não foi possível adicionar o livro.");

                    }

                    break;

                case 6:

                    sair = true;
                    System.out.println("Saindo...");
                    break;

                default:

                    System.out.println("Opção inválida.");
                    
            }
        }

        scanner.close();
    }

    public static Livro buscarLivroPorISBN(List<Livro> livros, String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbnLivro().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }
}
