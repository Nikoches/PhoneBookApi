package ru.kocheshkov.phonebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kocheshkov.phonebook.domain.Contact;

import java.util.List;

public interface ContactsRepo extends JpaRepository<Contact,Long> {
    List<Contact> findByUserId(long userId);
}
