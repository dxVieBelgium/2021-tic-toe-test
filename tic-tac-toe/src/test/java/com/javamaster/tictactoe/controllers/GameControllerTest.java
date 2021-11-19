package com.javamaster.tictactoe.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamaster.tictactoe.model.Player;
import com.javamaster.tictactoe.service.GameService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
public class GameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private GameService gameService;
    
    @Test
    void start() throws Exception {
        Player player = new Player();

        player.setLogin("eth0");

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/start")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(player))
        ).andExpectAll(status().isOk());
    }

    public static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
}
