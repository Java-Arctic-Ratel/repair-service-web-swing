package com.epam.repair.util;

import javax.swing.*;

public class LookAndFeelUtils {

    public static void setWindowsLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Can not load styles" + e,
                    "Warning",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
