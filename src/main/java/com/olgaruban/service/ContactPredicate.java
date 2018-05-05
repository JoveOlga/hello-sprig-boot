package com.olgaruban.service;

import com.olgaruban.model.Contact;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public final class ContactPredicate implements Predicate<Contact> {
    private final Pattern pattern;

    public ContactPredicate(String regex) {
        pattern = Pattern.compile("((?!" + regex + ").)*");
    }

    @Override
    public boolean test(Contact contact) {
        if ("((?!).)*".equals(pattern.toString())) {
            return true;
        }
        return pattern.matcher(contact.getName()).matches();
    }
}