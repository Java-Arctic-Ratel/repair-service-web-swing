package com.epam.repair.service;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.RepairOrderPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.util.List;

@Service
public class OrderService {
    public static List<RepairOrder> findAll(int page) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "http://localhost:8090/order";
        String size = "30";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + "?page=" + page + "&size=" + size)).build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            System.out.println("Can not get JSON from: " + url + "?page=" + page + "&size=" + size);
            System.out.println(e.toString());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        ObjectMapper mapper = new ObjectMapper();
        RepairOrderPage repairOrderPage = null;
        try {
            repairOrderPage = mapper.readValue(response.body(), RepairOrderPage.class);
        } catch (JsonProcessingException e) {
            System.out.println("Can not get parse response body");
        }
        assert repairOrderPage != null;
        return repairOrderPage.content;
    }

    public static void deleteOrderById(Integer id) {
        String url = "http://localhost:8090/order";
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
    }
}
