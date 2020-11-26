package com.step.shivi_melodyni.presenter;

import com.step.shivi_melodyni.dto.BoardDTO;
import com.step.shivi_melodyni.dto.PlayerDTO;
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

    public void presentPlayer(PlayerDTO player1DTO, PlayerDTO player2DTO) {
        String divider = "---------------------";
        String player = String.format("%s\n%s:%c %s:%c\n", divider , player1DTO.getName(), player1DTO.getSymbol(),
            player2DTO.getName(), player2DTO.getSymbol());
        this.writer.write(player);
    }

    public int getPlayerMove(PlayerDTO currentPlayerDTO) {
        String promptMsg = String.format("%s's turn. Please enter the cell number > ", currentPlayerDTO.getName());
        this.writer.write(promptMsg);
        return this.reader.readInt();
    }
}
