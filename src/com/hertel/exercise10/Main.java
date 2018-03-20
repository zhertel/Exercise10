package com.hertel.exercise10;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Contact contact1 = new Contact("Zach","zhertel@student.cscc.edu");
        Contact contact2 = new Contact("James","jkells@student.cscc.edu");

        Contact[] contactArray = {contact1, contact2};

	    ContactCollection contacts = new ContactCollection(contactArray);

	    for (Contact contact:contacts) {
            contact.display();
        }
    }
}

class Contact {
    private String name;
    private String email;

    public Contact(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void display() {
        System.out.println(name + ": " + email);
    }
}

class ContactCollection implements Iterable<Contact>, Iterator<Contact> {
    private Contact[] contacts;
    private int currentContact;

    public ContactCollection(Contact[] contacts) {
        this.contacts = contacts;
    }

    @Override
    public Iterator<Contact> iterator() {
        setCurrentContact(0);
        return this;
    }

    @Override
    public boolean hasNext() {
        return currentContact < contacts.length;
    }

    @Override
    public Contact next() {
        if (hasNext()) {
            int index = getCurrentContact();
            currentContact++;
            return contacts[index];
        }
        else {
            return null;
        }
    }

    public int getCurrentContact() {
        return currentContact;
    }

    public void setCurrentContact(int currentContact) {
        this.currentContact = currentContact;
    }
}