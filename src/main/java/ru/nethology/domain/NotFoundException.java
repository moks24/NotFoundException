package ru.nethology.domain;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String e) {
        super(e);
    }
}
