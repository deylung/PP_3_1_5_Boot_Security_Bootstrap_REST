package ru.kata.spring.boot_security.demo.exception_handler;

public class EntityUserNotFoundException extends RuntimeException{
    public EntityUserNotFoundException(String message) {
        super(message);
    }
}
