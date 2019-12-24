package com.epam.controller;

import com.epam.gui.OrderTableModel;
import com.epam.gui.StartApp;
import com.epam.model.RepairOrder;
import org.springframework.stereotype.Controller;
import com.epam.service.OrderService;

import java.io.IOException;
import java.util.List;

@Controller
public class OrderController extends AbstractFrameController {

    private StartApp startApp;
    private OrderTableModel tableModel;

    public OrderController(StartApp startApp,
                           OrderTableModel tableModel) {
        this.startApp = startApp;
        this.tableModel = tableModel;
    }

    @Override
    public void prepareAndOpenFrame(int page) throws IOException, InterruptedException {
        loadEntities(page);
        showTableFrame();
    }

    public void loadEntities(int page) throws IOException, InterruptedException {
        List<RepairOrder> entities;
        entities = OrderService.findAll(page);
        tableModel.clear();
        tableModel.addEntities(entities);
    }

    private void showTableFrame() {
        startApp.setVisible(true);
    }

}
