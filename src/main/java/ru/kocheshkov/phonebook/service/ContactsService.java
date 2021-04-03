package ru.kocheshkov.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kocheshkov.phonebook.domain.Contact;
import ru.kocheshkov.phonebook.domain.User;
import ru.kocheshkov.phonebook.repo.ContactsRepo;
import ru.kocheshkov.phonebook.repo.UsersRepo;

import java.util.ArrayList;
import java.util.List;


@Service
public class ContactsService {
    @Autowired
    private final ContactsRepo contactsRepo;

    public ContactsService(ContactsRepo contactsRepo) {
        this.contactsRepo = contactsRepo;
    }

    public List<Contact> findAllContactsByUserId(long id) {
        List<Contact> contacts = contactsRepo.findByUserId(id);

        return new ArrayList<>(contactsRepo.findAll());
    }

//    public Optional<User> findUserById(long id) {
//        return usersRepo.findById(id);
//    }
//
//    public User saveUser(User user) {
//        return usersRepo.save(user);
//    }
//
//    public void deleteById(long id) {
//        usersRepo.deleteById(id);
//    }
//
//    public boolean userExistById(long id) {
//        return usersRepo.existsById(id);
//    }
//}
}
