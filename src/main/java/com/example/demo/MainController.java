package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping(value = "/")
    @ResponseBody()
    public String Index()
    {
        return "Main page";
    }

    @GetMapping(value = "/Persons")
    @ResponseBody()
    public List<Person> Persons()
    {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(1, "Marian"));
        persons.add(new Person(12, "Stary Marian"));

        return persons;
    }
}
