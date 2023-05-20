package com.example.firstspringapp.console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfiguration {
    /* this is also component but create by invoking constructor
     and creates dependency for Menu class.
     1) Returned type is important
     2) Method name should be same like injected field
     */

    @Bean
    List<MenuItem> items() {
        return List.of(
                MenuItem.builder()
                        .label("Add address")
                        .action(()->{})
                        .build(),
                MenuItem.builder()
                        .label("Search")
                        .action(()->{})
                        .build(),
                MenuItem.builder()
                        .label("Quit")
                        .action(()->{})
                        .build()
        );
    }
    @Bean
    String message() {
        return "Address book" + "\n" + "Version: 1.0.1";
    }
}
