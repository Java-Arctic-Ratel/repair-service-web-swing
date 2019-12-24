package com.epam.controller;

import java.io.IOException;

public abstract class AbstractFrameController {
    public abstract void prepareAndOpenFrame(int page) throws IOException, InterruptedException;
}
