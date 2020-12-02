package com.step.shivi_melodyni.ttt.presenter;

import com.step.shivi_melodyni.ttt.dto.BoardDTO;
import com.step.shivi_melodyni.ttt.dto.GameDTO;
import com.step.shivi_melodyni.ttt.dto.PlayerDTO;
import com.step.shivi_melodyni.ttt.io.Reader;
import com.step.shivi_melodyni.ttt.io.Writer;

public class ConsolePresenter implements Presenter {
    private final Writer writer;
    private final Reader reader;

    public ConsolePresenter(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void presentGame(GameDTO gameDTO) {
        BoardDTO boardDTO = gameDTO.getBoardDTO();
        presentPlayers(gameDTO.getPlayer1DTO(), gameDTO.getPlayer2DTO());
        presentBoard(boardDTO);
    }

    @Override
    public int getPlayerMove(String name, int size) {
        String promptMsg = String.format("%s's turn. Please enter the cell number > ", name);
        this.writer.write(promptMsg);
        String input = this.reader.readLine();
        try {
            int playerMove = new Integer(input);
            if (playerMove < 1 || playerMove > size) {
                throw new NumberFormatException();
            }
            return playerMove;
        } catch (NumberFormatException e) {
            String invalidCellError = String.format("*ERROR* Invalid Cell %s, Please provide a vacant cell between " +
                "1-%d\n", input, size);
            this.writer.write(invalidCellError);
            return getPlayerMove(name, size);
        }
    }

    @Override
    public void presentComputerMove(String name, int move) {
        String promptMsg = String.format("%s's turn. Please enter the cell number > %d\n", name, move);
        this.writer.write(promptMsg);
    }

    @Override
    public void presentCellNotVacantError(int move, int size) {
        this.writer.write(String.format("*ERROR* Cell %d is Not Vacant, Please provide a vacant cell between 1-%d\n",
            move, size));
    }

    @Override
    public void declareGameDraw(GameDTO gameDTO) {
        presentPlayers(gameDTO.getPlayer1DTO(), gameDTO.getPlayer2DTO());
        this.presentBoard(gameDTO.getBoardDTO());
        this.writer.write("Game ended in a Draw\n");
    }

    @Override
    public void declareWinner(PlayerDTO winnerDTO, GameDTO gameDTO) {
        presentPlayers(gameDTO.getPlayer1DTO(), gameDTO.getPlayer2DTO());
        this.presentBoard(gameDTO.getBoardDTO());
        this.writer.write(String.format("%s wins\n", winnerDTO.getName()));
    }

    private void presentBoard(BoardDTO boardDTO) {
        char[] board = boardDTO.getCells();
        StringBuilder stringBuilder = new StringBuilder();
        int size = board.length;
        for (int i = 0; i < size; i++) {
            char symbol = board[i];
            if (symbol != '\u0000') {
                stringBuilder.append(symbol).append("  ");
            } else {
                stringBuilder.append(i + 1).append("  ");
            }
            stringBuilder.append((i + 1) % Math.sqrt(size) == 0 ? "\n" : "");
        }
        this.writer.write(stringBuilder.toString());
    }

    private void presentPlayers(PlayerDTO player1DTO, PlayerDTO player2DTO) {
        String divider = "---------------------";
        String player = String.format("%s\n%s:%c %s:%c\n", divider, player1DTO.getName(), player1DTO.getSymbol(),
            player2DTO.getName(), player2DTO.getSymbol());
        this.writer.write(player);
    }

}
