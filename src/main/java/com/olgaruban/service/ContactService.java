package com.olgaruban.service;

import com.olgaruban.model.Contact;

import java.util.List;

public interface ContactService {
    void setCache();
    List<Contact> getListExcept(String pattern);
}
