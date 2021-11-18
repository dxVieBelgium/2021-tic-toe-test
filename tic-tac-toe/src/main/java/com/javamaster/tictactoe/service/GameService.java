package com.javamaster.tictactoe.service;

import java.util.UUID;

import com.javamaster.tictactoe.model.Game;
import com.javamaster.tictactoe.model.GameStatus;
import com.javamaster.tictactoe.model.Player;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GameService {
    
    public Game createGame(Player player) {
        Game game = new Game();

        game.setBoard(new int[3][3]);
        game.setGameId(UUID.randomUUID().toString());
        game.setPlayer1(player);
        game.setStatus(GameStatus.NEW);

        return game;
    }
}
