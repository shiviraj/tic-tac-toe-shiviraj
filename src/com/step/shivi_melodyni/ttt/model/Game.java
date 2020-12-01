package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.dto.GameDTO;
import com.step.shivi_melodyni.ttt.model.player.Player;
import com.step.shivi_melodyni.ttt.presenter.Presenter;

import java.util.HashMap;
import java.util.Iterator;

public class Game {
    private final Board board;
    private final HashMap<Player, Player> nextPlayer;
    private Player currentPlayer;

    public Game(Player player, Player opponent, int boardSize) {
        this.nextPlayer = new HashMap<>(2);
        this.nextPlayer.put(player, opponent);
        this.nextPlayer.put(opponent, player);

        this.currentPlayer = player;
        this.board = new Board(boardSize);
    }

    public void run(Presenter presenter) {
        int i = 1;
        while (i <= this.board.size()) {
            presenter.presentGame(this.toDTO());
            this.currentPlayer.playMove(board, presenter);
            Player winner = checkWinner();
            if (winner != null) {
                presenter.declareWinner(winner.toDTO(), this.toDTO());
                return;
            }
            this.currentPlayer = this.nextPlayer.get(this.currentPlayer);
            i++;
        }
        presenter.declareGameDraw(this.toDTO());
    }

    private Player checkWinner() {
        if (this.hasGameWon()) {
            return this.currentPlayer;
        }
        return null;
    }

    private boolean hasGameWon() {
        return this.board.anyRowOrColumnContainsSameSymbol() ||
            this.board.anyDiagonalContainsSameSymbol();
    }

    private GameDTO toDTO() {
        Iterator<Player> iterator = this.nextPlayer.keySet().iterator();
        Player player1 = iterator.next();
        Player player2 = iterator.next();
        return new GameDTO(this.board.toDTO(), player1.toDTO(), player2.toDTO());
    }
}
