package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;

public class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public PlayerDTO toDTO() {
        return new PlayerDTO(this.name, this.symbol);
    }

    public char getSymbol() {
        return this.symbol;
    }
}
