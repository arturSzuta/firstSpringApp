package com.example.firstspringapp.controller;

import com.example.firstspringapp.console.Menu;
import com.example.firstspringapp.console.MenuItem;
import com.example.firstspringapp.service.AddressBookService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ScannerController {
    private final Scanner scanner;
    private final AddressBookService service;
     private final Menu menu;

    public ScannerController(Scanner scanner, AddressBookService service) {
        this.scanner = scanner;
        this.service = service;
        menu = new Menu(
                List.of(
                        MenuItem
                                .builder()
                                .label("Show all")
                                .action(()-> findAll())
                                .build(),
                        MenuItem
                                .builder()
                                .label("Add address")
                                .action(()-> addAddress())
                                .build(),
                        MenuItem
                                .builder()
                                .label("Search")
                                .action(()-> findAddresses())
                                .build(),
                        MenuItem
                                .builder()
                                .label("Exit")
                                .action(()-> exit())
                                .build()
                )
        );
    }

    public void mainLoopRun() {
        while (true){
            menu.print();
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();
                menu.runAction(option);
            } else {
                scanner.nextLine();
                System.out.println("Wrong option format");
            }
        }
    }
    public void addAddress(){
        System.out.println("Username:");
        String name = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        service.saveAddress(name, email);
        System.out.println(service.findAll());
    }
    public void exit(){
        System.exit(0);
    }
    public void findAddresses(){
        System.out.println("Searched pattern: ");
        String pattern = scanner.nextLine();
        System.out.println(service.findByUsernamePattern(pattern));
    }
    public void findAll() {
        service.findAll().forEach(System.out::println);
    }
}
