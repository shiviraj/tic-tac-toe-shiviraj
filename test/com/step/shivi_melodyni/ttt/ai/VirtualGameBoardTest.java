package com.step.shivi_melodyni.ttt.ai;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VirtualGameBoardTest {
    @Test
    public void shouldRemoveSymbolFromGivenCellNo() {
        VirtualGameBoard board = new VirtualGameBoard(2);
        board.place(1, 'X');
        assertFalse(board.isValidMove(1));
        board.removeSymbolFromCell(1);
        assertTrue(board.isValidMove(1));
    }

    @Test
    public void shouldGiveTrueIfAnyMoveIsLeft() {
        VirtualGameBoard board = new VirtualGameBoard(2);
        assertTrue(board.isAnyMoveLeft());
    }

    @Test
    public void shouldGiveFalseIfNoMoveLeft() {
        VirtualGameBoard board = new VirtualGameBoard(2);
        board.place(1, 'X');
        board.place(2, 'O');
        board.place(3, 'O');
        board.place(4, 'X');
        assertFalse(board.isAnyMoveLeft());
    }
}