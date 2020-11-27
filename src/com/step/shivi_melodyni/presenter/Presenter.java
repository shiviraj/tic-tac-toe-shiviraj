package com.step.shivi_melodyni.presenter;

import com.step.shivi_melodyni.dto.BoardDTO;
import com.step.shivi_melodyni.dto.PlayerDTO;

public interface Presenter {
    void presentBoard(BoardDTO boardDTO);
    void presentPlayers(PlayerDTO player1DTO, PlayerDTO player2DTO);
    int getPlayerMove(PlayerDTO currentPlayerDTO, int size);
    void declareGameDraw();
    void declareWinner(PlayerDTO winnerDTO);
    void presentCellNotVacantError(int cellNo, int size);
}