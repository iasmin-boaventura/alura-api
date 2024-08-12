package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Livro {
    private String titulo;
    private String autor;
    private Editora editora;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo() +
                "\nAutor: " + getAutor() +
                "\nEditora: " + getEditora().getNome();
    }
}
