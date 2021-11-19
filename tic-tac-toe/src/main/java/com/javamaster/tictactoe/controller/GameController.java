package com.javamaster.tictactoe.controller;

import com.javamaster.tictactoe.controller.dto.ConnectRequest;
import com.javamaster.tictactoe.exception.InvalidGameException;
import com.javamaster.tictactoe.exception.InvalidParamException;
import com.javamaster.tictactoe.exception.NotFoundException;
import com.javamaster.tictactoe.model.Game;
import com.javamaster.tictactoe.model.GamePlay;
import com.javamaster.tictactoe.model.Player;
import com.javamaster.tictactoe.service.GameService;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {
    

    private final GameService gameService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/start")
    public ResponseEntity<Game> start(@RequestBody Player player) {
        
        log.info("Start game: ", player);
        return ResponseEntity.ok(gameService.createGame(player));
    }

    @PostMapping("/connect")
    public ResponseEntity<Game> connect(@RequestBody ConnectRequest request) throws InvalidParamException, InvalidGameException {

        log.info("Player connection: ", request);

        return ResponseEntity.ok(gameService.connectToGame(request.getPlayer(), request.getGameId()));
    }

    @PostMapping("/connect/random")
    public ResponseEntity<Game> connectRandom(@RequestBody Player player) throws NotFoundException {

        log.info("connection to random game: ", player);

        return ResponseEntity.ok(gameService.connectToRandomGame(player));
    }

    @PostMapping("/gameplay")
    public ResponseEntity<Game> gamePlay(@RequestBody GamePlay gamePlay) throws NotFoundException, InvalidGameException {

        log.info("Update the game: ", gamePlay);

        Game game = gameService.gamePlay(gamePlay);

        simpMessagingTemplate.convertAndSend("/topic/game-progress/"+game.getGameId(), game);

        return ResponseEntity.ok(game);
    }
}
