package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @ResponseBody
    @PostMapping("/person")
    public void createPerson(@RequestBody PersonDto personDto) {
        personService.create(personDto);
    }


    @ResponseBody
    @GetMapping("/person")
    public List<PersonDto> getByName(@RequestParam(value = "name", required = false) String firstName) {
        return firstName == null ? personService.getAll() : personService.getByName(firstName);

    }

    @ResponseBody
    @GetMapping("/person/get")
    public PersonDto getById(@RequestParam(value = "id", required = false) int id) {
        return personService.getById(id);
    }

    @ResponseBody
    @GetMapping("/person/remove")
    public PersonDto removeByName(@RequestParam(value = "name") String firstName) {
        return personService.deleteByName(firstName);
    }

    @GetMapping("/person/remove/{id}")
    public PersonDto removeById(@PathVariable int id) {
        return personService.deleteById(id);
    }
//    @ResponseBody
//    @GetMapping("/person/remove/id")
//    public void removeById(@RequestParam(value = "id") int id) {
//        personService.removeById(id);
//    }

    @ResponseBody
    @GetMapping("/person/greater")
    public List<PersonDto> getByName(@RequestParam(value = "then") int n) {
        return personService.getAllGreaterN(n);
    }
}
