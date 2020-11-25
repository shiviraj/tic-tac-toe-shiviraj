package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.GameDTO;
import com.step.shivi_melodyni.presenter.ConsolePresenter;

import java.util.HashMap;

public class Game {
    private final HashMap<String, String> players;
    private final Board board;

    public Game(String player1, String player2, int boardSize) {
        this.players = new HashMap<>(2);
        this.players.put(player1,"X");
        this.players.put(player2,"O");
        this.board = new Board(boardSize);
    }

    public void run(ConsolePresenter presenter) {
        presenter.present(this.toDTO());
    }

    private GameDTO toDTO() {
        return new GameDTO(this.board.toDTO());
    }
}
