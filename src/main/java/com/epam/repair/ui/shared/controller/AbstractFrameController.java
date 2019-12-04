package com.epam.repair.ui.shared.controller;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public abstract class AbstractFrameController {

    public abstract void prepareAndOpenFrame(int page) throws IOException, InterruptedException;

    protected void registerAction(JButton button, ActionListener listener) {
        button.addActionListener(listener);
    }

}
