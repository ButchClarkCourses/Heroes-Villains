package com.virtualcodemonkeys.heroesvillains.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HeroesVillainsController {

    @GetMapping("/helloHero")
    public String helloHero(){
        log.info("Returning string from /helloHero");
        return "Why, hello there, Hero.  This is a response from a REST GET request.";
    }
}
