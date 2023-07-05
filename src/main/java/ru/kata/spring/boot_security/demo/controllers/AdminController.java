package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserServiceImpl userServiceImpl;

    private RoleServiceImpl roleServiceImpl;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
    }

    @GetMapping("/")
    public String printUsers(Model model, Principal principal) {
        User user = userServiceImpl.findByEmail(principal.getName());
        model.addAttribute("user", user);
        List<User> listOfUsers = userServiceImpl.getAllUser();
        model.addAttribute("listOfUsers", listOfUsers);
        return "admin";
    }

    @PostMapping("/")
    public String addUser(@ModelAttribute("user") User user) {
        userServiceImpl.add(user);
        return "redirect:/admin/";
    }

    @PostMapping("/{id}")
    public String saveEditUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userServiceImpl.update(user);
        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.delete(id);
        return "redirect:/admin/";
    }

}
