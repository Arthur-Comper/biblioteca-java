package com.mycompany.atv2;

public class Leitor {
    private int codigo;
    private String nome;
    private String email;

    public void setCodigo(int codigo) {
        if (codigo > 0) {
            this.codigo = codigo;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public String getEmail() {
        return email;
    }

    public Leitor(int codigo, String nome, String email) {
        setCodigo(codigo);
        setNome(nome);
        setEmail(email);
    }

    public void atualizarDados(String nome, String email) {
        setEmail(email);
        setNome(nome);
    }

    @Override
    public String toString() {
        return (email + " - " + nome + " - " + codigo);
    }
}