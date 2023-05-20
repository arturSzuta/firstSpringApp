package com.example.firstspringapp.console;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu {


    private final List<MenuItem> items;
    // dependency
    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    public void print(){
        int i = 1;
        for(var item: items){
            System.out.println(i++ + "." + item.getLabel());
        }
    }
    public void runAction(int option) {
        //TODO add option validation
        items.get(option - 1).getAction().run();
    }
}
