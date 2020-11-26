package com.step.shivi_melodyni.game;

import com.step.shivi_melodyni.io.Reader;
import com.step.shivi_melodyni.io.Writer;
import com.step.shivi_melodyni.presenter.ConsolePresenter;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class GameTest {
    @Test
    public void shouldRunTicTacToeGame() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);
        InOrder inOrder = inOrder(writer);

        when(reader.readLine()).thenReturn("1", "2", "3", "4");

        Game game = new Game("Ramesh", "Suresh", 2);
        game.run(new ConsolePresenter(writer, reader));


        inOrder.verify(writer).write("1  2  \n3  4  \n");
        inOrder.verify(writer).write("X  2  \n3  4  \n");
        inOrder.verify(writer).write("X  O  \n3  4  \n");
        inOrder.verify(writer).write("X  O  \nX  4  \n");
        inOrder.verify(writer).write("X  O  \nX  O  \n");
    }

    @Test
    public void shouldRunTicTacToeAndHandleInvalidMove() {
        Writer writer = mock(Writer.class);
        Reader reader = mock(Reader.class);
        InOrder inOrder = inOrder(writer);

        when(reader.readLine()).thenReturn("1", "1","2","3","4");

        Game game = new Game("Ramesh", "Suresh", 2);
        game.run(new ConsolePresenter(writer, reader));


        inOrder.verify(writer).write("1  2  \n3  4  \n");
        inOrder.verify(writer).write("X  2  \n3  4  \n");
        inOrder.verify(writer).write("*ERROR* Cell 1 is Not Vacant, Please provide a vacant cell between 1-4\n");
        inOrder.verify(writer).write("X  O  \n3  4  \n");
        inOrder.verify(writer).write("X  O  \nX  4  \n");
        inOrder.verify(writer).write("X  O  \nX  O  \n");
    }
}