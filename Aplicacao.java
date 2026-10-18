package com.mycompany.atv2;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao = -1;

        do {
            System.out.println("1 - Cadastrar leitor");
            System.out.println("2 - Consultar leitor");
            System.out.println("3 - Listar leitores");
            System.out.println("4 - Atualizar leitor");
            System.out.println("5 - Remover leitor");
            System.out.println("6 - Cadastrar livro");
            System.out.println("7 - Consultar livro");
            System.out.println("8 - Listar livros");
            System.out.println("9 - Atualizar livro");
            System.out.println("10 - Remover livro");
            System.out.println("11 - Registrar emprestimo");
            System.out.println("12 - Listar emprestimos");
            System.out.println("13 - Registrar devolucao");
            System.out.println("0 - Sair");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    case 1:
                        System.out.println("Digite o codigo do leitor:");
                        int codigo = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digite o nome do leitor:");
                        String nome = scanner.nextLine();

                        System.out.println("Digite o email do leitor:");
                        String email = scanner.nextLine();

                        Leitor leitor = new Leitor(codigo, nome, email);

                        if (biblioteca.cadastrarLeitor(leitor)) {
                            System.out.println("Leitor cadastrado com sucesso!");
                        } else {
                            System.out.println("Nao foi possivel cadastrar o leitor.");
                        }
                        break;

                    case 2:
                        System.out.println("Digite o codigo do leitor:");
                        int codigoConsulta = Integer.parseInt(scanner.nextLine());

                        Leitor consultaLeitor = biblioteca.consultarLeitor(codigoConsulta);

                        if (consultaLeitor != null) {
                            System.out.println(consultaLeitor);
                        } else {
                            System.out.println("Leitor nao encontrado.");
                        }
                        break;

                    case 3:
                        biblioteca.listarLeitores();
                        break;

                    case 4:
                        System.out.println("Digite o codigo do leitor que deseja atualizar:");
                        int codigoAtualizar = Integer.parseInt(scanner.nextLine());

                        Leitor leitorAtualizar = biblioteca.consultarLeitor(codigoAtualizar);

                        if (leitorAtualizar != null) {
                            System.out.println("Digite o novo nome:");
                            String novoNome = scanner.nextLine();

                            System.out.println("Digite o novo email:");
                            String novoEmail = scanner.nextLine();

                            leitorAtualizar.atualizarDados(novoNome, novoEmail);

                            System.out.println("Leitor atualizado com sucesso!");
                        } else {
                            System.out.println("Leitor nao encontrado.");
                        }
                        break;

                    case 5:
                        System.out.println("Digite o codigo do leitor que deseja remover:");
                        int codigoRemover = Integer.parseInt(scanner.nextLine());

                        Leitor leitorRemover = biblioteca.consultarLeitor(codigoRemover);

                        if (biblioteca.removerLeitor(leitorRemover)) {
                            System.out.println("Leitor removido com sucesso!");
                        } else {
                            System.out.println("Nao foi possivel remover o leitor.");
                        }
                        break;

                    case 6:
                        System.out.println("Digite o codigo do livro:");
                        int codigoLivro = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digite o titulo do livro:");
                        String titulo = scanner.nextLine();

                        System.out.println("Digite o autor do livro:");
                        String autor = scanner.nextLine();

                        Livro livro = new Livro(codigoLivro, titulo, autor);

                        if (biblioteca.cadastrarLivro(livro)) {
                            System.out.println("Livro cadastrado com sucesso!");
                        } else {
                            System.out.println("Nao foi possivel cadastrar o livro.");
                        }
                        break;

                    case 7:
                        System.out.println("Digite o codigo do livro:");
                        int codigoConsultaLivro = Integer.parseInt(scanner.nextLine());

                        Livro consultaLivro = biblioteca.consultarLivro(codigoConsultaLivro);

                        if (consultaLivro != null) {
                            System.out.println(consultaLivro);
                        } else {
                            System.out.println("Livro nao encontrado.");
                        }
                        break;

                    case 8:
                        biblioteca.listarLivros();
                        break;

                    case 9:
                        System.out.println("Digite o codigo do livro que deseja atualizar:");
                        int codigoAtualizarLivro = Integer.parseInt(scanner.nextLine());

                        Livro livroAtualizar = biblioteca.consultarLivro(codigoAtualizarLivro);

                        if (livroAtualizar != null) {
                            System.out.println("Digite o novo titulo:");
                            String novoTitulo = scanner.nextLine();

                            System.out.println("Digite o novo autor:");
                            String novoAutor = scanner.nextLine();

                            livroAtualizar.atualizarDados(novoTitulo, novoAutor);

                            System.out.println("Livro atualizado com sucesso!");
                        } else {
                            System.out.println("Livro nao encontrado.");
                        }
                        break;

                    case 10:
                        System.out.println("Digite o codigo do livro que deseja remover:");
                        int codigoRemoverLivro = Integer.parseInt(scanner.nextLine());

                        Livro livroRemover = biblioteca.consultarLivro(codigoRemoverLivro);

                        if (biblioteca.removerLivro(livroRemover)) {
                            System.out.println("Livro removido com sucesso!");
                        } else {
                            System.out.println("Nao foi possivel remover o livro.");
                        }
                        break;

                    case 11:
                        System.out.println("Digite o codigo do emprestimo:");
                        int codigoEmprestimo = Integer.parseInt(scanner.nextLine());

                        System.out.println("Digite o codigo do leitor:");
                        int codigoLeitorEmprestimo = Integer.parseInt(scanner.nextLine());

                        Leitor leitorEmprestimo = biblioteca.consultarLeitor(codigoLeitorEmprestimo);

                        if (leitorEmprestimo == null) {
                            System.out.println("Leitor nao encontrado.");
                            break;
                        }

                        ArrayList<Livro> livrosEmprestimo = new ArrayList<>();

                        String continuar;

                        do {
                            System.out.println("Digite o codigo do livro:");
                            int codigoLivroEmprestimo = Integer.parseInt(scanner.nextLine());

                            Livro livroEmprestimo = biblioteca.consultarLivro(codigoLivroEmprestimo);

                            if (livroEmprestimo == null) {
                                System.out.println("Livro nao encontrado.");
                            } else {
                                livrosEmprestimo.add(livroEmprestimo);
                            }

                            System.out.println("Deseja adicionar outro livro? (s/n)");
                            continuar = scanner.nextLine();

                        } while (continuar.equalsIgnoreCase("s"));

                        if (biblioteca.registrarEmprestimo(
                                codigoEmprestimo, leitorEmprestimo, livrosEmprestimo)) {
                            System.out.println("Emprestimo registrado com sucesso!");
                        } else {
                            System.out.println("Nao foi possivel registrar o emprestimo.");
                        }
                        break;

                    case 12:
                        biblioteca.listarEmprestimos();
                        break;

                    case 13:
                        System.out.println("Digite o codigo do emprestimo para devolucao:");
                        int codigoDevolucao = Integer.parseInt(scanner.nextLine());

                        if (biblioteca.registrarDevolucao(codigoDevolucao)) {
                            System.out.println("Devolucao registrada com sucesso!");
                        } else {
                            System.out.println("Nao foi possivel registrar a devolucao.");
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um valor numerico valido.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
