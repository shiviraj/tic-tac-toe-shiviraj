package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.dto.BoardDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void shouldGiveBoardDTO() {
        Board board = new Board(3);
        BoardDTO boardDTO = new BoardDTO(new char[9]);
        System.out.println( boardDTO.toString());
        assertEquals(boardDTO, board.toDTO());
    }

    @Test
    public void shouldPlaceTheSymbolAtGivenCellNo() {
        Board board = new Board(2);
        assertTrue(board.place(1, Symbol.CROSS));

    }

    @Test
    public void shouldNotPlaceTheSymbolIfCellIsNotVacant() {
        Board board = new Board(2);
        board.place(1, Symbol.CROSS);
        assertFalse(board.place(1, Symbol.ZERO));
    }

    @Test
    public void shouldNotPlaceTheSymbolIfCellNoIsOutOfRange() {
        Board board = new Board(2);
        assertFalse(board.place(10, Symbol.CROSS));
    }

    @Test
    public void shouldGiveSizeOfBoard() {
        Board board = new Board(2);
        assertEquals(4, board.size());
    }

    @Test
    public void shouldGiveTrueIfFirstRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1, Symbol.CROSS);
        board.place(2, Symbol.CROSS);
        board.place(3, Symbol.CROSS);
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfSecondRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(4, Symbol.CROSS);
        board.place(5, Symbol.CROSS);
        board.place(6, Symbol.CROSS);
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfThirdRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(7, Symbol.ZERO);
        board.place(8, Symbol.ZERO);
        board.place(9, Symbol.ZERO);
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfFirstColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1, Symbol.ZERO);
        board.place(4, Symbol.ZERO);
        board.place(7, Symbol.ZERO);
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfSecondColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(2, Symbol.ZERO);
        board.place(5, Symbol.ZERO);
        board.place(8, Symbol.ZERO);
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfThirdColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(3, Symbol.ZERO);
        board.place(6, Symbol.ZERO);
        board.place(9, Symbol.ZERO);
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfDiagonalHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1, Symbol.ZERO);
        board.place(5, Symbol.ZERO);
        board.place(9, Symbol.ZERO);
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldGiveTrueIfReverseDiagonalHaveSameSymbols() {
        Board board = new Board(3);
        board.place(3, Symbol.ZERO);
        board.place(5, Symbol.ZERO);
        board.place(7, Symbol.ZERO);
        assertTrue(board.hasGameWon());
    }

    @Test
    public void shouldCloneTheBoard() {
        Board board = new Board(3);
        board.place(3, Symbol.ZERO);
        board.place(5, Symbol.ZERO);
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
        board.place(1, Symbol.CROSS);
        assertFalse(board.isEmptyCell(1));
    }

    @Test
    public void shouldRemoveSymbolFromGivenCellNo() {
        Board board = new Board(2);
        board.place(1, Symbol.CROSS);
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
        board.place(1, Symbol.CROSS);
        board.place(2, Symbol.ZERO);
        board.place(3, Symbol.ZERO);
        board.place(4, Symbol.CROSS);
        assertFalse(board.isAnyMoveLeft());
    }
}