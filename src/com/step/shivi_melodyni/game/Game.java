package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.presenter.ConsolePresenter;

import java.util.HashMap;
import java.util.Iterator;

public class Game {
    private final Board board;
    private final HashMap<Player, Player> nextPlayer;
    private Player currentPlayer;

    public Game(String player1Name, String player2Name, int boardSize) {
        this.nextPlayer = new HashMap<>(2);

        Player player1 = new Player(player1Name, 'X');
        Player player2 = new Player(player2Name, 'O');

        this.nextPlayer.put(player1, player2);
        this.nextPlayer.put(player2, player1);

        this.currentPlayer = player1;
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
            if(winner != null){
                presenter.declareWinner(winner.toDTO());
                return;
            }
            this.currentPlayer = this.nextPlayer.get(this.currentPlayer);
            i++;
        }
        presenter.declareGameDraw();
    }

    private Player checkWinner() {
        if(this.board.hasGameWon()){
            return this.currentPlayer;
        }
        return null;
    }

    private int getPlayerMove(ConsolePresenter presenter) {
        int boardSize = this.board.size();
        int playerMove = presenter.getPlayerMove(this.currentPlayer.toDTO(), boardSize);
        if (!this.board.isValidMove(playerMove)) {
            presenter.presentCellNotVacantError(playerMove, boardSize);
            return getPlayerMove(presenter);
        }
        return playerMove;
    }

    private void presentPlayerAndBoard(ConsolePresenter presenter) {
        Iterator<Player> iterator = this.nextPlayer.keySet().iterator();
        Player player1 = iterator.next();
        Player player2 = iterator.next();
        presenter.presentPlayer(player1.toDTO(), player2.toDTO());
        presenter.presentBoard(this.board.toDTO());
    }

}
