package ru.kocheshkov.phonebook.Exceptions;

 public class UserNotFoundException extends RuntimeException{
     public UserNotFoundException(Long id) {
         super("Could not find user " + id+ "\n This user doesnt exist.");
     }
}
