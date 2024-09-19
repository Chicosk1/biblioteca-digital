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

        // Alimentando os Construtores de cada Classe
        Autor autor1 = new Autor("J.K. Rowling", "Britânico", new Date());
        Autor autor2 = new Autor("George Orwell", "Britânico", new Date());
        
        Livro livro1 = new Livro("Harry Potter", autor1, "123456");
        Livro livro2 = new Livro("1984", autor2, "654321");

        Membro estudante = new Estudante("Gabriel", 1, "Sistemas de Informação");
        Membro professor = new Professor("Josimar", 2, "Desenvolvimento de Aplicações");

        // Instanciando objetos
        List<Livro> livros = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(livros);
        livros.add(livro1);
        livros.add(livro2);

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
                // Emprestar Livro
                case 1:

                    System.out.println("Qual membro está emprestando o livro?");
                    System.out.println("1. " + estudante.getNomeMembro() + " (Estudante)");
                    System.out.println("2. " + professor.getNomeMembro() + " (Professor)");
                    int membroEscolha = scanner.nextInt();
                    scanner.nextLine();

                    // Operador Ternário = condição ? valor verdadeiro : valor falso
                    Membro membroEmprestimo = membroEscolha == 1 ? estudante : professor;
                    
                    System.out.println("Digite o ISBN do livro a ser emprestado:");
                    String isbnEmprestimo = scanner.nextLine();
                    
                    Livro livroEmprestimo = buscarLivroPorISBN(livros, isbnEmprestimo);

                    delay();

                    // Validação para verificar se o livro já foi emprestado ou não
                    if (livroEmprestimo != null) {
                        if(!livroEmprestimo.islivroEmprestado()){
                            
                            membroEmprestimo.registrarEmprestimo(livroEmprestimo);
                            livroEmprestimo.emprestarLivro();
                            
                            System.out.println(livroEmprestimo.getTituloLivro() + " foi emprestado com sucesso!");
                            
                        }else{
                            System.out.println("O livro ja foi emprestado");
                        }            
                    }else{
                        System.out.println("Livro não encontrado");
                    }

                    break;
                // Devolver Livro
                case 2:

                    System.out.println("Qual membro está devolvendo o livro?");
                    System.out.println("1. " + estudante.getNomeMembro() + " (Estudante)");
                    System.out.println("2. " + professor.getNomeMembro() + " (Professor)");
                    int membroDevolucaoEscolha = scanner.nextInt();
                    scanner.nextLine();
                    
                    Membro membroDevolucao = membroDevolucaoEscolha == 1 ? estudante : professor;
                    
                    System.out.println("Digite o ISBN do livro a ser devolvido:");
                    String isbnDevolucao = scanner.nextLine();
                    
                    Livro livroDevolucao = buscarLivroPorISBN(livros, isbnDevolucao);

                    delay();
                    
                    // Validação para verificar se o livro já foi devolvido ou não
                    if (livroDevolucao.islivroEmprestado()) {
                        
                        membroDevolucao.registrarDevolucao(livroDevolucao);
                        
                        System.out.println(livroDevolucao.getTituloLivro() + " foi devolvido com sucesso!");
                        
                    } else {
                        System.out.println("Livro não encontrado.");
                    }

                    break;
                // Listar Livros do Autor
                case 3:
                    
                    System.out.println("Escolha o autor:");
                    System.out.println("1. " + autor1.getNomeAutor());
                    System.out.println("2. " + autor2.getNomeAutor());
                    int nomeAutorListar = scanner.nextInt();
                    scanner.nextLine();

                    delay();

                    if (nomeAutorListar != 1 && nomeAutorListar != 2) {

                        System.out.println("Escolha inválida. Tente novamente.");

                        break;

                    }else{

                    Autor autorListarEscolhido  =  nomeAutorListar == 1 ? autor1 : autor2;
                    
                    biblioteca.listarLivrosDoAutor(autorListarEscolhido.getNomeAutor());

                    }

                    break;
                // Ver Histórico de Emprestimos
                case 4:

                    System.out.println("Qual membro deseja ver o histórico de empréstimos?");
                    System.out.println("1. " + estudante.getNomeMembro() + " (Estudante)");
                    System.out.println("2. " + professor.getNomeMembro() + " (Professor)");
                    int membroHistoricoEscolha = scanner.nextInt();
                    scanner.nextLine();

                    Membro membroHistorico = membroHistoricoEscolha == 1 ? estudante : professor;

                    List<Livro> historico = membroHistorico.getHistoricoEmprestimoMembro();
                    
                    delay();

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
                // Adicionar Livros a um Autor
                case 5:

                    System.out.println("Escolha o autor:");
                    System.out.println("1. " + autor1.getNomeAutor());
                    System.out.println("2. " + autor2.getNomeAutor());
                    int autorEscolha = scanner.nextInt();
                    scanner.nextLine();

                    Autor autorEscolhido = autorEscolha == 1 ? autor1 : autor2;

                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();

                    System.out.println("Digite o ISBN do livro:");
                    String isbn = scanner.nextLine();
                    
                    delay();

                    // Validação para verificar se já existe o livro escolhido
                    if (!biblioteca.livroExiste(isbn,titulo)) {

                        Livro novoLivro = new Livro(titulo, autorEscolhido, isbn);
                        
                        autorEscolhido.adicionarLivro(novoLivro); 
                        livros.add(novoLivro); 
                        
                        System.out.println("Livro adicionado com sucesso ao autor " + autorEscolhido.getNomeAutor());
                    
                    }else{

                        System.out.println("Não foi possível adicionar o livro.");

                    }

                    break;
                // Sair
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

    // Métodos
    public static Livro buscarLivroPorISBN(List<Livro> livros, String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbnLivro().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public static void delay(){
        for(int i = 1; i >= 1;i--){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }
    }
}
