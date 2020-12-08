package com.step.shivi_melodyni.ttt.dto;

public class SymbolDTO {
    private final char symbol;

    public SymbolDTO(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SymbolDTO symbolDTO = (SymbolDTO) o;
        return symbol == symbolDTO.symbol;
    }

}
