package com.javamaster.tictactoe.model;

import java.util.Objects;

import lombok.Data;

@Data
public class Player {
    private String login;


    public Player() {
    }

    public Player(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Player login(String login) {
        setLogin(login);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Player)) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(login, player.login);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(login);
    }

    @Override
    public String toString() {
        return "{" +
            " login='" + getLogin() + "'" +
            "}";
    }

}
