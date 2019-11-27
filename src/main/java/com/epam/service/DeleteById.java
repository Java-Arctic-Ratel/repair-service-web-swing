package com.epam.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class DeleteById {
    public static String deleteOrderById(String url, Integer id) {
        HttpClient client = HttpClient.newHttpClient();
        String path = url + "/" + id;
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(path))
                    .header("Accept", "application/json")
                    .DELETE()
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return "DELETED";
    }
}
