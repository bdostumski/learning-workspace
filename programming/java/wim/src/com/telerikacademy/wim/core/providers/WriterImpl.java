package com.telerikacademy.wim.core.providers;

import com.telerikacademy.wim.core.contracts.Writer;

public class WriterImpl implements Writer {

    public void write(String message) {
        System.out.print(message);
    }

    public void writeLine(String message) {
        System.out.println(message);
    }

}
