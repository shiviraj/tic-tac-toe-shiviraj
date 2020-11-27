package com.step.shivi_melodyni.dto;

import java.util.Objects;
import java.util.TreeMap;

public class BoardDTO {
    private final TreeMap<Integer, Character> cells;
    private final int size;

    public BoardDTO(TreeMap<Integer, Character> cells, int size) {
        this.cells = cells;
        this.size = size;
    }

    public TreeMap<Integer, Character> getCells() {
        return cells;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDTO boardDTO = (BoardDTO) o;
        return Objects.equals(cells, boardDTO.cells);
    }

}