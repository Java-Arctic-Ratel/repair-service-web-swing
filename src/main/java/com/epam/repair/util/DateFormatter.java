package com.epam.repair.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DateFormatter {

    public String formatDate(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
}
