package ru.kocheshkov.phonebook.Exceptions;

public class ContactAlreadyExistExeption extends RuntimeException{
    public ContactAlreadyExistExeption(){
        super("Contact alredy exist.");
    }
}
