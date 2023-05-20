package com.example.firstspringapp.console;

import org.springframework.stereotype.Component;

import java.util.List;

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
            System.out.println(i + "." + item.getLabel());
            i++;
        }
    }
}
