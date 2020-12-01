package com.step.shivi_melodyni.ttt.model.player;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.model.Board;
import com.step.shivi_melodyni.ttt.presenter.Presenter;

public interface Player {
    PlayerDTO toDTO();

    void playMove(Board board, Presenter presenter);
}
