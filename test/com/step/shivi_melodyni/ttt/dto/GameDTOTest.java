package com.step.shivi_melodyni.ttt.dto;

import com.step.shivi_melodyni.ttt.model.Symbol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameDTOTest {
    @Test
    public void shouldGiveBoardDTO() {
        char[] cells = new char[4];
        BoardDTO boardDTO = new BoardDTO(cells);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", Symbol.CROSS.toDTO());
        PlayerDTO player2DTO = new PlayerDTO("Suresh", Symbol.ZERO.toDTO());
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO);

        assertEquals(boardDTO, gameDTO.getBoardDTO());
    }

    @Test
    public void shouldGivePlayer1DTO() {
        char[] cells = new char[9];
        BoardDTO boardDTO = new BoardDTO(cells);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", Symbol.CROSS.toDTO());
        PlayerDTO player2DTO = new PlayerDTO("Suresh", Symbol.ZERO.toDTO());
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO);

        assertEquals(player1DTO, gameDTO.getPlayer1DTO());

    }

    @Test
    public void shouldGivePlayer2DTO() {
        char[] cells = new char[9];
        BoardDTO boardDTO = new BoardDTO(cells);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", Symbol.CROSS.toDTO());
        PlayerDTO player2DTO = new PlayerDTO("Suresh", Symbol.ZERO.toDTO());
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO);

        assertEquals(player2DTO, gameDTO.getPlayer2DTO());

    }

}