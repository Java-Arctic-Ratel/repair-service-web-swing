package com.epam.repair.ui.forms.order.controller;

import com.epam.repair.exception.OrderNotFoundException;
import com.epam.repair.model.RepairOrder;
import com.epam.repair.service.OrderService;
import com.epam.repair.ui.forms.order.model.OrderTableModel;
import com.epam.repair.ui.forms.order.view.TableBtnPanel;
import com.epam.repair.ui.forms.order.view.TableFrame;
import com.epam.repair.ui.shared.controller.AbstractFrameController;
import com.epam.repair.util.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.ResourceAccessException;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * The type Order controller.
 */
@Controller
public class OrderController extends AbstractFrameController {

    private TableFrame tableFrame;
    private OrderTableModel tableModel;

    /**
     * The Order service.
     */
    @Autowired
    OrderService orderService;

    /**
     * Instantiates a new Order controller.
     *
     * @param tableFrame the table frame
     * @param tableModel the table model
     */
    public OrderController(TableFrame tableFrame,
                           OrderTableModel tableModel) {
        this.tableFrame = tableFrame;
        this.tableModel = tableModel;
    }

    @PostConstruct
    private void prepareListeners() {

        TableBtnPanel tableBtnPanel = tableFrame.getTableBtnPanel();
        registerAction(tableBtnPanel.getRemoveBtn(), (e) -> removeEntity());
    }

    @Override
    public void prepareAndOpenFrame(int page) throws IOException, InterruptedException {
        loadEntities(page);
        showTableFrame();
    }

    private void loadEntities(int page) {

        try {
            tableModel.clear();
            tableModel.addEntities(orderService.findAll(page));
        } catch (ResourceAccessException e) {
            throw new OrderNotFoundException();
        }
    }

    private void showTableFrame() {
        tableFrame.setVisible(true);
    }

    private void removeEntity() {
        try {
            JTable table = tableFrame.getTablePanel().getTable();
            int selectedRow = table.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(null,
                        "Nothing selected",
                        "Warning",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                RepairOrder entity = tableModel.getEntityByRow(selectedRow);
                orderService.deleteOrderById(entity.getRepairOrderId());
                tableModel.removeRow(selectedRow);
                loadEntities(0);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }
}