package com.epam.gui;

import com.epam.model.RepairOrder;
import com.epam.service.DeleteById;
import com.epam.service.FindAll;
import com.epam.service.FindById;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

@Configuration
@SpringBootApplication
public class SwingApp extends JFrame implements CommandLineRunner {

    private static JLabel labelorderID = null;
    private static JLabel labelOrderStartDate = null;

    public SwingApp() throws IOException, InterruptedException {

        initUI();
    }

    private void initUI() throws IOException, InterruptedException {
        String url = "http://localhost:8090/order";
        String page = "0";
        int size = 50;
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(4, 1, 0, 0));
        JTable table = new JTable(FindAll.model(url, page, size));
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setRowSelectionAllowed(true);
        ListSelectionModel rowSelectionModel = table.getSelectionModel();
        table.setAutoCreateRowSorter(true);
        jPanel.add(table);
        add(jPanel);

        rowSelectionModel.addListSelectionListener(e -> {
            int selectedData = table.getSelectedRow();
            try {
                RepairOrder repairOrder = FindById.findRepairOrderById(url, selectedData);
                JFrame frame = new JFrame();
                frame.setName("Details for order # " + repairOrder.getRepairOrderId());
                frame.setVisible(true);
                frame.setSize(480, 320);
                labelorderID = new JLabel("Order: № " + repairOrder.getRepairOrderId());
                labelOrderStartDate = new JLabel("Order start Date: " + repairOrder.getRepairOrderStartDate());
                JPanel panel0 = new JPanel();
                JButton deleteButton = new JButton("Delete");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String deleted = DeleteById.deleteOrderById(url, repairOrder.getRepairOrderId());
                        System.out.println(deleted);
                    }
                });

                panel0.setLayout(new GridLayout(4, 1, 0, 0));
                panel0.add(labelorderID);
                panel0.add(labelOrderStartDate);
                panel0.add(deleteButton);
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.add(panel0, BorderLayout.CENTER);
                frame.add(panel);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SwingApp.class).headless(false).run(args);
        EventQueue.invokeLater(() -> {
            SwingApp ex = ctx.getBean(SwingApp.class);
            ex.setVisible(true);
        });
    }

    @Override
    public void run(String... args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SwingApp frame = new SwingApp();
                    setTitle("Repair Service");
                    setExtendedState(JFrame.MAXIMIZED_BOTH);
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
