package com.step.shivi_melodyni.presenter;

import com.step.shivi_melodyni.dto.BoardDTO;
import com.step.shivi_melodyni.dto.GameDTO;
import com.step.shivi_melodyni.io.Writer;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsolePresenterTest {
    @Test
    public void shouldPresentTicTacToeBoard() {
        Writer writer = mock(Writer.class);
        ConsolePresenter consolePresenter = new ConsolePresenter(writer, () -> 4);
        GameDTO gameDTO = new GameDTO(new BoardDTO(new String[][]{{"1", "2"}, {"3", "4"}}));

        consolePresenter.present(gameDTO);

        String expected = "1  2  \n3  4  \n";
        verify(writer).write(expected);

    }
}