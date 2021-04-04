package ru.kocheshkov.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.kocheshkov.phonebook.domain.Contact;
import ru.kocheshkov.phonebook.domain.User;
import ru.kocheshkov.phonebook.repo.ContactsRepo;
import ru.kocheshkov.phonebook.repo.UsersRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ContactsService {
    @Autowired
    private final ContactsRepo contactsRepo;

    public ContactsService(ContactsRepo contactsRepo) {
        this.contactsRepo = contactsRepo;
    }

    public List<Contact> findAllContactsByUserId(long id) {
        return contactsRepo.findByUserId(id);
    }

    public Optional<Contact> findById(long id){
        return contactsRepo.findById(id);
    }
    public Contact saveContact(Contact contact){

        return contactsRepo.save(contact);
    }
    public void deleteContactById(long id){
        contactsRepo.deleteById(id);
    }
    public boolean contactExistById(long id){
        return contactsRepo.existsById(id);
    }
    public List<Contact> findByNumber(String number){
        return contactsRepo.findContactByNumber(number);
    }
}
