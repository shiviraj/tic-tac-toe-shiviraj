package com.step.shivi_melodyni.ai;

import com.step.shivi_melodyni.game.Board;
import com.step.shivi_melodyni.game.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class AIPlayerTest {
    @Test
    public void shouldPlayBestMove() {
        AIPlayer aiPlayer = new AIPlayer('O');
        Board board = new Board(3);
        board.place(1, 'X');
        board.place(2, 'O');
        board.place(3, 'X');
        board.place(8, 'O');
        board.place(5, 'X');
        board.place(9, 'O');
        int move = aiPlayer.playBestMove(board, new Player("Ramesh", 'X'));
        assertEquals(7, move);
    }
    @Test
    public void shouldPlayBestMoveBasedOnCurrentSituation() {
        AIPlayer aiPlayer = new AIPlayer('O');
        Board board = new Board(3);
        board.place(4, 'X');
        board.place(2, 'O');
        board.place(5, 'X');
        board.place(6, 'O');
        board.place(8, 'X');
        board.place(9, 'O');
        int move = aiPlayer.playBestMove(board, new Player("Ramesh", 'X'));
        assertEquals(3, move);
    }
}