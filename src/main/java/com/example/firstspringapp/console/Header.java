package com.example.firstspringapp.console;

import org.springframework.stereotype.Component;

@Component
public class Header {
    private final String message;

    public Header(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
