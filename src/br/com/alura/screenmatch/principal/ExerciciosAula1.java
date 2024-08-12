package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ExerciciosAula1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ex1();
    }

    public static void ex1() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um livro para consultar: ");
        String busca = sc.nextLine();


        final String CHAVE = "AIzaSyCIfA8wL9C7vzqz0-0rPj76x3yhu0zD6u0";
        String endereco = "https://www.googleapis.com/books/v1/volumes?q=" +
                busca + "&key=" + CHAVE;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

    public static void ex2() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome da criptomoeda para a cotação (por exemplo, bitcoin): ");
        String busca = sc.nextLine();

        String endereco = "https://api.coingecko.com/api/v3/simple/price?ids=" + busca + "&vs_currencies=usd";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

    public static void ex3() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome da receita: ");
        String busca = sc.nextLine();

        String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + busca;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
