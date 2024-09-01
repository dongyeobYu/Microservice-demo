package com.example.userservice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class Greeting {

    private final Environment env;

    public String getMessage() {
        return env.getProperty("greeting.message");
    }
}
