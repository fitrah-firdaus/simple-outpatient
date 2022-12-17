package org.simple.clinic.outpatient.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    private static final String HELLO_WORLD = "Hello World";

    public String helloWorld() {
        return HELLO_WORLD;
    }
}
