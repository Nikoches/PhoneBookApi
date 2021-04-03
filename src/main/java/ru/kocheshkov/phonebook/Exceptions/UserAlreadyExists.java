package ru.kocheshkov.phonebook.Exceptions;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(long id){
        super("User with id = "+ id + " already exists.");
    }
}
