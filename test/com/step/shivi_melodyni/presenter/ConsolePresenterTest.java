package com.step.shivi_melodyni.presenter;

import com.step.shivi_melodyni.dto.BoardDTO;
import com.step.shivi_melodyni.io.Writer;
import org.junit.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsolePresenterTest {
    @Test
    public void shouldPresentCellNoOnEmptyTicTacToeBoard() {
        Writer writer = mock(Writer.class);
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, () -> 4);
        BoardDTO boardDTO = new BoardDTO(new char[2][2]);

        consolePresenter.presentBoard(boardDTO);

        String expected = "1  2  \n3  4  \n";
        verify(writer).write(expected);
    }

    @Test
    public void shouldPresentSymbolOnTicTacToeBoardIfCellIsPlayed() {
        Writer writer = mock(Writer.class);
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, () -> 4);
        char[][] cells = new char[2][2];
        cells[0][1] = 'X';
        BoardDTO boardDTO = new BoardDTO(cells);

        consolePresenter.presentBoard(boardDTO);

        String expected = "1  X  \n3  4  \n";
        verify(writer).write(expected);
    }
}