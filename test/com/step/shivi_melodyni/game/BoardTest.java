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

    @Test
    public void shouldPlaceTheSymbolAtGivenCellNo() {
        Board board = new Board(2);
        board.place(1,'X' );
        char[][] cells = new char[2][2];
        cells[0][0] = 'X';
        BoardDTO boardDTO = new BoardDTO(cells);
        assertEquals(boardDTO, board.toDTO());
    }

    @Test
    public void shouldGiveTrueIfCellNoIsVacant() {
        Board board = new Board(2);
        assertTrue(board.isValidMove(2));
    }

    @Test
    public void shouldGiveFalseIfCellNoIsNotVacant() {
        Board board = new Board(2);
        board.place(2, 'X');
        assertFalse(board.isValidMove(2));
    }

    @Test
    public void shouldGiveFalseIfCellNoIsInvalid() {
        Board board = new Board(2);
        assertFalse(board.isValidMove(15));
    }

    @Test
    public void shouldGiveSizeOfBoard() {
        Board board = new Board(2);
        assertEquals(4, board.size());
    }

    @Test
    public void shouldGiveTrueIfFirstRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1,'X');
        board.place(2,'X');
        board.place(3,'X');
        assertTrue(board.anyRowsContainsSameSymbol());
    }

    @Test
    public void shouldGiveTrueIfSecondRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(4,'X');
        board.place(5,'X');
        board.place(6,'X');
        assertTrue(board.anyRowsContainsSameSymbol());
    }

    @Test
    public void shouldGiveTrueIfThirdRowsHaveSameSymbols() {
        Board board = new Board(3);
        board.place(7, 'O');
        board.place(8, 'O');
        board.place(9, 'O');
        assertTrue(board.anyRowsContainsSameSymbol());
    }

    @Test
    public void shouldGiveTrueIfFirstColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1, 'O');
        board.place(4, 'O');
        board.place(7, 'O');
        assertTrue(board.anyColumnContainsSameSymbol());
    }    @Test
    public void shouldGiveTrueIfSecondColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(2, 'O');
        board.place(5, 'O');
        board.place(8, 'O');
        assertTrue(board.anyColumnContainsSameSymbol());
    }

    @Test
    public void shouldGiveTrueIfThirdColumnHaveSameSymbols() {
        Board board = new Board(3);
        board.place(3, 'O');
        board.place(6, 'O');
        board.place(9, 'O');
        assertTrue(board.anyColumnContainsSameSymbol());
    }

    @Test
    public void shouldGiveTrueIfDiagonalHaveSameSymbols() {
        Board board = new Board(3);
        board.place(1, 'O');
        board.place(5, 'O');
        board.place(9, 'O');
        assertTrue(board.anyDiagonalContainsSameSymbol());
    }

    @Test
    public void shouldGiveTrueIfReverseDiagonalHaveSameSymbols() {
        Board board = new Board(3);
        board.place(3, 'O');
        board.place(5, 'O');
        board.place(7, 'O');
        assertTrue(board.anyDiagonalContainsSameSymbol());
    }
}