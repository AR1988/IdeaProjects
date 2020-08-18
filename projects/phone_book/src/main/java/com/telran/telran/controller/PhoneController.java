package com.telran.telran.controller;

import com.telran.telran.dto.PhoneDto;
import com.telran.telran.service.PhoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PhoneController {

    final PhoneService service;

    public PhoneController(PhoneService service) {
        this.service = service;
    }

    @GetMapping("/{id}/phone/")
    public List<PhoneDto> getAll(@PathVariable int id) {
        System.out.println("getAll Phones");
        return service.getAll(id);
    }

    @GetMapping("/phone/{id}")
    public PhoneDto getById(@PathVariable int id) {
        return service.getById(id);
    }

    @DeleteMapping("/phone/{id}")
    public void deleteById(@PathVariable int id) {
        System.out.println("remove phone id: " + id);
        service.remove(id);
    }

    @PutMapping("/phone/")
    public void edit(@RequestBody PhoneDto phoneDto) {
        System.out.println("edit phone: " + phoneDto.toString());
        service.edit(phoneDto);
    }

    @PostMapping("/phone/")
    public void add(@RequestBody PhoneDto phoneDto) {
        System.out.println("add phone: " + phoneDto.toString());
        service.create(phoneDto);
    }
}
