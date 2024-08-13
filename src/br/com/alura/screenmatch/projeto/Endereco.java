package br.com.alura.screenmatch.projeto;

public record Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {

    @Override
    public String toString() {
        return "CEP: " + cep() +
                "\nLogradouro: " + logradouro() +
                "\nBairro: " + bairro() +
                "\nCidade: " + localidade() +
                "\nUF: " + uf();
    }
}
