package com.olgaruban.web;

import com.olgaruban.model.Contact;
import com.olgaruban.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class Controller {

    private final ContactService service;

    @Autowired
    public Controller(ContactService service) {
        this.service = service;
    }


    @GetMapping("/hello/contacts")
    public List<Contact> getContacts(@RequestParam(value = "nameFilter", required = true) String nameFilter) {
            return service.getListExcept(nameFilter);
    }

}
