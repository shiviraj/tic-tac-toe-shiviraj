package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.ai.AIPlayer;
import com.step.shivi_melodyni.presenter.ConsolePresenter;
import com.step.shivi_melodyni.presenter.Presenter;

import java.util.HashMap;
import java.util.Iterator;

public class Game {
    private final Board board;
    private final HashMap<Player, Player> nextPlayer;
    private final AIPlayer aiPlayer;
    private Player currentPlayer;

    public Game(Player player, Player opponent, int boardSize) {
        this.nextPlayer = new HashMap<>(2);
        this.aiPlayer = null;
        this.nextPlayer.put(player, opponent);
        this.nextPlayer.put(opponent, player);

        this.currentPlayer = player;
        this.board = new Board(boardSize);
    }

    public Game(Player player, AIPlayer aiPlayer, int boardSize) {
        this.nextPlayer = new HashMap<>(2);
        this.aiPlayer = aiPlayer;

        this.nextPlayer.put(player, aiPlayer);
        this.nextPlayer.put(aiPlayer, player);

        this.currentPlayer = player;
        this.board = new Board(boardSize);
    }


    public void run(ConsolePresenter presenter) {
        int i = 1;
        presentPlayerAndBoard(presenter);
        while (i <= this.board.size()) {
            int playerMove = getPlayerMove(presenter);
            this.board.place(playerMove, this.currentPlayer.getSymbol());
            presentPlayerAndBoard(presenter);
            Player winner = checkWinner();
            if (winner != null) {
                presenter.declareWinner(winner.toDTO());
                return;
            }
            this.currentPlayer = this.nextPlayer.get(this.currentPlayer);
            i++;
        }
        presenter.declareGameDraw();
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

    private int getPlayerMove(Presenter presenter) {
        if (this.currentPlayer == this.aiPlayer) {
            return this.aiPlayer.playBestMove(this.board, this.nextPlayer.get(aiPlayer));
        }
        int boardSize = this.board.size();
        int playerMove = presenter.getPlayerMove(this.currentPlayer.toDTO(), boardSize);
        if (!this.board.isValidMove(playerMove)) {
            presenter.presentCellNotVacantError(playerMove, boardSize);
            return getPlayerMove(presenter);
        }
        return playerMove;
    }

    private void presentPlayerAndBoard(Presenter presenter) {
        Iterator<Player> iterator = this.nextPlayer.keySet().iterator();
        Player opponent = iterator.next();
        Player aiPlayer = iterator.next();
        presenter.presentPlayers(opponent.toDTO(), aiPlayer.toDTO());
        presenter.presentBoard(this.board.toDTO());
    }

}
