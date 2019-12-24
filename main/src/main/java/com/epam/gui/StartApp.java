package com.epam.gui;

import java.beans.*;

import com.epam.controller.OrderController;
import com.epam.model.RepairOrder;
import com.epam.service.OrderService;
import com.epam.utilities.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@Component
public class StartApp extends JFrame {
    int xx;
    int xy;
    private OrderTableModel tableModel;
    private OrderService orderService;
    private OrderController orderController;

    @Autowired
    public StartApp(OrderTableModel tableModel) {
        this.tableModel = tableModel;
        initComponents();
        table1.setModel(tableModel);
    }

    private void thisMouseDragged(MouseEvent e) {
        int x = e.getXOnScreen();
        int y = e.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }

    private void button1MouseClicked(MouseEvent evt) {
        try {
            JTable table1 = getTable();
            int selectedRow = table1.getSelectedRow();
            if (selectedRow < 0) {
                Notifications.showTableRowNotSelectedAlert();
            } else {
                RepairOrder entity = tableModel.getEntityByRow(selectedRow);
                OrderService.deleteOrderById(entity.getRepairOrderId());
                tableModel.removeRow(selectedRow);
                tableModel.clear();
                tableModel.addEntities(OrderService.findAll(0));
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }

    public JTable getTable() {
        return table1;
    }

    private void scrollPane1PropertyChange(PropertyChangeEvent e) {
        // TODO add your code here
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        panel1 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        panel2 = new JPanel();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textPane1 = new JTextPane();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                thisMouseDragged(e);
            }
        });
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("Repair Service Application");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
                    .swing.border.EmptyBorder(0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax.swing
                    .border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.
                    Font("Dia\u006cog", java.awt.Font.BOLD, 12), java.awt.Color.red
            ), panel1.getBorder()));
            panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("bord\u0065r".equals(e.getPropertyName(
                    ))) throw new RuntimeException();
                }
            });
            panel1.setLayout(new FlowLayout());

            //---- button1 ----
            button1.setText("Delete");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1);

            //---- button2 ----
            button2.setText("Add");
            panel1.add(button2);

            //---- button3 ----
            button3.setText("Edit");
            panel1.add(button3);
        }
        contentPane.add(panel1, BorderLayout.SOUTH);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());

            //======== panel3 ========
            {
                panel3.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {
                    scrollPane1.addPropertyChangeListener(e -> scrollPane1PropertyChange(e));

                    //---- table1 ----
                    table1.setPreferredScrollableViewportSize(new Dimension(1500, 700));
                    scrollPane1.setViewportView(table1);
                }
                panel3.add(scrollPane1, BorderLayout.CENTER);
            }
            panel2.add(panel3, BorderLayout.CENTER);
        }
        contentPane.add(panel2, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JPanel panel1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel2;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
