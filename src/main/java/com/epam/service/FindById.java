package com.epam.service;

import com.epam.model.RepairOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FindById {

    public static RepairOrder findRepairOrderById(String url, Integer id) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + "/" + id)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), RepairOrder.class);
    }
}
