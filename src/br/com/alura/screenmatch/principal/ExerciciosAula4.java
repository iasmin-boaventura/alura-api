package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.Veiculo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ExerciciosAula4 {
    public static void main(String[] args) {
        ex1();
    }

    public static void ex1() {
        String data = "Conteúdo a ser gravado no arquivo.";
        try {
            FileWriter escrita = new FileWriter("arquivo.txt");
            escrita.write(data);
            escrita.close();
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());;
        }
    }

    public static void ex2() {
        Titulo meuTitulo = new Titulo("Dr House", 2004);
        meuTitulo.avalia(10);
        meuTitulo.avalia(9);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        String jsonTitulo = gson.toJson(meuTitulo);

        System.out.println(jsonTitulo);

    }

    public static void ex3() {
        Titulo meuTitulo = new Titulo("Dr House", 2004);
        meuTitulo.avalia(10);
        meuTitulo.avalia(9);
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        String jsonTitulo = gson.toJson(meuTitulo);

        System.out.println(jsonTitulo);

    }

    public static void ex4() {
        Veiculo carro = new Veiculo();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        String jsonVeiculo;

        carro.setMarca("Volkswagen");
        carro.setMotor(2.0);
        carro.setAno(2024);
        carro.setNome("Golf GTI");

        jsonVeiculo = gson.toJson(carro);

        System.out.println(jsonVeiculo);

    }
}
