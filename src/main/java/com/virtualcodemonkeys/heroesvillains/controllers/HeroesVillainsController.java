package com.virtualcodemonkeys.heroesvillains.controllers;

import com.virtualcodemonkeys.heroesvillains.mongo.CharactersRepository;
import com.virtualcodemonkeys.heroesvillains.mongo.DBCharacter;
import com.virtualcodemonkeys.heroesvillains.mongo.DBGroup;
import com.virtualcodemonkeys.heroesvillains.mongo.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroesVillainsController {

    @Autowired
    private CharactersRepository charactersRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    @GetMapping("/helloHero")
    public String helloHero() {
        return "Why, hello there, Hero.  This is a response from a REST GET request.";
    }

    @GetMapping("/characters")
    public List<DBCharacter> getCharacters(){
        return charactersRepository.findAll();
    }

    @GetMapping("/groups")
    public List<DBGroup> getGroups(){
        return groupsRepository.findAll();
    }
}
