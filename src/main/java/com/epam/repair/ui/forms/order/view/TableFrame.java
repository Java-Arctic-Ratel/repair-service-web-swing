package com.epam.repair.ui.forms.order.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class TableFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 1500;
    private static final int DEFAULT_HEIGHT = 700;

    private TablePanel tablePanel;
    private TableBtnPanel tableBtnPanel;

    @Autowired
    public TableFrame(TableBtnPanel tableBtnPanel, TablePanel tablePanel) {
        this.tablePanel = tablePanel;
        this.tableBtnPanel = tableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle("Orders List");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    private void initComponents() {
        add(tablePanel, BorderLayout.CENTER);
        add(tableBtnPanel, BorderLayout.SOUTH);
    }

    public TableBtnPanel getTableBtnPanel() {
        return tableBtnPanel;
    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }
}
