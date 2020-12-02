package com.step.shivi_melodyni.ttt.presenter;

import com.step.shivi_melodyni.ttt.dto.GameDTO;
import com.step.shivi_melodyni.ttt.dto.PlayerDTO;

public interface Presenter {
    void declareGameDraw(GameDTO gameDTO);

    void declareWinner(PlayerDTO winnerDTO, GameDTO gameDTO);

    void presentGame(GameDTO toDTO);

    int getPlayerMove(String name, int boardSize);

    void presentComputerMove(String name, int move);

    void presentCellNotVacantError(int move, int boardSize);
}