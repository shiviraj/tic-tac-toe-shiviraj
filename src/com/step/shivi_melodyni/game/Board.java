package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.ai.VirtualGameBoard;
import com.step.shivi_melodyni.dto.BoardDTO;

import java.util.Arrays;
import java.util.TreeMap;

public class Board {
    private final int boardSize;
    protected final TreeMap<Integer, Character> cells;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cells = new TreeMap<>();
    }

    public int size() {
        return this.boardSize * this.boardSize;
    }

    public BoardDTO toDTO() {
        TreeMap<Integer, Character> treeMap = new TreeMap<>(this.cells);
        return new BoardDTO(treeMap, this.boardSize);
    }

    public VirtualGameBoard cloneBoard(){
        VirtualGameBoard board = new VirtualGameBoard(this.boardSize);
        this.cells.forEach(board::place);
        return board;
    }

    public void place(int cellNo, char symbol) {
        this.cells.put(cellNo, symbol);
    }

    public boolean isValidMove(int cellNo) {
        if (cellNo < 1 || cellNo > this.size()) {
            return false;
        }
        return !this.cells.containsKey(cellNo);
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
        char symbol = this.cells.getOrDefault(cellNo[0], '\u0000');
        return Arrays.stream(cellNo).allMatch((key)-> {
            char currentSymbol = this.cells.getOrDefault(key, '\u0000');
            return  currentSymbol != '\u0000' && currentSymbol == symbol;
        });
    }
}
