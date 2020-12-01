package com.step.shivi_melodyni.ttt.presenter;

import com.step.shivi_melodyni.ttt.dto.BoardDTO;
import com.step.shivi_melodyni.ttt.dto.GameDTO;
import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.io.Reader;
import com.step.shivi_melodyni.ttt.io.Writer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConsolePresenterTest {
    @Test
    public void shouldPresentGameAndGetPlayerMove() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);
        when(reader.readLine()).thenReturn("2");
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, reader);

        char[] cells = new char[4];
        cells[0] = 'X';
        BoardDTO boardDTO = new BoardDTO(cells);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);
        int playerMove = consolePresenter.presentGameAndGetPlayerMove(gameDTO);

        verify(writer).write("---------------------\nRamesh:X Suresh:O\n");
        verify(writer).write("Ramesh's turn. Please enter the cell number > ");
        verify(writer).write("X  2  \n3  4  \n");

        assertEquals(2, playerMove);
    }

    @Test
    public void shouldAskPlayerMoveAgainAfterPresentingInvalidCellError() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);
        when(reader.readLine()).thenReturn("A", "99", "2");

        char[] cells = new char[9];
        cells[0] = 'X';
        BoardDTO boardDTO = new BoardDTO(cells);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);

        ConsolePresenter consolePresenter = new ConsolePresenter(writer, reader);
        int playerMove = consolePresenter.presentGameAndGetPlayerMove(gameDTO);

        verify(writer, times(3)).write("Ramesh's turn. Please enter the cell number > ");
        verify(writer).write("*ERROR* Invalid Cell A, Please provide a vacant cell between 1-9\n");
        verify(writer).write("*ERROR* Invalid Cell 99, Please provide a vacant cell between 1-9\n");
        verify(reader, times(3)).readLine();
        assertEquals(2, playerMove);
    }

    @Test
    public void shouldPresentCellNotVacantErrorAndGetPlayerMove() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);
        when(reader.readLine()).thenReturn("2");

        char[] cells = new char[9];
        cells[0] = 'X';
        BoardDTO boardDTO = new BoardDTO(cells);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);

        ConsolePresenter consolePresenter = new ConsolePresenter(writer, reader);
        int playerMove = consolePresenter.presentCellNotVacantErrorAndGetPlayerMove(gameDTO, 1);

        verify(writer).write("*ERROR* Cell 1 is Not Vacant, Please provide a vacant cell between 1-9\n");
        verify(writer).write("Ramesh's turn. Please enter the cell number > ");

        assertEquals(2, playerMove);
    }

    @Test
    public void shouldPresentBoardAndDeclareGameDraw() {
        Writer writer = mock(Writer.class);

        char[] cells = {
            'X', 'O', 'X',
            'O', 'X', 'X',
            'O', 'X', 'O'};

        BoardDTO boardDTO = new BoardDTO(cells);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);

        ConsolePresenter consolePresenter = new ConsolePresenter(writer, () -> "2");
        consolePresenter.declareGameDraw(gameDTO);

        verify(writer).write("X  O  X  \nO  X  X  \nO  X  O  \n");
        verify(writer).write("Game ended in a Draw\n");
    }

    @Test
    public void shouldPresentBoardAndWinner() {
        Writer writer = mock(Writer.class);

        char[] cells = new char[9];
        cells[0] = 'X';
        cells[3] = 'O';
        cells[1] = 'X';
        cells[4] = 'O';
        cells[2] = 'X';

        BoardDTO boardDTO = new BoardDTO(cells);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);

        ConsolePresenter consolePresenter = new ConsolePresenter(writer, () -> "2");
        consolePresenter.declareWinner(player1DTO, gameDTO);

        verify(writer).write("X  X  X  \nO  O  6  \n7  8  9  \n");
        verify(writer).write("Ramesh wins\n");
    }

}