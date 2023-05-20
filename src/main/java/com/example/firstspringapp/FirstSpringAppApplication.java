package com.example.firstspringapp;

import com.example.firstspringapp.console.Header;
import com.example.firstspringapp.console.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringAppApplication implements CommandLineRunner {


    private final Menu menu; // class dependency
    private final Header header;

    // dependency injection with constructor - recommended!
    public FirstSpringAppApplication(Menu menu, Header header) {
        this.menu = menu;
        this.header = header;
    }
    public static void main(String[] args) {

        SpringApplication.run(FirstSpringAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        header.print();
        if(menu != null) {
            menu.print();
        } else {
            System.out.println("Menu not found!");
        }
    }
}
