package ru.kocheshkov.phonebook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kocheshkov.phonebook.domain.User;

public interface UsersRepo extends JpaRepository<User,Long> {
}
