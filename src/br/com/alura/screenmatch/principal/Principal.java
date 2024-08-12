package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecoes.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.ConexaoApi;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOMDb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ConexaoApi api = new ConexaoApi();
        String busca;
        String endereco;
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        List<Titulo> titulos = new ArrayList<>();

        while (true) {
            System.out.print("Digite um filme para consultar: ");
            busca = sc.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            endereco = api.montaEndereco(busca);

            try {
                String json = api.fazRequisicao(endereco);

                TituloOMDb tituloOMDb = gson.fromJson(json, TituloOMDb.class);
                System.out.println(tituloOMDb);

                Titulo titulo = new Titulo(tituloOMDb);
                System.out.println("Título convertido|: " + titulo);

                titulos.add(titulo);

            } catch (IllegalArgumentException e){
                System.out.println("Algum argumento da busca é inválido: " + e);
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println("Erro de conversão de ano: " + e.getMessage());
            }
        }

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

    }
}
