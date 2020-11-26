package com.step.shivi_melodyni.presenter;

import com.step.shivi_melodyni.dto.BoardDTO;
import com.step.shivi_melodyni.dto.PlayerDTO;
import com.step.shivi_melodyni.io.Reader;
import com.step.shivi_melodyni.io.Writer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConsolePresenterTest {
    @Test
    public void shouldPresentCellNoOnEmptyTicTacToeBoard() {
        Writer writer = mock(Writer.class);
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, () -> "4");
        BoardDTO boardDTO = new BoardDTO(new char[2][2]);

        consolePresenter.presentBoard(boardDTO);

        verify(writer).write("1  2  \n3  4  \n");
    }

    @Test
    public void shouldPresentSymbolOnTicTacToeBoardIfCellIsPlayed() {
        Writer writer = mock(Writer.class);
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, () -> "4");
        char[][] cells = new char[2][2];
        cells[0][1] = 'X';
        BoardDTO boardDTO = new BoardDTO(cells);

        consolePresenter.presentBoard(boardDTO);

        verify(writer).write("1  X  \n3  4  \n");
    }

    @Test
    public void shouldPresentBothPlayerNamesAndTheirSymbol() {
        Writer writer = mock(Writer.class);
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, () -> "4");

        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        consolePresenter.presentPlayer(player1DTO, player2DTO);

        verify(writer).write("---------------------\nRamesh:X Suresh:O\n");
    }

    @Test
    public void shouldGetPlayersMove() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);

        when(reader.readLine()).thenReturn("1");

        ConsolePresenter consolePresenter = new ConsolePresenter(writer, reader);
        int playerMove = consolePresenter.getPlayerMove(new PlayerDTO("Ramesh", 'X'), 9);

        verify(writer).write("Ramesh's turn. Please enter the cell number > ");
        assertEquals(1, playerMove);
    }

    @Test
    public void shouldAskPlayerMoveAgainAfterPresentingInvalidCellError() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);

        when(reader.readLine()).thenReturn("A").thenReturn("1");

        ConsolePresenter consolePresenter = new ConsolePresenter(writer, reader);
        int playerMove = consolePresenter.getPlayerMove(new PlayerDTO("Ramesh", 'X'), 9);

        verify(writer, times(2)).write("Ramesh's turn. Please enter the cell number > ");
        verify(writer).write("*ERROR* Invalid Cell A, Please provide a vacant cell between 1-9\n");
        verify(reader, times(2)).readLine();
        assertEquals(1, playerMove);
    }

    @Test
    public void shouldPresentCellNotVacantError() {
        Writer writer = mock(Writer.class);

        ConsolePresenter consolePresenter = new ConsolePresenter(writer, ()->"1");

        consolePresenter.presentCellNotVacantError(1, 9);

        verify(writer).write("*ERROR* Cell 1 is Not Vacant, Please provide a vacant cell between 1-9\n");
    }

    @Test
    public void shouldDeclareTheWinner() {
        Writer writer = mock(Writer.class);
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, ()->"1");

        consolePresenter.declareWinner(new PlayerDTO("Ramesh", 'X'));

        verify(writer).write("Ramesh wins\n");
    }

    @Test
    public void shouldDeclareGameDraw() {
        Writer writer = mock(Writer.class);
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, ()->"1");

        consolePresenter.declareGameDraw();

        verify(writer).write("Game ended in a Draw\n");
    }
}