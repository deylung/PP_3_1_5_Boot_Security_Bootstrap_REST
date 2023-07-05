package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;
import ru.kata.spring.boot_security.demo.exception_handler.EntityUserNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    private final UserServiceImpl userServiceImpl;

    public RestApiController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/users")
    public User setNewUser(@RequestBody User user) {
        userServiceImpl.add(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userServiceImpl.add(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        try {
            User user = userServiceImpl.show(id);
            System.out.println(user);
            return user;
        } catch (Exception e) {
            throw new EntityUserNotFoundException("There is no user with ID = " + id + " in Database");
        }

    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        User user = userServiceImpl.show(id);

        if (user == null) {
            throw new EntityUserNotFoundException("There is no user with ID = " + id + " in Database");
        }
        userServiceImpl.delete(id);
        return "User with ID = " + id + " was deleted";
    }

}
