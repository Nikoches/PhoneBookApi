package ru.kocheshkov.phonebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kocheshkov.phonebook.Exceptions.UserAlreadyExists;
import ru.kocheshkov.phonebook.Exceptions.UserNotFoundException;
import ru.kocheshkov.phonebook.domain.User;
import ru.kocheshkov.phonebook.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UsersService userService;

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id) {
        return userService.findUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        if (userService.userExistById(user.getId())) {
            throw new UserAlreadyExists(user.getId());
        }
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return userService.findUserById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    return userService.saveUser(user);
                })
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/users/{id}")
    void deleteContact(@PathVariable Long id) {
        if (!userService.userExistById(id)) {
            throw new UserNotFoundException(id);
        }
        userService.deleteById(id);
    }
}
