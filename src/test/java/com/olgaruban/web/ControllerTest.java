package com.olgaruban.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.olgaruban.model.Contact;
import com.olgaruban.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ContactService service;

    @Test
    public void getContacts() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Contact> allList = Collections.singletonList(
                new Contact("Steve")
        );

        String regex = "^A.*$";
        given(service.getListExcept(regex)).willReturn(allList);
        this.mvc.perform(
                get("/hello/contacts?nameFilter=" + regex).accept(MediaType.APPLICATION_JSON_UTF8)
        ).andExpect(
                status().isOk()
        ).andExpect(
                content().string(mapper.writeValueAsString(allList))
        );

    }
}