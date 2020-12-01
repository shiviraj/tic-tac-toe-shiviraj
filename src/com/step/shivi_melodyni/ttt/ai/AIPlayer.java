package com.step.shivi_melodyni.ttt.ai;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.model.Board;
import com.step.shivi_melodyni.ttt.model.player.Player;
import com.step.shivi_melodyni.ttt.presenter.Presenter;

public class AIPlayer implements Player {
    private final char symbol = 'O';

    @Override
    public PlayerDTO toDTO() {
        return new PlayerDTO("Computer", symbol);
    }

    @Override
    public void playMove(Board board, Presenter presenter) {
        VirtualGameBoard virtualBoard = board.createVirtualBoard();
        int move = this.findBestMove(virtualBoard);
        board.place(move, this.symbol);
    }

    private int findBestMove(VirtualGameBoard virtualBoard) {
        int bestScore = -1000;
        int bestMove = -1;

        for (int i = 1; i <= virtualBoard.size(); i++) {
            if (virtualBoard.isValidMove(i)) {
                virtualBoard.place(i, this.symbol);
                int score = this.minimax(virtualBoard, false);
                virtualBoard.removeSymbolFromCell(i);
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    private int minimax(VirtualGameBoard virtualBoard, boolean isMaximizing) {
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
                    virtualBoard.place(i, this.symbol);
                    int score = this.minimax(virtualBoard, false);
                    virtualBoard.removeSymbolFromCell(i);
                    bestScore = Math.max(score, bestScore);
                }
            }
        } else {
            bestScore = 1000;
            for (int i = 1; i <= virtualBoard.size(); i++) {
                if (virtualBoard.isValidMove(i)) {
                    virtualBoard.place(i, 'X');
                    int score = this.minimax(virtualBoard, true);
                    virtualBoard.removeSymbolFromCell(i);
                    bestScore = Math.min(score, bestScore);
                }
            }
        }
        return bestScore;
    }
}
