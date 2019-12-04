package com.epam.repair.ui.forms.order.view;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class TableBtnPanel extends JPanel {

    private JButton removeBtn;

    public TableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        removeBtn = new JButton("Delete");
        add(removeBtn);
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }

}
