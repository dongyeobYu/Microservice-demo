package com.firstservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
@Slf4j
@RequiredArgsConstructor
public class FirstController {

    private final Environment env;

    @GetMapping("/welcome")
    public String secondService() {
        return "Welcome to the second-service service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info("header : {}", header);
        return "first Service header";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        // 포트번호 가져오기
        log.info("Server port = {}", request.getServerPort());
        return String.format("Hi, This is FirstService %s", env.getProperty("local.server.port"));
    }
}
