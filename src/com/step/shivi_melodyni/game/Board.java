package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.BoardDTO;

public class Board {

    private final char[][] cells;

    public Board(int boardSize) {
        this.cells = new char[boardSize][boardSize];
    }

    public BoardDTO toDTO() {
        return new BoardDTO(this.cells);
    }
}
