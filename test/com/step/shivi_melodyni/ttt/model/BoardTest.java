package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.dto.BoardDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void shouldGiveBoardDTO() {
        Board board = new Board(2);
        BoardDTO boardDTO = new BoardDTO(new char[4]);
        assertEquals(boardDTO, board.toDTO());
    }

    @Test
    public void shouldPlaceTheSymbolAtGivenCellNo() {
        Board board = new Board(2);
        assertTrue(board.place(1, 'X'));

    }

    @Test
    public void shouldNotPlaceTheSymbolIfCellIsNotVacant() {
        Board board = new Board(2);
        board.place(1, 'X');
        assertFalse(board.place(1, 'O'));
    }

    @Test
    public void shouldNotPlaceTheSymbolIfCellNoIsOutOfRange() {
        Board board = new Board(2);
        assertFalse(board.place(10, 'X'));
    }

    @Test
    public void shouldGiveSizeOfBoard() {
        Board board = new Board(2);
        assertEquals(4, board.size());
    }

    @Test
    public void shouldGiveTrueIfFirstRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1, 'X');
        board.place(2, 'X');
        board.place(3, 'X');
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfSecondRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(4, 'X');
        board.place(5, 'X');
        board.place(6, 'X');
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfThirdRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(7, 'O');
        board.place(8, 'O');
        board.place(9, 'O');
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfFirstColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1, 'O');
        board.place(4, 'O');
        board.place(7, 'O');
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfSecondColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(2, 'O');
        board.place(5, 'O');
        board.place(8, 'O');
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfThirdColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(3, 'O');
        board.place(6, 'O');
        board.place(9, 'O');
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfDiagonalHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1, 'O');
        board.place(5, 'O');
        board.place(9, 'O');
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfReverseDiagonalHaveSameSymbols() {
        Board board = new Board(3);
        board.place(3, 'O');
        board.place(5, 'O');
        board.place(7, 'O');
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldCloneTheBoard() {
        Board board = new Board(3);
        board.place(3, 'O');
        board.place(5, 'O');
        BoardDTO boardDTO = board.toDTO();

        assertEquals(boardDTO, board.cloneBoard().toDTO());
    }

    @Test
    public void shouldGiveTrueIfCellIsEmpty() {
        Board board = new Board(2);
        assertTrue(board.isEmptyCell(1));
    }

    @Test
    public void shouldGiveFalseIfCellIsNotEmpty() {
        Board board = new Board(2);
        board.place(1, 'X');
        assertFalse(board.isEmptyCell(1));
    }

    @Test
    public void shouldRemoveSymbolFromGivenCellNo() {
        Board board = new Board(2);
        board.place(1, 'X');
        assertFalse(board.isEmptyCell(1));
        board.removeSymbolFromCell(1);
        assertTrue(board.isEmptyCell(1));
    }

    @Test
    public void shouldGiveTrueIfAnyMoveIsLeft() {
        Board board = new Board(2);
        assertTrue(board.isAnyMoveLeft());
    }

    @Test
    public void shouldGiveFalseIfNoMoveLeft() {
        Board board = new Board(2);
        board.place(1, 'X');
        board.place(2, 'O');
        board.place(3, 'O');
        board.place(4, 'X');
        assertFalse(board.isAnyMoveLeft());
    }
}