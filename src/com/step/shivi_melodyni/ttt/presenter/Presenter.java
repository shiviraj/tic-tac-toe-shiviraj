package com.step.shivi_melodyni.ttt.presenter;

import com.step.shivi_melodyni.ttt.dto.GameDTO;
import com.step.shivi_melodyni.ttt.dto.PlayerDTO;

public interface Presenter {
    int presentGameAndGetPlayerMove(GameDTO gameDTO);
    void declareGameDraw(GameDTO gameDTO);
    void declareWinner(PlayerDTO winnerDTO, GameDTO gameDTO);
    int presentCellNotVacantErrorAndGetPlayerMove(GameDTO gameDTO, int cellNo);
}