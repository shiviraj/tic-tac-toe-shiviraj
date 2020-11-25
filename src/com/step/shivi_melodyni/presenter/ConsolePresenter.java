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
        StringBuilder stringBuilder = new StringBuilder("");
        int length = gameDTO.getBoardDTO().length;
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                stringBuilder.append(gameDTO.getBoardDTO()[i][j]).append("  ");
            }
            stringBuilder.append("\n");
        }

        this.writer.write(String.valueOf(stringBuilder));
    }
}
