package com.olgaruban.service;

import com.olgaruban.model.Contact;
import com.olgaruban.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository repository;
    private List<Contact> cache;

    @Autowired
    public ContactServiceImpl(final ContactRepository repository) {
        this.repository = repository;
        setCache();
    }

    public void setCache() {
        cache = (List<Contact>)repository.findAll();
    }

    @Override
    public List<Contact> getCache() {
        return cache;
    }

    @Override
    public List<Contact> getListExcept(String regex) {
        ContactPredicate predicate = new ContactPredicate(regex);
        return cache.parallelStream().filter(predicate).collect(Collectors.toList());
    }

}
