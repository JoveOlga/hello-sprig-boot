package com.olgaruban.service;

import com.olgaruban.model.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTest {

    @Autowired
    private ContactService service;

    @Test
    public void getListExcept() {
        List<Contact> filteredList = service.getListExcept("^Alex$");
        assertTrue(!filteredList.contains(new Contact("Alex")));

        filteredList = service.getListExcept("[AMei]");
        assertTrue(!filteredList.contains(new Contact("Alex")));
        assertTrue(!filteredList.contains(new Contact("Mike")));
        assertTrue(!filteredList.contains(new Contact("Sofia")));
        assertTrue(!filteredList.contains(new Contact("Joseph")));
        assertTrue(!filteredList.contains(new Contact("Jessica")));
    }

}