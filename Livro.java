package com.mycompany.atv2;

public class Livro {
    private int codigo;
    private String autor;
    private String titulo;
    private boolean disponivel;

    public void setCodigo(int codigo) {
        if (codigo > 0) {
            this.codigo = codigo;
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setAutor(String autor) {
        if (autor != null) {
            this.autor = autor;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setTitulo(String titulo) {
        if (titulo != null) {
            this.titulo = titulo;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Livro(int codigo, String titulo, String autor) {
        setCodigo(codigo);
        setTitulo(titulo);
        setAutor(autor);
        this.disponivel = true;
    }

    public void emprestar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }

    public void atualizarDados(String titulo, String autor) {
        setTitulo(titulo);
        setAutor(autor);
    }

    @Override
    public String toString() {
        return (codigo + "-" + titulo + "-" + autor + "-" + disponivel);
    }
}