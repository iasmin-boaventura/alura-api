package br.com.alura.screenmatch.projeto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisicoes {
    public String formataCep(String cep) {
        return cep.replaceAll("[^0-9]", "");
    }

    public void validaCep(String cep) {
        if (cep.length() != 8){
            throw new ErroCepInvalidoException("O CEP deve conter 8 números.");
        }
    }

    public String fazRequisicao(String cep){
        validaCep(cep);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+ cep + "/json/"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }
}
