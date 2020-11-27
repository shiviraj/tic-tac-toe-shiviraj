package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.BoardDTO;

import java.util.TreeMap;

public class Board {
    private final int boardSize;

    private final TreeMap<Integer, Character> cells;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cells = new TreeMap<>();
    }

    public int size() {
        return this.boardSize;
    }

    public BoardDTO toDTO() {
        TreeMap<Integer,Character> treeMap = new TreeMap<>(this.cells);
        return new BoardDTO(treeMap, this.size());
    }


    public void place(int cellNo, char symbol) {
        this.cells.put(cellNo, symbol);
    }

    public boolean isValidMove(int cellNo) {
        if (cellNo < 1 || cellNo > (this.size() * this.size())) {
            return false;
        }
        return !this.cells.containsKey(cellNo);
    }

    public boolean anyDiagonalContainsSameSymbol() {
        char[] diagonal1 = new char[this.size()];
        char[] diagonal2 = new char[this.size()];
        for (int i = 0; i < this.size(); i++) {
            int cellNo = (i * size() ) + (i + 1);
            diagonal1[i] = this.cells.getOrDefault(cellNo,'\u0000');
            int cellNo2 = size() * (i + 1) - i;
            diagonal2[i] = this.cells.getOrDefault(cellNo2,'\u0000');
        }
        return every(diagonal1) || every(diagonal2);
    }

    public boolean anyColumnContainsSameSymbol() {
        for (int i = 1; i <= this.size(); i++) {
            char[] col = getBoardColumn(i);
            if (every(col)) return true;
        }
        return false;
    }

    private char[] getBoardColumn(int i) {
        char[] col = new char[this.size()];
        for (int j = 0; j < this.size(); j++) {
            int cellNo = size() * j + i;
            col[j] = this.cells.getOrDefault(cellNo, '\u0000');
        }
        return col;
    }

    public boolean anyRowsContainsSameSymbol() {
        for (int i = 0; i < this.size(); i++) {
            char[] col = getBoardRow(i);
            if (every(col)) return true;
        }
        return false;
    }

    private char[] getBoardRow(int i) {
        char[] col = new char[this.size()];
        for (int j = 0; j < this.size(); j++) {
            int cellNo = size() * i + j + 1;
            col[j] = this.cells.getOrDefault(cellNo, '\u0000');
        }
        return col;
    }

    private boolean every(char[] symbol) {
        for (char c : symbol) {
            if (c != symbol[0] || c == '\u0000') return false;
        }
        return true;
    }

}
