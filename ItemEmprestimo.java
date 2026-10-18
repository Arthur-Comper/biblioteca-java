/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atv2;

/**
 *
 * @author User
 */
public class ItemEmprestimo {
    private Livro livro;
    private boolean devolvido;
    
    public ItemEmprestimo(Livro livro){
    this.livro=livro;
    }
    
    public Livro getLivro() {
    return livro;
}
    public void registrarDevolucao(){
        devolvido=true;
        }
    public boolean isDevolvido(){
    return devolvido;
    }
        }
    

