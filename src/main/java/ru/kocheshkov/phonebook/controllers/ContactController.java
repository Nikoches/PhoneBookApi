package ru.kocheshkov.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kocheshkov.phonebook.Exceptions.ContactAlreadyExistExeption;
import ru.kocheshkov.phonebook.Exceptions.ContactNotFoundException;
import ru.kocheshkov.phonebook.Exceptions.UserAlreadyExists;
import ru.kocheshkov.phonebook.Exceptions.UserNotFoundException;
import ru.kocheshkov.phonebook.domain.Contact;
import ru.kocheshkov.phonebook.domain.User;
import ru.kocheshkov.phonebook.repo.ContactsRepo;
import ru.kocheshkov.phonebook.service.ContactsService;
import ru.kocheshkov.phonebook.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactsService contactsService;
    @Autowired
    private UsersService usersService;

    @GetMapping("/contacts/{id}")
    public List<Contact> getAllContactsByUserId(@PathVariable long id){
        if(!usersService.userExistById(id)){
            throw new UserNotFoundException(id);
        }
       return contactsService.findAllContactsByUserId(id);
    }
    @PostMapping("/contacts")
    Contact newContact(@RequestBody Contact contact) {
        if (contactsService.contactExistById(contact.getId())) {
            throw new ContactAlreadyExistExeption();
        }
        if(!usersService.userExistById(contact.getUser().getId())){
            throw new UserNotFoundException(contact.getUser().getId());
        }
        return contactsService.saveContact(contact);
    }
    @PutMapping("/contacts/{id}")
    Contact replaceContact(@RequestBody Contact newContact, @PathVariable Long id) {
        if(!usersService.userExistById(id)){
            throw new UserNotFoundException(id);
        }
        return contactsService.findById(id)
                .map(contact -> {
                    contact.setName(newContact.getName());
                    contact.setNumber(newContact.getNumber());
                    contact.setUser(newContact.getUser());
                    return contactsService.saveContact(contact);
                })
                .orElseThrow(ContactNotFoundException::new);
    }

    @DeleteMapping("/contacts/{id}")
    void deleteContact(@PathVariable Long id) {
        if (!contactsService.contactExistById(id)) {
            throw  new ContactNotFoundException();
        }
        contactsService.deleteContactById(id);
    }
    @GetMapping("/find/contact")
    List<Contact> getContactByNumber(@RequestParam String number) {

        return contactsService.findByNumber(number);
    }
}
