package com.telran.telran.controller;

import com.telran.telran.dto.ContactDto;
import com.telran.telran.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("/api/contact")
public class ContactController {
    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<ContactDto> getAll() {
//        System.out.println("getAll");
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ContactDto getById(@PathVariable int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
//        System.out.println("deleteById");
        service.remove(id);
    }

    @PutMapping("/")
    public void edit(@RequestBody ContactDto contactDto) {
//        System.out.println("edit");
        service.edit(contactDto);
    }

    @PostMapping("/")
    public void add(@RequestBody ContactDto contactDto) {
        System.out.println("add");
        service.create(contactDto);
    }

//    @PostMapping("/api/v1/registration")
//    public void add(@RequestBody User user) {
//        System.out.println("add");
//        System.out.println(user.toString());
////        service.create(contactDto);
//    }

    @GetMapping("/search")
    public List<ContactDto> getByName(@RequestParam(value = "method") String method, @RequestParam(value = "name") String name) {
//        System.out.println("getByName");
        if (method.equals("lastname"))
            return service.getByLastName(name);
        else
            return service.getByName(name);
    }
}
