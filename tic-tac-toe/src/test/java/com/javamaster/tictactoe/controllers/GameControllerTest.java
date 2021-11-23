package com.javamaster.tictactoe.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javamaster.tictactoe.model.Game;
import com.javamaster.tictactoe.model.Player;
import com.javamaster.tictactoe.model.request.ConnectRequest;
import com.javamaster.tictactoe.service.GameService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameService gameService;
    
    @Test
    void start() throws Exception {

        Player player = new Player();

        player.setLogin("eth0");

        when(gameService.createGame(player)).thenCallRealMethod();

        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/game/start")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(player))
        ).andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.gameId").exists()).andReturn();
    }

    @Test()
    void should_not_connect_when_id_not_exist() throws Exception {

        ConnectRequest connectRequest = new ConnectRequest();
        connectRequest.setPlayer(new Player("onimaru"));
        connectRequest.setGameId("5e16f5d4-1a38-4322-9744-d5bf9ff9a5c1");

        when(gameService.connectToGame(connectRequest.getPlayer(), connectRequest.getGameId())).thenCallRealMethod().thenThrow();

        mockMvc.perform(
            MockMvcRequestBuilders
            .post("/game/connect")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(connectRequest))
        ).andDo(print()).andExpect(status().isInternalServerError());
    }
    public static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
}
