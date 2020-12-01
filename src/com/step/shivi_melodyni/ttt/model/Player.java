package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.presenter.Presenter;

public class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public PlayerDTO toDTO() {
        return new PlayerDTO(this.name, this.symbol);
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void playMove(Board board, Presenter presenter) {
        int boardSize = board.size();
        int move = presenter.getPlayerMove(this.name, boardSize);
        boolean isPlaced = board.place(move, this.symbol);
        if (!isPlaced) {
            presenter.presentCellNotVacantError(move, boardSize);
            this.playMove(board, presenter);
        }
    }
}
