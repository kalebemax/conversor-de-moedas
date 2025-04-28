package Conversor;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaDados {

    public TaxaDeCambio buscaMoeda(String primeiraMoedaEscolhida, String segundaMoedaEscolhida) {

        String apiKey = "a53f104a74c74c419f3c5766";

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + primeiraMoedaEscolhida + "/" + segundaMoedaEscolhida;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();


        {
            try {
                HttpResponse<String> response = 
                HttpClient.newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() != 200) {
                    System.out.println("Erro na requisição! Status: " + response.statusCode());
                    System.out.println("Resposta: " + response.body());
                    throw new RuntimeException("Falha ao buscar dados da API.");
                }

                return new Gson().fromJson(response.body(), TaxaDeCambio.class);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Ocorreu um erro inesperado!");
            }
        }
    }
}