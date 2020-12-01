package com.step.shivi_melodyni.ttt.ai;

import com.step.shivi_melodyni.ttt.model.Board;
import com.step.shivi_melodyni.ttt.model.Player;

public class AIPlayer extends Player {
    public AIPlayer(char symbol) {
        super("Computer", symbol);
    }

    public int playBestMove(Board board, Player opponent) {
        VirtualGameBoard virtualBoard = board.createVirtualBoard();
        return this.findBestMove(virtualBoard, opponent);
    }

    private int findBestMove(VirtualGameBoard virtualBoard, Player opponent) {
        int bestScore = -1000;
        int bestMove = -1;

        for (int i = 1; i <= virtualBoard.size(); i++) {
            if (virtualBoard.isValidMove(i)) {
                virtualBoard.place(i, this.getSymbol());
                int score = this.minimax(virtualBoard, false, opponent);
                virtualBoard.removeSymbolFromCell(i);
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    private int minimax(VirtualGameBoard virtualBoard, boolean isMaximizing, Player opponent) {
        if (virtualBoard.anyRowOrColumnContainsSameSymbol() || virtualBoard.anyDiagonalContainsSameSymbol()) {
            return isMaximizing ? -1 : 1;
        }
        if (!virtualBoard.isAnyMoveLeft()) {
            return 0;
        }

        int bestScore = -1000;
        if (isMaximizing) {
            for (int i = 1; i <= virtualBoard.size(); i++) {
                if (virtualBoard.isValidMove(i)) {
                    virtualBoard.place(i, this.getSymbol());
                    int score = this.minimax(virtualBoard, false, opponent);
                    virtualBoard.removeSymbolFromCell(i);
                    bestScore = Math.max(score, bestScore);
                }
            }
        } else {
            bestScore = 1000;
            for (int i = 1; i <= virtualBoard.size(); i++) {
                if (virtualBoard.isValidMove(i)) {
                    virtualBoard.place(i, opponent.getSymbol());
                    int score = this.minimax(virtualBoard, true, opponent);
                    virtualBoard.removeSymbolFromCell(i);
                    bestScore = Math.min(score, bestScore);
                }
            }
        }
        return bestScore;
    }
}
