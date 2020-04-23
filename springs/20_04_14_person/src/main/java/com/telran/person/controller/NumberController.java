package com.telran.person.controller;

import com.telran.person.dto.NumberDto;
import com.telran.person.service.NumberService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class NumberController {
    final private NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @PostMapping("/person/{id}/number")
    public void create(@PathVariable("id") int personId, @RequestBody NumberDto numberIn) {
        numberIn.personId = personId;
        numberService.create(numberIn);
    }

    @GetMapping("/person/{id}/number")
    public List<NumberDto> getNumbersByPersonId(@PathVariable("id") int id) {
        return numberService.getAllNumbersByPerson(id);
    }

    @PutMapping("/number/")
    public NumberDto editNumber(@RequestBody NumberDto numberDto) {
        return numberService.editNumber(numberDto);
    }

    @DeleteMapping("/number/{id}")
    public void removeNumber(@PathVariable("id") int id) {
        numberService.removeById(id);
    }

    @GetMapping("/number/{id}/")
    public NumberDto getNumberById(@PathVariable("id") int id) {
        return numberService.getNumberById(id);
    }
}
