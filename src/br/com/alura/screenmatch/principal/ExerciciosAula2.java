package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.Strictness;

public class ExerciciosAula2 {
    public static void main(String[] args) {
        ex3();
    }

    public static void ex1() {
        String jsonPessoa = "{\"nome\":\"Iasmin\",\"idade\":21,\"cidade\":\"São José dos Campos\"}";

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);

        System.out.println("Objeto Pessoa: " + pessoa);
    }

    public static void ex2() {
        String jsonPessoa = "{\"nome\":\"Iasmin\",\"idade\":21}";

        Gson gson = new GsonBuilder().setStrictness(Strictness.LENIENT).create();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);

        System.out.println("Objeto Pessoa: " + pessoa);
    }

    public static void ex3() {
        String jsonLivro = "{\"titulo\":\"Mais leve que ar\"," +
                "\"autor\":\"Felipe Sali\", " +
                "\"Editora\": " +
                "{ \"nome\":\"Lote 52\"}}";

        try {
            Gson gson = new GsonBuilder().setStrictness(Strictness.LENIENT).create();
            Livro livro = gson.fromJson(jsonLivro, Livro.class);
            System.out.println("Livro: " + livro);
        } catch (NullPointerException ex) {
            System.out.println("Aconteceu um erro: " + ex.getMessage());
        } catch (Exception ex) {

        }

    }
}