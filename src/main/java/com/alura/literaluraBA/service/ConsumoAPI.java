package com.alura.literaluraBA.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la respuesta: " + response.statusCode());
            }
            String json = response.body();
            if (json == null || json.isEmpty()) {
                throw new RuntimeException("La respuesta está vacía");
            }
            return json;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
