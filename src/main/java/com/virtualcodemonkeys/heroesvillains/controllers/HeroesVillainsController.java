package com.virtualcodemonkeys.heroesvillains.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroesVillainsController {

    @GetMapping("/helloHero")
    public String helloHero(){
        return "Why, hello there, Hero.  This is a response from a REST GET request.";
    }
}
