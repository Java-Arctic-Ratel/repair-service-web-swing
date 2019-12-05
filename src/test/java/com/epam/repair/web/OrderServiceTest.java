package com.epam.repair.web;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.RepairOrderPage;
import com.epam.repair.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static com.epam.repair.utils.TestUtils.loadTestFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    private String URL = "http://localhost:8091/order";
    private Integer PAGE = 0;
    private String SIZE = "30";
    private Integer ORDER_ID_1 = 1;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void findAll() throws Exception {

        RepairOrderPage repairOrderPage = new ObjectMapper()
                .readValue(loadTestFile("json/orderDTO.json"), RepairOrderPage.class);

        Mockito
                .when(restTemplate.getForEntity(URI.create(URL + "?page=" + PAGE + "&size=" + SIZE), RepairOrderPage.class))
                .thenReturn(new ResponseEntity<>(repairOrderPage, HttpStatus.OK));

        List<RepairOrder> content = orderService.findAll(PAGE);

        assertNotNull(content);
        assertEquals(content.size(), repairOrderPage.size);
    }

    @Test
    public void deleteById() {
        orderService.deleteOrderById(ORDER_ID_1);
        Mockito.verify(restTemplate, Mockito.times(1)).delete(URI.create(URL + "/" + ORDER_ID_1));
    }
}