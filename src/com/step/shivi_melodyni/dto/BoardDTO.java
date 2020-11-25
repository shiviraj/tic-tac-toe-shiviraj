package com.step.shivi_melodyni.dto;

import java.util.Arrays;

public class BoardDTO {
    private String[][] cells;

    public BoardDTO(String[][] cells) {
        this.cells = cells;
    }

    public String[][] getCells() {
        return cells;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDTO boardDTO = (BoardDTO) o;
        return Arrays.deepEquals(cells, boardDTO.cells);
    }
}