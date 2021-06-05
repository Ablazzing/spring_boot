package com.molodyko.spring_boot.exception_handler;

public class NoSuchEmployee extends RuntimeException{

    public NoSuchEmployee(String message) {
        super(message);
    }
}
