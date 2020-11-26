package com.step.shivi_melodyni.presenter;

import com.step.shivi_melodyni.dto.BoardDTO;
import com.step.shivi_melodyni.io.Reader;
import com.step.shivi_melodyni.io.Writer;


public class ConsolePresenter{
    private final Writer writer;
    private final Reader reader;

    public ConsolePresenter(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public void presentBoard(BoardDTO boardDTO) {
        char [][] board = boardDTO.getCells();
        StringBuilder stringBuilder = new StringBuilder();
        int cellNo = 1;

        for (char[] row : board) {
            for (char cellChar : row) {
                if (cellChar == '\u0000') {
                    stringBuilder.append(cellNo).append("  ");
                } else {
                    stringBuilder.append(cellChar).append("  ");
                }
                cellNo++;
            }
            stringBuilder.append("\n");
        }
        this.writer.write(String.valueOf(stringBuilder));
    }
}