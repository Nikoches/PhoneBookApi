package ru.kocheshkov.phonebook.Exceptions;

public class ContactNotFoundException extends RuntimeException{
    public ContactNotFoundException(){
        super("Contact not found");
    }
}
