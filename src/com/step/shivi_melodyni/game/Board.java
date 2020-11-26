package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.BoardDTO;

public class Board {

    private final char[][] cells;

    public Board(int boardSize) {
        this.cells = new char[boardSize][boardSize];
    }

    public int size() {
        return this.cells.length * this.cells.length;
    }

    public BoardDTO toDTO() {
        return new BoardDTO(this.cells);
    }

    public void place(int cellNo, char symbol) {
        int rowNo = (cellNo - 1) / this.cells.length;
        int colNo = (cellNo - 1) % this.cells.length;
        this.cells[rowNo][colNo] = symbol;
    }

    public boolean isValidMove(int cellNo) {
        if(cellNo < 1 || cellNo > this.size()){
            return false;
        }
        int rowNo = (cellNo - 1) / this.cells.length;
        int colNo = (cellNo - 1) % this.cells.length;
        return this.cells[rowNo][colNo] == '\u0000';
    }
}
