package com.olgaruban.service;

import com.olgaruban.model.Contact;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class ContactPredicate implements Predicate<Contact> {
    private final String regex;

    public ContactPredicate(String regex) {
        this.regex = regex;
    }

    @Override
    public boolean test(Contact contact) {
        if ("".equals(regex)) {
            return true;
        }
        Pattern pattern = Pattern.compile("((?!" + this.regex + ").)*");
        return pattern.matcher(contact.getName()).matches();
    }
}