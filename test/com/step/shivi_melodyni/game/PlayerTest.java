package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.PlayerDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void shouldGivePlayerDTO() {
        Player player = new Player("Ramesh", 'X');

        PlayerDTO playerDTO = new PlayerDTO("Ramesh", 'X');
        assertEquals(playerDTO, player.toDTO());
    }
}