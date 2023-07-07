package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;
import ru.kata.spring.boot_security.demo.exception_handler.EntityUserNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApiController {

    private final UserService userService;

    public RestApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User setNewUser(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        try {
            User user = userService.show(id);
            System.out.println(user);
            return user;
        } catch (Exception e) {
            throw new EntityUserNotFoundException("There is no user with ID = " + id + " in Database");
        }

    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable long id) {
        User user = userService.show(id);

        if (user == null) {
            throw new EntityUserNotFoundException("There is no user with ID = " + id + " in Database");
        }
        userService.delete(id);
        return "User with ID = " + id + " was deleted";
    }

}
