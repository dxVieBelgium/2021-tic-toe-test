package com.javamaster.tictactoe.model.request;

import java.util.Objects;

import com.javamaster.tictactoe.model.Player;

import lombok.Data;

@Data
public class ConnectRequest {
    
    private Player player;
    private String gameId;


    public ConnectRequest() {
    }

    public ConnectRequest(Player player, String gameId) {
        this.player = player;
        this.gameId = gameId;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getGameId() {
        return this.gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public ConnectRequest player(Player player) {
        setPlayer(player);
        return this;
    }

    public ConnectRequest gameId(String gameId) {
        setGameId(gameId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ConnectRequest)) {
            return false;
        }
        ConnectRequest connectRequest = (ConnectRequest) o;
        return Objects.equals(player, connectRequest.player) && Objects.equals(gameId, connectRequest.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, gameId);
    }

    @Override
    public String toString() {
        return "{" +
            " player='" + getPlayer() + "'" +
            ", gameId='" + getGameId() + "'" +
            "}";
    }

}
