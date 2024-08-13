package br.com.alura.screenmatch.projeto;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    private String validaCep(String cep) {
        cep = cep.replaceAll("[^0-9]", ""); //deixa apenas números na string

        if (cep.length() != 8){
            throw new ErroCepInvalidoException("O CEP deve conter 8 números.");
        }

        return cep;
    }

    public Endereco fazRequisicao(String cep){
        cep = validaCep(cep);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+ cep + "/json/"))
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Endereco.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

        }
    }
}
