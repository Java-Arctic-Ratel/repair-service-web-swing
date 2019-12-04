package com.epam.repair.ui.forms.order.controller;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.service.OrderService;
import com.epam.repair.ui.forms.order.model.OrderTableModel;
import com.epam.repair.ui.forms.order.view.TableBtnPanel;
import com.epam.repair.ui.forms.order.view.TableFrame;
import com.epam.repair.ui.shared.controller.AbstractFrameController;
import com.epam.repair.util.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@Controller
public class OrderController extends AbstractFrameController {

    private TableFrame tableFrame;
    private OrderTableModel tableModel;

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

    private void loadEntities(int page) throws IOException, InterruptedException {
        List<RepairOrder> entities;
        entities = OrderService.findAll(page);
        tableModel.clear();
        tableModel.addEntities(entities);
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
                OrderService.deleteOrderById(entity.getRepairOrderId());
                tableModel.removeRow(selectedRow);
                loadEntities(0);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }
}
