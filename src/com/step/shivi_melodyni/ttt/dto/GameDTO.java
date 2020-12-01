package com.step.shivi_melodyni.ttt.dto;


public class GameDTO {
    private final BoardDTO boardDTO;
    private final PlayerDTO player1DTO;
    private final PlayerDTO player2DTO;
    private final PlayerDTO currentPlayer;

    public GameDTO(BoardDTO boardDTO, PlayerDTO player1DTO, PlayerDTO player2DTO, PlayerDTO currentPlayer) {
        this.boardDTO = boardDTO;
        this.player1DTO = player1DTO;
        this.player2DTO = player2DTO;
        this.currentPlayer = currentPlayer;
    }

    public BoardDTO getBoardDTO() {
        return this.boardDTO;
    }

    public PlayerDTO getPlayer1DTO() {
        return this.player1DTO;
    }

    public PlayerDTO getPlayer2DTO() {
        return this.player2DTO;
    }

    public PlayerDTO getCurrentPlayerDTO() {
        return this.currentPlayer;
    }
}
