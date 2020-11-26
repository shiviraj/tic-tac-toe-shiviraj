package com.step.shivi_melodyni.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerDTOTest {
    @Test
    public void shouldGivePlayerName() {
        PlayerDTO playerDTO = new PlayerDTO("Ramesh", 'X');
        assertEquals("Ramesh", playerDTO.getName());
    }

    @Test
    public void shouldGivePlayerSymbol() {
        PlayerDTO playerDTO = new PlayerDTO("Ramesh", 'X');
        assertEquals('X', playerDTO.getSymbol());
    }
}