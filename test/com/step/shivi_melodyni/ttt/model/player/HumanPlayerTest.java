package com.step.shivi_melodyni.ttt.model.player;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.model.Symbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {
    @Test
    public void shouldGivePlayerDTO() {
        HumanPlayer HumanPlayer = new HumanPlayer("Ramesh", Symbol.CROSS);
        PlayerDTO playerDTO = new PlayerDTO("Ramesh", Symbol.CROSS.toDTO());
        assertEquals(playerDTO, HumanPlayer.toDTO());
    }
}