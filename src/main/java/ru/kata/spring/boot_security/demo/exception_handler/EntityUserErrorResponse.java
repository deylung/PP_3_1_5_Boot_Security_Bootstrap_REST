package ru.kata.spring.boot_security.demo.exception_handler;

public class EntityUserErrorResponse {
    private String info;

    public EntityUserErrorResponse() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
