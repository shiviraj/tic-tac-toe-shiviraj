package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.dto.BoardDTO;

import java.util.Arrays;

public class Board {
    private final int boardSize;
    private final Symbol[] cells;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cells = new Symbol[boardSize * boardSize];
        Arrays.fill(this.cells, Symbol.EMPTY);
    }

    private Board(Symbol[] cells, int boardSize) {
        this.cells = cells;
        this.boardSize = boardSize;
    }

    public int size() {
        return this.boardSize * this.boardSize;
    }

    public BoardDTO toDTO() {
        char[] chars = new char[this.cells.length];
        for (int i = 0; i < this.cells.length; i++) {
            chars[i] = this.cells[i].toDTO().getSymbol();
        }
        return new BoardDTO(chars);
    }

    public Board cloneBoard() {
        return new Board(this.cells.clone(), this.boardSize);
    }

    public boolean place(int cellNo, Symbol symbol) {
        boolean validMove = isValidMove(cellNo);
        if (validMove) {
            this.cells[cellNo - 1] = symbol;
        }
        return validMove;
    }

    private boolean isValidMove(int cellNo) {
        if (cellNo < 1 || cellNo > this.size()) {
            return false;
        }
        return this.cells[cellNo - 1].isEmpty();
    }

    public void removeSymbolFromCell(int cellNo) {
        this.cells[cellNo - 1] = Symbol.EMPTY;
    }

    public boolean isEmptyCell(int i) {
        return this.cells[i - 1].isEmpty();
    }

    public boolean isAnyMoveLeft() {
        for (int i = 0; i < this.size(); i++) {
            if (this.cells[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasGameWon() {
        return this.anyRowOrColumnContainsSameSymbol() ||
            this.anyDiagonalContainsSameSymbol();
    }

    private boolean anyDiagonalContainsSameSymbol() {
        int[] diagonal1 = new int[this.boardSize];
        int[] diagonal2 = new int[this.boardSize];
        for (int i = 0; i < this.boardSize; i++) {
            diagonal1[i] = (i * this.boardSize) + (i + 1);
            diagonal2[i] = this.boardSize * (i + 1) - i;
        }
        return doesEveryCellContainSame(diagonal1) || doesEveryCellContainSame(diagonal2);
    }

    private boolean anyRowOrColumnContainsSameSymbol() {
        for (int i = 0; i < this.boardSize; i++) {
            int[] col = getBoardColumn(i);
            int[] row = getBoardRow(i);
            if (doesEveryCellContainSame(col) || doesEveryCellContainSame(row)) return true;
        }
        return false;
    }

    private int[] getBoardColumn(int i) {
        int[] row = new int[this.boardSize];
        for (int j = 0; j < this.boardSize; j++) {
            row[j] = this.boardSize * j + i + 1;
        }
        return row;
    }

    private int[] getBoardRow(int i) {
        int[] col = new int[this.boardSize];
        for (int j = 0; j < this.boardSize; j++) {
            col[j] = this.boardSize * i + j + 1;
        }
        return col;
    }

    private boolean doesEveryCellContainSame(int[] cellNo) {
        Symbol symbol = this.cells[cellNo[0] - 1];
        return Arrays.stream(cellNo).allMatch((key) -> {
            Symbol currentSymbol = this.cells[key - 1];
            return !currentSymbol.isEmpty() && currentSymbol == symbol;
        });
    }
}
