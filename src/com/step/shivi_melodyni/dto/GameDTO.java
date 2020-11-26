package com.step.shivi_melodyni.dto;

public class GameDTO {
    private BoardDTO boardDTO;

    public GameDTO(BoardDTO boardDTO) {
        this.boardDTO = boardDTO;
    }

    public char[][] getBoardDTO() {
        return boardDTO.getCells();
    }
}
