package ru.kocheshkov.phonebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kocheshkov.phonebook.domain.User;

import java.util.List;

public interface UsersRepo extends JpaRepository<User,Long> {
    List<User> findAllByName(String name);
}
