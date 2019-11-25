package com.epam.ui;

import com.epam.model.RepairOrder;
import com.epam.model.RepairOrderPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

//        URL url = new URL("http://localhost:8090/order");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setDoOutput(true);
//        conn.setRequestMethod("GET");
//        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
//        conn.setRequestProperty("Content-Type", "application/json");
//
//        int responseCode = conn.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//        String json = (String) conn.getContent();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8090/order")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

//        System.out.println(request);
//        System.out.println(response.body());

        ObjectMapper mapper = new ObjectMapper();
//              File json = new File("src/main/resources/testData/order.json");
        RepairOrderPage repairOrderPage = mapper.readValue(response.body(), RepairOrderPage.class);
        List<RepairOrder> repairOrders = repairOrderPage.content;
        OrderTableModel model = new OrderTableModel(repairOrders);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JOptionPane.showMessageDialog(null, new JScrollPane(table));


    }
}
