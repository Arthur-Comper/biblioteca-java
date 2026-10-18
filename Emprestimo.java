/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atv2;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Emprestimo {
    private int codigo;
    private LocalDate dataEmprestimo;
    private boolean aberto;
    private Leitor leitor;
    private ArrayList<ItemEmprestimo> itens = new ArrayList<>();
       
    public int getCodigo() {
    return codigo;
}
    
    public Leitor getLeitor() {
        return leitor;
}

    public boolean isAberto() {
        return aberto;
}


    
   public Emprestimo(int codigo, Leitor leitor) {
    this.codigo = codigo;
    this.leitor = leitor;
    this.dataEmprestimo = LocalDate.now();
    this.aberto = true;
}
   public boolean contemLivro(Livro livro) {
    for (int i = 0; i < itens.size(); i++) {
        ItemEmprestimo item = itens.get(i);

        if (item.getLivro() == livro) {
            return true;
        }
    }

    return false;
}
   public boolean adicionarLivro(Livro livro) {
    if (contemLivro(livro)) {
        return false;
    }

    ItemEmprestimo item = new ItemEmprestimo(livro);
    itens.add(item);

    return true;
}
   public void finalizar(){
   aberto=false;
   for(int i=0; i<itens.size();i++){
       ItemEmprestimo item = itens.get(i);
       
        item.registrarDevolucao();
        item.getLivro().devolver();
   }
   
  
   }
   @Override
public String toString() {
    return (codigo + " - " + dataEmprestimo + " - " + leitor + " -Emprestimo em aberto?-> " + aberto);
            
}
}
