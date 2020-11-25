package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.io.Writer;
import com.step.shivi_melodyni.presenter.ConsolePresenter;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {
    @Test
    public void shouldRunTicTacToeGame() {
        Writer writer = mock(Writer.class);
        Game game = new Game("Ramesh", "Suresh", 2);
        game.run(new ConsolePresenter(writer, ()->4));

        String expected = "1  2  \n3  4  \n";
        verify(writer).write(expected);
    }
}