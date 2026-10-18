package com.mycompany.atv2;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Leitor> leitores = new ArrayList<Leitor>();
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    
    
    public boolean cadastrarLeitor(Leitor leitor) {
        if (leitor == null) {
            return false;
        }

        for (Leitor cadastrado : leitores) {
            if (cadastrado.getCodigo() == leitor.getCodigo()) {
                return false;
            }
        }

        leitores.add(leitor);
        return true;
    }

    public Leitor consultarLeitor(int codigo) {
        for (Leitor cadastrado : leitores) {
            if (cadastrado.getCodigo() == codigo) {
                return cadastrado;
            }
        }

        return null;
    }
    public void listarLeitores(){
        for(int i=0; i<leitores.size(); i++){
            Leitor leitor = leitores.get(i);
            System.out.println(leitor);
        }
    }
    public boolean removerLeitor(Leitor leitor) {
    if (leitor == null) {
        return false;
    }

    if (consultarLeitor(leitor.getCodigo()) == null) {
        return false;
    }   
    for (int i=0; i<emprestimos.size();i++){
        Emprestimo emprestimo = emprestimos.get(i);
        if(emprestimo.getLeitor()== leitor && emprestimo.isAberto()){
             return false;
        }
    }
    leitores.remove(leitor);
        return true;
}
    public boolean cadastrarLivro(Livro livro){
    if(livro==null){
        return false;
    }
    for (Livro cadastrado: livros){
        if(cadastrado.getCodigo()==(livro.getCodigo()))
            return false;
    }
    livros.add(livro);
        return true;
    }
    public Livro consultarLivro(int codigo){
        for(Livro cadastrado:livros){
            if(cadastrado.getCodigo()==codigo){
                return cadastrado;
            }
        }
        return null;
    }
    public void listarLivros(){
    for (int i=0;i<livros.size();i++){
    Livro livro = livros.get(i);
        System.out.println(livro);
    }
    }
     public boolean removerLivro(Livro livro){
     if(livro==null){
         return false;
     }
     if(consultarLivro(livro.getCodigo())==null){
         return false;
     }
     for (int i=0;i<emprestimos.size();i++){
         Emprestimo emprestimo = emprestimos.get(i);
         if(emprestimo.contemLivro(livro) && emprestimo.isAberto()){
             return false;
     } 
     }
     livros.remove(livro);
        return true;
    }
    public boolean registrarEmprestimo(int codigo, Leitor leitor, ArrayList<Livro> livros) {
    if (codigo <= 0 || leitor == null || livros == null || livros.isEmpty()) {
        return false;
    }

    if (consultarLeitor(leitor.getCodigo()) == null) {
        return false;
    }

    for (Emprestimo cadastrado : emprestimos) {
        if (cadastrado.getCodigo() == codigo) {
            return false;
        }
    }

    for (int i = 0; i < livros.size(); i++) {
        Livro livro = livros.get(i);

        if (livro == null || consultarLivro(livro.getCodigo()) != livro || !livro.isDisponivel()) {
            return false;
        }

        for (int j = 0; j < i; j++) {
            if (livros.get(j).getCodigo() == livro.getCodigo()) {
                return false;
            }
        }
    }

    Emprestimo emprestimo = new Emprestimo(codigo, leitor);

    for (Livro livro : livros) {
        emprestimo.adicionarLivro(livro);
        livro.emprestar();
    }

    emprestimos.add(emprestimo);
    return true;
}
    public void listarEmprestimos(){
    for (int i=0; i<emprestimos.size();i++){
        Emprestimo emprestimo = emprestimos.get(i);
        System.out.println(emprestimo);
    }
    }
    public boolean registrarDevolucao(int codigo) {
    for (int i = 0; i < emprestimos.size(); i++) {
        Emprestimo emprestimo = emprestimos.get(i);

        if (emprestimo.getCodigo() == codigo) {
            if (!emprestimo.isAberto()) {
                return false;
            }

            emprestimo.finalizar();
            return true;
        }
    }

    return false;
}
}