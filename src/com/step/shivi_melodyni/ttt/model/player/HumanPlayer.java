package com.step.shivi_melodyni.ttt.model.player;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.model.Board;
import com.step.shivi_melodyni.ttt.presenter.Presenter;

public class HumanPlayer implements Player {
    private final String name;
    private final char symbol;

    public HumanPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public PlayerDTO toDTO() {
        return new PlayerDTO(this.name, this.symbol);
    }

    @Override
    public void playMove(Board board, Presenter presenter) {
        int boardSize = board.size();
        int move = getPlayerMove(presenter, boardSize);
        boolean isPlaced = board.place(move, this.symbol);
        if (!isPlaced) {
            presenter.presentCellNotVacantError(move, boardSize);
            this.playMove(board, presenter);
        }
    }

    private int getPlayerMove(Presenter presenter, int boardSize) {
        return presenter.getPlayerMove(this.name, boardSize);
    }
}
