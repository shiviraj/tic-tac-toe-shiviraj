package com.step.shivi_melodyni.ttt.model;

import com.step.shivi_melodyni.ttt.io.Reader;
import com.step.shivi_melodyni.ttt.io.Writer;
import com.step.shivi_melodyni.ttt.model.player.HumanPlayer;
import com.step.shivi_melodyni.ttt.presenter.ConsolePresenter;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class GameTest {
    @Test
    public void shouldRunTicTacToeGameResultingGameDraw() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);
        InOrder inOrder = inOrder(writer);

        when(reader.readLine()).thenReturn("1", "2", "3", "4", "5", "7", "6", "9", "8");

        Game game = new Game(new HumanPlayer("Ramesh", Symbol.CROSS), new HumanPlayer("Suresh", Symbol.ZERO), 3);
        game.run(new ConsolePresenter(writer, reader), limit->0);

        inOrder.verify(writer).write("1  2  3  \n4  5  6  \n7  8  9  \n");
        inOrder.verify(writer).write("X  2  3  \n4  5  6  \n7  8  9  \n");
        inOrder.verify(writer).write("X  O  3  \n4  5  6  \n7  8  9  \n");
        inOrder.verify(writer).write("X  O  X  \n4  5  6  \n7  8  9  \n");
        inOrder.verify(writer).write("X  O  X  \nO  5  6  \n7  8  9  \n");
        inOrder.verify(writer).write("X  O  X  \nO  X  6  \n7  8  9  \n");
        inOrder.verify(writer).write("X  O  X  \nO  X  6  \nO  8  9  \n");
        inOrder.verify(writer).write("X  O  X  \nO  X  X  \nO  8  9  \n");
        inOrder.verify(writer).write("X  O  X  \nO  X  X  \nO  8  O  \n");
        inOrder.verify(writer).write("X  O  X  \nO  X  X  \nO  X  O  \n");
        inOrder.verify(writer).write("Game ended in a Draw\n");
    }

    @Test
    public void shouldRunTicTacToeAndHandleInvalidMove() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);
        InOrder inOrder = inOrder(writer);

        when(reader.readLine()).thenReturn("1", "1", "2", "3");

        Game game = new Game(new HumanPlayer("Ramesh", Symbol.CROSS), new HumanPlayer("Suresh", Symbol.ZERO), 2);
        game.run(new ConsolePresenter(writer, reader),limit->0);

        inOrder.verify(writer).write("1  2  \n3  4  \n");
        inOrder.verify(writer).write("X  2  \n3  4  \n");
        inOrder.verify(writer).write("*ERROR* Cell 1 is Not Vacant, Please provide a vacant cell between 1-4\n");
        inOrder.verify(writer).write("X  O  \n3  4  \n");
        inOrder.verify(writer).write("X  O  \nX  4  \n");
        inOrder.verify(writer).write("Ramesh wins\n");
    }

    @Test
    public void shouldRunTicTacToeWithPlayer2PlayingFirstMove() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);
        InOrder inOrder = inOrder(writer);

        when(reader.readLine()).thenReturn("1", "2", "3");

        Game game = new Game(new HumanPlayer("Ramesh", Symbol.CROSS), new HumanPlayer("Suresh", Symbol.ZERO), 2);
        game.run(new ConsolePresenter(writer, reader),limit->1);

        inOrder.verify(writer).write("1  2  \n3  4  \n");
        inOrder.verify(writer).write("O  2  \n3  4  \n");
        inOrder.verify(writer).write("O  X  \n3  4  \n");
        inOrder.verify(writer).write("O  X  \nO  4  \n");
        inOrder.verify(writer).write("Suresh wins\n");
    }

}