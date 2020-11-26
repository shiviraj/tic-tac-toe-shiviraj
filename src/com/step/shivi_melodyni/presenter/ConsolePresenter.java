package com.step.shivi_melodyni.presenter;

import com.step.shivi_melodyni.dto.GameDTO;
import com.step.shivi_melodyni.io.Reader;
import com.step.shivi_melodyni.io.Writer;


public class ConsolePresenter{

    private final Writer writer;
    private final Reader reader;

    public ConsolePresenter(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public void present(GameDTO gameDTO) {
        this.writer.write(presentBoard(gameDTO));
    }

    private String presentBoard(GameDTO gameDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = gameDTO.getBoardDTO().length;
        int cellNo = 1;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char cellChar = gameDTO.getBoardDTO()[i][j];
                String cell = cellChar == '\u0000' ? Integer.toString(cellNo) : String.valueOf(cellChar);
                stringBuilder.append(cell).append("  ");
                cellNo++;
            }
            stringBuilder.append("\n");
        }
        return String.valueOf(stringBuilder);
    }
}
