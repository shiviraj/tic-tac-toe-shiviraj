package com.step.shivi_melodyni.dto;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

public class BoardDTOTest {
    @Test
    public void shouldEquatesTwoEqualBoardDTO() {
        BoardDTO board1DTO = new BoardDTO(new TreeMap<>(), 2);
        BoardDTO board2DTO = new BoardDTO(new TreeMap<>(), 2);
        assertEquals(board1DTO, board2DTO);
    }

    @Test
    public void shouldGiveCellsOfBoard() {
        BoardDTO board1DTO = new BoardDTO(new TreeMap<>(), 4);
        assertEquals(new TreeMap<>(), board1DTO.getCells());
    }
}