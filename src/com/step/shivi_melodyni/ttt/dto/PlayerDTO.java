package com.step.shivi_melodyni.ttt.dto;

import java.util.Objects;

public class PlayerDTO {
    private final String name;
    private final SymbolDTO symbolDTO;

    public PlayerDTO(String name, SymbolDTO symbolDTO) {
        this.name = name;
        this.symbolDTO = symbolDTO;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return this.symbolDTO.getSymbol();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerDTO playerDTO = (PlayerDTO) o;
        return Objects.equals(name, playerDTO.name) &&
            symbolDTO.equals(playerDTO.symbolDTO);
    }
}
