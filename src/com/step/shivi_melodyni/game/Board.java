package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.BoardDTO;

public class Board {
    static class Move {
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

    private Move findRowColNo(int cellNo) {
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
        if (cellNo < 1 || cellNo > this.size()) {
            return false;
        }
        Move move = findRowColNo(cellNo);
        return this.cells[move.row][move.col] == '\u0000';
    }


    public boolean anyDiagonalContainsSameSymbol() {
        char[] diagonal1 = new char[this.cells.length];
        for (int i = 0; i < this.cells.length; i++) {
            diagonal1[i] = this.cells[i][i];
        }
        if (every(diagonal1)) return true;

        char[] diagonal2 = new char[this.cells.length];
        for (int i = 0; i < this.cells.length; i++) {
            diagonal2[i] = this.cells[i][this.cells.length - 1 - i];
        }
        return every(diagonal2);
    }

    public boolean anyColumnContainsSameSymbol() {
        for (int i = 0; i < this.cells.length; i++) {
            char[] col = new char[this.cells.length];
            for (int j = 0; j < this.cells.length; j++) {
                col[j] = this.cells[j][i];
            }
            if (every(col)) return true;
        }
        return false;
    }

    public boolean anyRowsContainsSameSymbol() {
        for (char[] row : this.cells) {
            if (every(row)) return true;
        }
        return false;
    }

    private boolean every(char[] symbol) {
        for (char c : symbol) {
            if (c != symbol[0] || c == '\u0000') return false;
        }
        return true;
    }

}
