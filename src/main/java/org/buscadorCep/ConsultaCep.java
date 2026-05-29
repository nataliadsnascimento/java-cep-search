package org.buscadorCep;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {

    public Endereco buscarEndereco(String cep) {

        URI endereco = URI.create("https://viacep.com.br/ws/"+ cep+"/json");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        HttpResponse<String> response;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()
            );
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não é possível obter o endereço a partir deste CEP");
        }

        String json = response.body();

        if (json.contains("\"erro\": true")) {

            throw new RuntimeException("CEP não encontrado.");
        }

        return new Gson().fromJson(json, Endereco.class);
    }
}
