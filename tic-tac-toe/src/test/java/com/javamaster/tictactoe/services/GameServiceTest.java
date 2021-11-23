package com.javamaster.tictactoe.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Map.Entry;

import com.javamaster.tictactoe.model.Game;
import com.javamaster.tictactoe.model.Player;
import com.javamaster.tictactoe.service.GameService;
import com.javamaster.tictactoe.storage.GameStorage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class GameServiceTest {
    
    @Spy
    @InjectMocks
    private GameService gameService;

    @Test
    public void when_create_game_should_not_null() {
        Player player = new Player("wutang");

        when(gameService.createGame(player)).thenCallRealMethod();

        Optional<Entry<String, Game>> filteredGame = getGameStorage()
        .getGames()
        .entrySet()
        .stream()
        .filter(g -> "wutang".equals(g.getValue().getPlayer1().getLogin()))
        .findFirst();

        Game createdGame = filteredGame.get().getValue();

        assertNotNull(createdGame);
    }

    GameStorage getGameStorage() {
        return GameStorage.getInstance();
    }
        
}
