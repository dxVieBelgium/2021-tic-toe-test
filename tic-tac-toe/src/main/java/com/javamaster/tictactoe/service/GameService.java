package com.javamaster.tictactoe.service;

import java.util.UUID;

import com.javamaster.tictactoe.exception.InvalidGameException;
import com.javamaster.tictactoe.exception.InvalidParamException;
import com.javamaster.tictactoe.exception.NotFoundException;
import com.javamaster.tictactoe.model.Game;
import com.javamaster.tictactoe.model.GameStatus;
import com.javamaster.tictactoe.model.Player;
import com.javamaster.tictactoe.storage.GameStorage;

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

        GameStorage.getInstance().setGame(game);

        return game;
    }

    public Game connectToGame(Player player2, String gameId) throws InvalidParamException, InvalidGameException {

        if(!GameStorage.getInstance().getGames().containsKey(gameId)) {
            throw new InvalidParamException("Game with provided id doesn't exist");
        }

        Game game = GameStorage.getInstance().getGames().get(gameId);

        if(game.getPlayer2() != null) {
            throw new InvalidGameException("Game is not valid anymore");
        }

        game.setPlayer2(player2);
        game.setStatus(GameStatus.IN_PROGRESS);
        GameStorage.getInstance().setGame(game);

        return game;
    }

    public Game connectToRandomGame(Player player2) throws NotFoundException {

        Game game = GameStorage.getInstance().getGames().values().stream()
            .filter(it -> it.getStatus().equals(GameStatus.NEW))
            .findFirst()
            .orElseThrow(()-> new NotFoundException("Game not Found"));

        game.setPlayer2(player2);
        game.setStatus(GameStatus.IN_PROGRESS);
        GameStorage.getInstance().setGame(game);

        return game;
    }
}
