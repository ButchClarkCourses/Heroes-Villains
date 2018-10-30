package com.virtualcodemonkeys.heroesvillains.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(HeroesVillainsController.class)
public class HeroesVillainsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHelloHero() throws Exception {

        String expected = "Why, hello there, Hero.  This is a response from a REST GET request.";

        MvcResult results = mvc.perform(get("/helloHero"))
                .andExpect(result -> {
                    log.info(".andExpect - result: {}", result.getResponse().getContentAsString());
                })
                .andExpect(status().isOk())
                .andReturn();
        String actual = results.getResponse().getContentAsString();
        assertThat(actual, is(equalTo(expected)));
    }
}