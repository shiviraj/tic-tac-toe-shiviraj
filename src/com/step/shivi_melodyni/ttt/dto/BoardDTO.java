package com.step.shivi_melodyni.ttt.dto;

import java.util.Arrays;

public class BoardDTO {
    private final char[] cells;

    public BoardDTO(char[] cells) {
        this.cells = cells;
    }

    public char[] getCells() {
        return cells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDTO boardDTO = (BoardDTO) o;
        return Arrays.equals(cells, boardDTO.cells);
    }

}