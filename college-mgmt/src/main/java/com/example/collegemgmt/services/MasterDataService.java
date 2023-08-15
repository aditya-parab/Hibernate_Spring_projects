package com.example.collegemgmt.services;

import com.example.collegemgmt.Student;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MasterDataService {
    private List<String> countries;
//    private HashMap<String,String> usernamePasswordStore = new HashMap<>();

    private List<Student> students;



    MasterDataService(){
    this.countries = Arrays.asList("india","brazil","spain","usa");
    students = Arrays.asList(new Student("admin","123","IN","M"),
            new Student("xyz","456","IN","M"));
    }



    public List<String > getCountries(){
        return this.countries.stream()
                .map(country->country.toUpperCase())
                .collect(Collectors.toList());
    }


public Student authenticate(String username, String password){
        List<Student> students =this.students
                .stream()
                .filter(student -> student.getUsername().equals(username) && student.getPassword().equals(password))
                .collect(Collectors.toList());

        if(students.size()>0){
            return students.get(0);
        }
        else{
            return null;
        }
}

}
