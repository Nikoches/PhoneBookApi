package ru.kocheshkov.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kocheshkov.phonebook.domain.Contact;
import ru.kocheshkov.phonebook.repo.ContactsRepo;
import ru.kocheshkov.phonebook.service.ContactsService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactsService contactsService;


    @GetMapping("/contacts/{id}")
    List<Contact> getAllContactsByUserId(@PathVariable long id){
       return contactsService.findAllContactsByUserId(id);
    }
}
