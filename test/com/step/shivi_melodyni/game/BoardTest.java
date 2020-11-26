package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.BoardDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void shouldGiveBoardDTO() {
        Board board = new Board(2);
        BoardDTO boardDTO = new BoardDTO(new char[2][2]);
        assertEquals(boardDTO, board.toDTO());
    }
}