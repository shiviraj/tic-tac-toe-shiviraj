package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.PlayerDTO;

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
}
