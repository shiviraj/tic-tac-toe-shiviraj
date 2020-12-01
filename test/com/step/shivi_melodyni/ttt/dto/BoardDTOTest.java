package com.step.shivi_melodyni.ttt.dto;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BoardDTOTest {
    @Test
    public void shouldEquatesTwoEqualBoardDTO() {
        BoardDTO board1DTO = new BoardDTO(new char[2]);
        BoardDTO board2DTO = new BoardDTO(new char[2]);
        assertEquals(board1DTO, board2DTO);
    }

    @Test
    public void shouldGiveCellsOfBoard() {
        BoardDTO board1DTO = new BoardDTO(new char[9]);
        assertArrayEquals(new char[9], board1DTO.getCells());
    }
}