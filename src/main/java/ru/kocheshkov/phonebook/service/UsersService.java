package ru.kocheshkov.phonebook.service;

import org.springframework.stereotype.Service;
import ru.kocheshkov.phonebook.Exceptions.UserNotFoundException;
import ru.kocheshkov.phonebook.domain.User;
import ru.kocheshkov.phonebook.repo.UsersRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepo usersRepo;

    public UsersService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(usersRepo.findAll());
    }
    public Optional<User> findUserById(long id) {
        return usersRepo.findById(id);
    }

    public User saveUser(User user){
        return usersRepo.save(user);
    }
    public void deleteById(long id) {
        usersRepo.deleteById(id);
    }
    public boolean userExistById(long id ) {
        return usersRepo.existsById(id);
    }
}
