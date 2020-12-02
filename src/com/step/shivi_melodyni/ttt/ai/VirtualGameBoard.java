package com.step.shivi_melodyni.ttt.ai;

import com.step.shivi_melodyni.ttt.model.Board;

public class VirtualGameBoard extends Board {
    public VirtualGameBoard(int boardSize) {
        super(boardSize);
    }

    public void removeSymbolFromCell(int cellNo) {
        this.cells[cellNo - 1] = '\u0000';
    }

    public boolean isEmptyCell(int i) {
        return this.cells[i - 1] == '\u0000';
    }
}
