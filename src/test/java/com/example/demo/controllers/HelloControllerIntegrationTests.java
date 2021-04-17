package com.example.demo.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloWithoutName() throws Exception {
        mockMvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(view().name("hello")).andExpect(model().attribute("user", is("World")));
    }

    public void testHelloWithName() throws Exception {
        mockMvc.perform(get("/hello").param("name", "dolly").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hello")).andExpect(model().attribute("user", is("dolly")));
    }
}
