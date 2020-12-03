package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.dto.GameDTO;
import com.step.shivi_melodyni.ttt.model.player.Player;
import com.step.shivi_melodyni.ttt.presenter.Presenter;
import com.step.shivi_melodyni.ttt.util.FractionGenerator;

public class Game {
    private final Board board;
    private final Player[] players;
    private int currentPlayerIndex;

    public Game(Player player, Player opponent, int boardSize) {
        this.players = new Player[]{player, opponent};
        this.board = new Board(boardSize);
    }

    public void run(Presenter presenter, FractionGenerator fractionGenerator) {
        this.currentPlayerIndex = fractionGenerator.generate(this.players.length);
        while (!this.isGameOver()) {
            presenter.presentGame(this.toDTO());
            Player currentPlayer = this.players[this.currentPlayerIndex];
            currentPlayer.playMove(board, presenter);
            this.currentPlayerIndex = getNextPlayerIndex();
        }
        declareGameResult(presenter);
    }

    private int getNextPlayerIndex() {
        return 1 - this.currentPlayerIndex;
    }

    private void declareGameResult(Presenter presenter) {
        if (hasGameWon()) {
            Player winner = this.players[getNextPlayerIndex()];
            presenter.declareWinner(winner.toDTO(), this.toDTO());
        } else {
            presenter.declareGameDraw(this.toDTO());
        }
    }

    private boolean isGameOver() {
        return this.hasGameWon() || !this.board.isAnyMoveLeft();
    }

    private boolean hasGameWon() {
        return this.board.anyRowOrColumnContainsSameSymbol() ||
            this.board.anyDiagonalContainsSameSymbol();
    }

    private GameDTO toDTO() {
        return new GameDTO(this.board.toDTO(), this.players[0].toDTO(), this.players[1].toDTO());
    }
}
