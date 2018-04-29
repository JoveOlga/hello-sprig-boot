package com.olgaruban.service;

import com.olgaruban.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getCache();
    List<Contact> getListExcept(String pattern);
}
