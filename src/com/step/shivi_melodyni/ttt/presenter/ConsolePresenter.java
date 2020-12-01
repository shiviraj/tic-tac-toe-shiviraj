package com.step.shivi_melodyni.ttt.presenter;

import com.step.shivi_melodyni.ttt.dto.*;
import com.step.shivi_melodyni.ttt.io.*;

import java.util.TreeMap;

public class ConsolePresenter implements Presenter {
    private final Writer writer;
    private final Reader reader;

    public ConsolePresenter(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public int presentGameAndGetPlayerMove(GameDTO gameDTO) {
        BoardDTO boardDTO = gameDTO.getBoardDTO();
        presentPlayers(gameDTO.getPlayer1DTO(), gameDTO.getPlayer2DTO());
        presentBoard(boardDTO);
        return getPlayerMove(gameDTO.getCurrentPlayerDTO(), boardDTO.getSize());
    }

    @Override
    public int presentCellNotVacantErrorAndGetPlayerMove(GameDTO gameDTO, int cellNo) {
        PlayerDTO currentPlayerDTO = gameDTO.getCurrentPlayerDTO();
        int size = gameDTO.getBoardDTO().getSize() ;
        this.writer.write(String.format("*ERROR* Cell %d is Not Vacant, Please provide a vacant cell between 1-%d\n",
            cellNo, size * size));
        return getPlayerMove(currentPlayerDTO, size);
    }

    @Override
    public void declareGameDraw(GameDTO gameDTO) {
        this.presentBoard(gameDTO.getBoardDTO());
        this.writer.write("Game ended in a Draw\n");
    }

    @Override
    public void declareWinner(PlayerDTO winnerDTO, GameDTO gameDTO) {
        this.presentBoard(gameDTO.getBoardDTO());
        this.writer.write(String.format("%s wins\n", winnerDTO.getName()));
    }


    private void presentBoard(BoardDTO boardDTO) {
        TreeMap<Integer, Character> board = boardDTO.getCells();
        StringBuilder stringBuilder = new StringBuilder();
        int size = boardDTO.getSize();
        for (int i = 1; i <= size * size; i++) {
            if (board.containsKey(i)) {
                stringBuilder.append(board.get(i)).append("  ");
            } else {
                stringBuilder.append(i).append("  ");
            }
            stringBuilder.append(i % size == 0 ? "\n" : "");
        }
        this.writer.write(stringBuilder.toString());
    }


    private void presentPlayers(PlayerDTO player1DTO, PlayerDTO player2DTO) {
        String divider = "---------------------";
        String player = String.format("%s\n%s:%c %s:%c\n", divider, player1DTO.getName(), player1DTO.getSymbol(),
            player2DTO.getName(), player2DTO.getSymbol());
        this.writer.write(player);
    }

    private int getPlayerMove(PlayerDTO currentPlayerDTO, int size) {
        String promptMsg = String.format("%s's turn. Please enter the cell number > ", currentPlayerDTO.getName());
        this.writer.write(promptMsg);
        String input = this.reader.readLine();
        try {
            int playerMove = new Integer(input);
            if(playerMove < 1 || playerMove > size * size){
                throw new NumberFormatException();
            }
            return playerMove;
        } catch (NumberFormatException e) {
            String invalidCellError = String.format("*ERROR* Invalid Cell %s, Please provide a vacant cell between " +
                "1-%d\n", input, size * size);
            this.writer.write(invalidCellError);
            return getPlayerMove(currentPlayerDTO, size);
        }
    }

}
