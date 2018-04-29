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
        List<Contact> allList = service.getCache();

        int regexLength = allList.size() == 0 ? 0 : (allList.size() <= 5 ? allList.size()-1 : 5);
        if (regexLength == 0)
            throw new RuntimeException("Empty Cache");

        StringBuilder regex = new StringBuilder("[");
        Contact[] expContact = new Contact[regexLength];
        while (regexLength > 0) {
            Random random = new Random();
            int id = random.nextInt(allList.size()-1);
            Contact tmpContact = allList.get(id);
            String name = tmpContact.getName();
            regex.append(name.charAt(random.nextInt(name.length()-1)));
            expContact[--regexLength] = tmpContact;
        }
        regex.append("]");

        for (Contact contact: expContact) {
            assertTrue(allList.contains(contact));
        }

        List<Contact> filteredList = service.getListExcept(regex.toString());

        for (Contact contact: expContact) {
            assertTrue(!filteredList.contains(contact));
        }

    }

}