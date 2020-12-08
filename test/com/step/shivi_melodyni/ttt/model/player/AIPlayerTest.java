package com.step.shivi_melodyni.ttt.model.player;

import com.step.shivi_melodyni.ttt.dto.BoardDTO;
import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.io.Writer;
import com.step.shivi_melodyni.ttt.model.Board;
import com.step.shivi_melodyni.ttt.model.Symbol;
import com.step.shivi_melodyni.ttt.presenter.ConsolePresenter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AIPlayerTest {
    @Test
    public void shouldGivePlayerDTO() {
        AIPlayer aiPlayer = new AIPlayer();
        PlayerDTO playerDTO = new PlayerDTO("Computer", Symbol.ZERO.toDTO());
        assertEquals(playerDTO, aiPlayer.toDTO());

    }

    @Test
    public void shouldPlayBestMove() {
        Writer writer = mock(Writer.class);

        AIPlayer aiPlayer = new AIPlayer();
        Board board = new Board(3);
        board.place(1, Symbol.CROSS);
        board.place(2, Symbol.ZERO);
        board.place(3, Symbol.CROSS);
        board.place(8, Symbol.ZERO);
        board.place(5, Symbol.CROSS);
        board.place(9, Symbol.ZERO);
        aiPlayer.playMove(board, new ConsolePresenter(writer, () -> "2"));

        BoardDTO boardDTO = new BoardDTO(new char[]{'X', 'O', 'X', '\u0000', 'X', '\u0000', 'O', 'O', 'O'});

        verify(writer).write("Computer's turn. Please enter the cell number > 7\n");
        assertEquals(boardDTO, board.toDTO());

    }

    @Test
    public void shouldPlayBestMoveBasedOnCurrentSituation() {
        Writer writer = mock(Writer.class);

        AIPlayer aiPlayer = new AIPlayer();
        Board board = new Board(3);
        board.place(4, Symbol.CROSS);
        board.place(2, Symbol.ZERO);
        board.place(5, Symbol.CROSS);
        board.place(6, Symbol.ZERO);
        board.place(8, Symbol.CROSS);
        board.place(9, Symbol.ZERO);
        aiPlayer.playMove(board, new ConsolePresenter(writer, () -> "2"));

        BoardDTO boardDTO = new BoardDTO(new char[]{'\u0000', 'O', 'O', 'X', 'X', 'O', '\u0000', 'X', 'O'});
        verify(writer).write("Computer's turn. Please enter the cell number > 3\n");
        assertEquals(boardDTO, board.toDTO());
    }
}