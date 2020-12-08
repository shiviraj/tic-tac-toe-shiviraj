package com.step.shivi_melodyni.ttt.dto;

import com.step.shivi_melodyni.ttt.model.Symbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerDTOTest {
    @Test
    public void shouldGivePlayerName() {
        PlayerDTO playerDTO = new PlayerDTO("Ramesh", Symbol.CROSS.toDTO());
        assertEquals("Ramesh", playerDTO.getName());
    }

    @Test
    public void shouldGivePlayerSymbol() {
        PlayerDTO playerDTO = new PlayerDTO("Ramesh", Symbol.CROSS.toDTO());
        assertEquals('X', playerDTO.getSymbol());
    }
}