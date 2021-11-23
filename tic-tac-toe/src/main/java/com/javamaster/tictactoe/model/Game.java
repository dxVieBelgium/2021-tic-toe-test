package com.javamaster.tictactoe.model;

import java.util.Objects;

import com.javamaster.tictactoe.model.enums.GameStatus;
import com.javamaster.tictactoe.model.enums.TicToe;

import lombok.Data;

@Data
public class Game {
    
    private String gameId;
    private Player player1;
    private Player player2;
    private GameStatus status;
    private int[][] board;
    private TicToe winner;


    public Game() {
    }

    public Game(String gameId, Player player1, Player player2, GameStatus status, int[][] board, TicToe winner) {
        this.gameId = gameId;
        this.player1 = player1;
        this.player2 = player2;
        this.status = status;
        this.board = board;
        this.winner = winner;
    }

    public String getGameId() {
        return this.gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public TicToe getWinner() {
        return this.winner;
    }

    public void setWinner(TicToe winner) {
        this.winner = winner;
    }

    public Game gameId(String gameId) {
        setGameId(gameId);
        return this;
    }

    public Game player1(Player player1) {
        setPlayer1(player1);
        return this;
    }

    public Game player2(Player player2) {
        setPlayer2(player2);
        return this;
    }

    public Game status(GameStatus status) {
        setStatus(status);
        return this;
    }

    public Game board(int[][] board) {
        setBoard(board);
        return this;
    }

    public Game winner(TicToe winner) {
        setWinner(winner);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Game)) {
            return false;
        }
        Game game = (Game) o;
        return Objects.equals(gameId, game.gameId) && Objects.equals(player1, game.player1) && Objects.equals(player2, game.player2) && Objects.equals(status, game.status) && Objects.equals(board, game.board) && Objects.equals(winner, game.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, player1, player2, status, board, winner);
    }

    @Override
    public String toString() {
        return "{" +
            " gameId='" + getGameId() + "'" +
            ", player1='" + getPlayer1() + "'" +
            ", player2='" + getPlayer2() + "'" +
            ", status='" + getStatus() + "'" +
            ", board='" + getBoard() + "'" +
            ", winner='" + getWinner() + "'" +
            "}";
    }

}
