package com.step.shivi_melodyni.dto;

import java.util.Objects;

public class PlayerDTO {
    private final String name;
    private final char symbol;

    public PlayerDTO(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDTO playerDTO = (PlayerDTO) o;
        return symbol == playerDTO.symbol &&
            Objects.equals(name, playerDTO.name);
    }

}
