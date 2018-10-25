package com.example.demo.Controllers;

import com.example.demo.Person;
import com.example.demo.Repository.TemperatureRepository;
import com.example.demo.models.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    TemperatureRepository temperatureRepository;

    @GetMapping(value = "/")
    @ResponseBody()
    public String Index()
    {
        System.out.println("Temperature repository count " + temperatureRepository.count());
        List<Temperature> temperatureList = temperatureRepository.findAll();
        for (Temperature temp : temperatureList) {
            System.out.println(temp.getId() + ", " + temp.getRoom() + ", " + temp.getTemperature());
        }
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

    @GetMapping("/temperature")
    public List<Temperature> getAllPersons()
    {
        temperatureRepository.save(new Temperature(2, 44.2f));
        return temperatureRepository.findAll();
    }

}
