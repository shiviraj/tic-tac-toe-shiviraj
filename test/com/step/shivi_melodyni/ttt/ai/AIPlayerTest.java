package com.step.shivi_melodyni.ttt.ai;

import com.step.shivi_melodyni.ttt.dto.BoardDTO;
import com.step.shivi_melodyni.ttt.model.Board;
import com.step.shivi_melodyni.ttt.presenter.ConsolePresenter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AIPlayerTest {
    @Test
    public void shouldPlayBestMove() {
        AIPlayer aiPlayer = new AIPlayer();
        Board board = new Board(3);
        board.place(1, 'X');
        board.place(2, 'O');
        board.place(3, 'X');
        board.place(8, 'O');
        board.place(5, 'X');
        board.place(9, 'O');
        aiPlayer.playMove(board, new ConsolePresenter((s) -> {
        }, () -> "2"));

        BoardDTO boardDTO = new BoardDTO(new char[]{'X', 'O', 'X', '\u0000', 'X', '\u0000', 'O', 'O', 'O'});

        assertEquals(boardDTO, board.toDTO());

    }

    @Test
    public void shouldPlayBestMoveBasedOnCurrentSituation() {
        AIPlayer aiPlayer = new AIPlayer();
        Board board = new Board(3);
        board.place(4, 'X');
        board.place(2, 'O');
        board.place(5, 'X');
        board.place(6, 'O');
        board.place(8, 'X');
        board.place(9, 'O');
        aiPlayer.playMove(board, new ConsolePresenter((s) -> {
        }, () -> "2"));

        BoardDTO boardDTO = new BoardDTO(new char[]{'\u0000', 'O', 'O', 'X', 'X', 'O', '\u0000', 'X', 'O'});

        assertEquals(boardDTO, board.toDTO());
    }
}