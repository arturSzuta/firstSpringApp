package com.example.firstspringapp;

import com.example.firstspringapp.console.Header;
import com.example.firstspringapp.console.Menu;
import com.example.firstspringapp.controller.ScannerController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringAppApplication implements CommandLineRunner {


    private final ScannerController controller;

    // dependency injection with constructor - recommended!
    public FirstSpringAppApplication(ScannerController controller) {

        this.controller = controller;
    }
    public static void main(String[] args) {

        SpringApplication.run(FirstSpringAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       controller.mainLoopRun();
    }
}
