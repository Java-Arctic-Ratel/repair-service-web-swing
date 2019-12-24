package com.epam;

import com.epam.controller.OrderController;
import com.epam.gui.LookAndFeelUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        LookAndFeelUtils.setWindowsLookAndFeel();
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).headless(false).run(args);
        OrderController orderController = context.getBean(OrderController.class);
        orderController.prepareAndOpenFrame(0);
    }
}
