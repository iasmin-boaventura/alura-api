package br.com.alura.screenmatch.modelos;

public record Pessoa(String nome, int idade, String cidade) {

    @Override
    public String toString() {
        return nome() + ", " + idade() + ", " + cidade();
    }
}
