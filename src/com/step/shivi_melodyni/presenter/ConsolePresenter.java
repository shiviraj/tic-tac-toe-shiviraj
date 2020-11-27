package com.step.shivi_melodyni.presenter;

import com.step.shivi_melodyni.dto.BoardDTO;
import com.step.shivi_melodyni.dto.PlayerDTO;
import com.step.shivi_melodyni.io.Reader;
import com.step.shivi_melodyni.io.Writer;

import java.util.TreeMap;

public class ConsolePresenter {
    private final Writer writer;
    private final Reader reader;

    public ConsolePresenter(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public void presentBoard(BoardDTO boardDTO) {
        TreeMap<Integer, Character> board = boardDTO.getCells();
        StringBuilder stringBuilder = new StringBuilder();
        int size = boardDTO.getSize();
        for (int i = 1; i <= size * size; i++) {
            if(board.containsKey(i)){
                stringBuilder.append(board.get(i)).append("  ");
            }else{
                stringBuilder.append(i).append("  ");
            }
            stringBuilder.append(i % size == 0 ? "\n" : "");
        }
        this.writer.write(String.valueOf(stringBuilder));
    }

    public void presentPlayer(PlayerDTO player1DTO, PlayerDTO player2DTO) {
        String divider = "---------------------";
        String player = String.format("%s\n%s:%c %s:%c\n", divider, player1DTO.getName(), player1DTO.getSymbol(),
            player2DTO.getName(), player2DTO.getSymbol());
        this.writer.write(player);
    }

    public int getPlayerMove(PlayerDTO currentPlayerDTO, int size) {
        String promptMsg = String.format("%s's turn. Please enter the cell number > ", currentPlayerDTO.getName());
        this.writer.write(promptMsg);
        String input = this.reader.readLine();
        try {
            return new Integer(input);
        } catch (NumberFormatException e) {
            String invalidCellError = String.format("*ERROR* Invalid Cell %s, Please provide a vacant cell between " +
                "1-%d\n", input, size * size);
            this.writer.write(invalidCellError);
            return getPlayerMove(currentPlayerDTO, size);
        }
    }

    public void presentCellNotVacantError(int cellNo, int size) {
        this.writer.write(String.format("*ERROR* Cell %d is Not Vacant, Please provide a vacant cell between 1-%d\n",
            cellNo,  size * size));
    }

    public void declareGameDraw() {
        this.writer.write("Game ended in a Draw\n");
    }

    public void declareWinner(PlayerDTO winnerDTO) {
        this.writer.write(String.format("%s wins\n", winnerDTO.getName()));
    }
}
