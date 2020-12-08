package com.step.shivi_melodyni.ttt.model.player;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.model.Board;
import com.step.shivi_melodyni.ttt.model.Symbol;
import com.step.shivi_melodyni.ttt.presenter.Presenter;

public class HumanPlayer implements Player {
    private final String name;
    private final Symbol symbol;

    public HumanPlayer(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public PlayerDTO toDTO() {
        return new PlayerDTO(this.name, this.symbol.toDTO());
    }

    @Override
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
