package com.epam.service;

import com.epam.model.RepairOrder;
import com.epam.model.RepairOrderPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class OrderService {
    public static List<RepairOrder> findAll(int page) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String url = "http://localhost:8090/order";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + "?page=" + page + "&size=30")).build();
        HttpResponse<String> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        RepairOrderPage repairOrderPage = new ObjectMapper().readValue(response.body(), RepairOrderPage.class);
        return repairOrderPage.content;
    }

    public static void deleteOrderById(Integer id) throws URISyntaxException, IOException, InterruptedException {
        String url = "http://localhost:8090/order";
        HttpClient client = HttpClient.newHttpClient();
        String path = url + "/" + id;
        HttpRequest request;
        request = HttpRequest.newBuilder()
                .uri(new URI(path))
                .header("Accept", "application/json")
                .DELETE()
                .build();
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
