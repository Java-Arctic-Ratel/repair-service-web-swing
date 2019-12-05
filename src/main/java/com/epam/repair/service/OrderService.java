package com.epam.repair.service;

import com.epam.repair.config.Config;
import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.RepairOrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * The type Order service.
 */
@Service
@ContextConfiguration(classes = Config.class)
public class OrderService {
    private String URL = "http://localhost:8091/order";
    private String SIZE = "30";

    /**
     * The Rest template.
     */
    @Autowired
    RestTemplate restTemplate;

    /**
     * Find all list.
     *
     * @param page the page
     * @return the list
     */
    public List<RepairOrder> findAll(Integer page) {
        RepairOrderPage repairOrderPage = restTemplate
                .getForEntity(URI.create(URL + "?page=" + page + "&size=" + SIZE), RepairOrderPage.class).getBody();
        assert repairOrderPage != null;
        return repairOrderPage.content;
    }

    /**
     * Delete order by id.
     *
     * @param id the id
     */
    public void deleteOrderById(Integer id) {
        restTemplate.delete(URI.create(URL + "/" + id));
    }
}