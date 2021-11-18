package com.javamaster.tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TicToe {
    X(1), O(2);

    private Integer value;

    private TicToe(Integer val) {
        this.value = val;
    }

}
