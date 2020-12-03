package com.step.shivi_melodyni.ttt.model.player;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.model.Board;
import com.step.shivi_melodyni.ttt.presenter.Presenter;

public class AIPlayer implements Player {
    private final char symbol = 'O';
    private final String name = "Computer";

    @Override
    public PlayerDTO toDTO() {
        return new PlayerDTO(this.name, this.symbol);
    }

    @Override
    public void playMove(Board board, Presenter presenter) {
        Board virtualBoard = board.cloneBoard();
        int move = this.findBestMove(virtualBoard);
        presenter.presentComputerMove(this.name, move);
        board.place(move, this.symbol);
    }

    private int findBestMove(Board virtualBoard) {
        int bestScore = -1000;
        int bestMove = -1;

        for (int i = 1; i <= virtualBoard.size(); i++) {
            if (virtualBoard.isEmptyCell(i)) {
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

    private int minimax(Board virtualBoard, boolean isMaximizing) {
        if (virtualBoard.anyRowOrColumnContainsSameSymbol() || virtualBoard.anyDiagonalContainsSameSymbol()) {
            return isMaximizing ? -1 : 1;
        }
        if (!virtualBoard.isAnyMoveLeft()) {
            return 0;
        }
        int bestScore = 1000;
        char symbol = 'X';
        if (isMaximizing) {
            bestScore = -1000;
            symbol = this.symbol;
        }
        for (int i = 1; i <= virtualBoard.size(); i++) {
            if (virtualBoard.isEmptyCell(i)) {
                virtualBoard.place(i, symbol);
                int score = this.minimax(virtualBoard, !isMaximizing);
                virtualBoard.removeSymbolFromCell(i);
                bestScore = isMaximizing ? Math.max(score, bestScore) : Math.min(score, bestScore);
            }
        }
        return bestScore;
    }
}
