package com.example.firstspringapp.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AddressBookServiceMap implements AddressBookService{
    private Map<String, String> map = new HashMap<>();
    @Override
    public void saveAddress(String username, String emailAddress) {
        map.putIfAbsent(username, emailAddress);
    }

    @Override
    public List<String> findByUsernamePattern(String pattern) {
        return map
                .entrySet()
                .stream()
                .filter(e->e.getKey().contains(pattern))
                .map(e->e.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAll() {
        return map
                .entrySet()
                .stream()
                .map(e->e.getKey() + ": " + e.getValue())
                .toList();
    }
}
