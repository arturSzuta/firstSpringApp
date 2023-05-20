package com.example.firstspringapp.console;

import com.example.firstspringapp.service.AddressBookService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class AppConfiguration {
    private final AddressBookService service;

    public AppConfiguration(AddressBookService service) {
        this.service = service;
    }
    /* this is also component but create by invoking constructor
     and creates dependency for Menu class.
     1) Returned type is important
     2) Method name should be same like injected field
     */


    @Bean
    String message() {
        return "Address book" + "\n" + "Version: 1.0.1";
    }
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
