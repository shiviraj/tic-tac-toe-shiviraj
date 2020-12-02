package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.ai.VirtualGameBoard;
import com.step.shivi_melodyni.ttt.dto.BoardDTO;

import java.util.Arrays;

public class Board {
    private final int boardSize;
    protected final char[] cells;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cells = new char[boardSize * boardSize];
    }

    public int size() {
        return this.boardSize * this.boardSize;
    }

    public BoardDTO toDTO() {
        return new BoardDTO(this.cells.clone());
    }

    public VirtualGameBoard createVirtualBoard() {
        VirtualGameBoard board = new VirtualGameBoard(this.boardSize);
        for (int i = 0; i < this.cells.length; i++) {
            board.place(i + 1, this.cells[i]);
        }
        return board;
    }

    public boolean place(int cellNo, char symbol) {
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
        return this.cells[cellNo - 1] == '\u0000';
    }

    public boolean anyDiagonalContainsSameSymbol() {
        int[] diagonal1 = new int[this.boardSize];
        int[] diagonal2 = new int[this.boardSize];
        for (int i = 0; i < this.boardSize; i++) {
            diagonal1[i] = (i * this.boardSize) + (i + 1);
            diagonal2[i] = this.boardSize * (i + 1) - i;
        }
        return doesEveryCellContainSame(diagonal1) || doesEveryCellContainSame(diagonal2);
    }

    public boolean anyRowOrColumnContainsSameSymbol() {
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
        char symbol = this.cells[cellNo[0] - 1];
        return Arrays.stream(cellNo).allMatch((key) -> {
            char currentSymbol = this.cells[key - 1];
            return currentSymbol != '\u0000' && currentSymbol == symbol;
        });
    }

}
