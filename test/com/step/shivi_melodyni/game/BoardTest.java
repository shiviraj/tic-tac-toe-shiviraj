package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.dto.BoardDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void shouldGiveBoardDTO() {
        Board board = new Board(2);
        BoardDTO boardDTO = new BoardDTO(new String[][]{{"1", "2"}, {"3", "4"}});
        assertEquals(boardDTO, board.toDTO());
    }
}