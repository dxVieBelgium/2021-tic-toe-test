package com.javamaster.tictactoe.model;

import java.util.Objects;

import lombok.Data;

@Data
public class GamePlay {
    
    private TicToe type;
    private Integer coordinateX;
    private Integer coordinateY;
    private String gameId;


    public GamePlay() {
    }

    public GamePlay(TicToe type, Integer coordinateX, Integer coordinateY, String gameId) {
        this.type = type;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.gameId = gameId;
    }

    public TicToe getType() {
        return this.type;
    }

    public void setType(TicToe type) {
        this.type = type;
    }

    public Integer getCoordinateX() {
        return this.coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return this.coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getGameId() {
        return this.gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public GamePlay type(TicToe type) {
        setType(type);
        return this;
    }

    public GamePlay coordinateX(Integer coordinateX) {
        setCoordinateX(coordinateX);
        return this;
    }

    public GamePlay coordinateY(Integer coordinateY) {
        setCoordinateY(coordinateY);
        return this;
    }

    public GamePlay gameId(String gameId) {
        setGameId(gameId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GamePlay)) {
            return false;
        }
        GamePlay gamePlay = (GamePlay) o;
        return Objects.equals(type, gamePlay.type) && Objects.equals(coordinateX, gamePlay.coordinateX) && Objects.equals(coordinateY, gamePlay.coordinateY) && Objects.equals(gameId, gamePlay.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, coordinateX, coordinateY, gameId);
    }

    @Override
    public String toString() {
        return "{" +
            " type='" + getType() + "'" +
            ", coordinateX='" + getCoordinateX() + "'" +
            ", coordinateY='" + getCoordinateY() + "'" +
            ", gameId='" + getGameId() + "'" +
            "}";
    }

}
