package com.epam.service;

import com.epam.logics.OrderTableModel;
import com.epam.model.RepairOrder;
import com.epam.model.RepairOrderPage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FindAll {
    public static OrderTableModel model(String url, String page, int size) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + "?page=" + page + "&size=" + size)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        RepairOrderPage repairOrderPage = mapper.readValue(response.body(), RepairOrderPage.class);
        List<RepairOrder> repairOrders = repairOrderPage.content;
        return new OrderTableModel(repairOrders);
    }
}
