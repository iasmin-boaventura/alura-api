package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.projeto.excecoes.SenhaInvalidaException;

public class Senha {
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha.length() < 8) {
            throw new SenhaInvalidaException("A senha deve conter, pelo menos, 8 caracteres.");
        }
        if (!senha.matches(".*\\d.*")) {
            throw new SenhaInvalidaException("A senha deve conter, pelo menos, um número.");
        }

        this.senha = senha;
    }
}
