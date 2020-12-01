package com.step.shivi_melodyni.ttt.ai;

import com.step.shivi_melodyni.ttt.model.Board;

public class VirtualGameBoard extends Board {
    public VirtualGameBoard(int boardSize) {
        super(boardSize);
    }

    public boolean isAnyMoveLeft() {
        for (int i = 1; i <= this.size(); i++) {
            if (!this.cells.containsKey(i)) {
                return true;
            }
        }
        return false;
    }

    public void removeSymbolFromCell(int cellNo){
        this.cells.remove(cellNo);
    }
}
