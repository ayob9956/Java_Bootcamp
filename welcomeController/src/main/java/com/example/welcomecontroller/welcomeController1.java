package com.example.welcomecontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeController1 {

    @GetMapping(path = "/name")
    public String name() {
        return "My name is Ayoub Ayed";

    }

    @GetMapping(path = "/age")
    public String age() {
        return "My age is 23";
    }

    @GetMapping(path = "/check/status")
    public String checkstate() {
        return "Everything OK";
    }

    @GetMapping(path = "/health")
    public String health() {
        return "Server health is up and running";

    }

        String[] names = new String[]{"Ayoub", "Ali", "Ahmed"};
    @GetMapping(path = "/names")
    public String[] names() {
        return names;

    }

}
