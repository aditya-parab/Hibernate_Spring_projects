package com.example.collegemgmt.services;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MasterDataService {

    MasterDataService(){
    this.countries = Arrays.asList("india","brazil","spain","usa");
    }

    private List<String> countries;

    public List<String > getCountries(){
        return this.countries.stream()
                .map(country->country.toUpperCase())
                .collect(Collectors.toList());
    }

}
