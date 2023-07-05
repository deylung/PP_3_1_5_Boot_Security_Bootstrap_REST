package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UsersAndRoles implements CommandLineRunner {
    private RoleServiceImpl roleServiceImpl;
    private UserServiceImpl userServiceImpl;

    @Autowired
    public UsersAndRoles(RoleServiceImpl roleServiceImpl, UserServiceImpl userServiceImpl) {
        this.roleServiceImpl = roleServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void run(String... args) {
        Role userTest = new Role(1L, "USER");
        Role adminTest = new Role(2L, "ADMIN");
        roleServiceImpl.saveRole(userTest);
        roleServiceImpl.saveRole(adminTest);
        Set<Role> userSet = Stream.of(userTest).collect(Collectors.toSet());
        Set<Role> adminSet = Stream.of(adminTest).collect(Collectors.toSet());

        User user = new User("User", "User",32, "user@mail.ru", "user", userSet);
        User admin = new User("Admin", "Admin",24, "admin@mail.ru", "admin", adminSet);
        userServiceImpl.add(user);
        userServiceImpl.add(admin);

    }
}
