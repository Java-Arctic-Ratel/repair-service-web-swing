package com.epam.utilities;

import javax.swing.*;

public class Notifications {

    public static void showTableRowNotSelectedAlert() {
        JOptionPane.showMessageDialog(null,
                "Nothing selected",
                "Warning",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(null,
                "Can not delete order",
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showLoadLookAndFeelErrorMessage(Exception e) {
        JOptionPane.showMessageDialog(
                null,
                "Can not load styles: " + e,
                "Warning",
                JOptionPane.ERROR_MESSAGE);
    }
}
