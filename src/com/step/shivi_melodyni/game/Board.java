package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.BoardDTO;

public class Board {
    static class Move{
        int row, col;
    }

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

    private Move findRowColNo(int cellNo){
        Move move = new Move();
        move.row = (cellNo - 1) / this.cells.length;
        move.col = (cellNo - 1) % this.cells.length;
        return move;
    }

    public void place(int cellNo, char symbol) {
        Move move = findRowColNo(cellNo);
        this.cells[move.row][move.col] = symbol;
    }

    public boolean isValidMove(int cellNo) {
        if(cellNo < 1 || cellNo > this.size()){
            return false;
        }
        Move move = findRowColNo(cellNo);
        return this.cells[move.row][move.col] == '\u0000';
    }
}
