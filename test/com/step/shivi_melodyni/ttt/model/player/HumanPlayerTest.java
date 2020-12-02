package com.step.shivi_melodyni.ttt.model.player;

import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {
    @Test
    public void shouldGivePlayerDTO() {
        HumanPlayer HumanPlayer = new HumanPlayer("Ramesh", 'X');

        PlayerDTO playerDTO = new PlayerDTO("Ramesh", 'X');
        assertEquals(playerDTO, HumanPlayer.toDTO());
    }
}