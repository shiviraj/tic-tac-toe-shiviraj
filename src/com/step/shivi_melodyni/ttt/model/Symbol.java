package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.dto.SymbolDTO;

public enum Symbol {
    CROSS('X'),
    ZERO('O'),
    EMPTY('\u0000');

    private char symbol;

    Symbol(char symbol){
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return this.equals(EMPTY);
    }

    public SymbolDTO toDTO() {
        return new SymbolDTO(this.symbol);
    }
}
