package com.step.shivi_melodyni.ttt.dto;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.*;

public class GameDTOTest {
    @Test
    public void shouldGiveBoardDTO() {
        TreeMap<Integer, Character> cells = new TreeMap<>();
        BoardDTO boardDTO = new BoardDTO(cells, 3);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);

        assertEquals(boardDTO , gameDTO.getBoardDTO());
    }

    @Test
    public void shouldGivePlayer1DTO() {
        TreeMap<Integer, Character> cells = new TreeMap<>();
        BoardDTO boardDTO = new BoardDTO(cells, 3);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);

        assertEquals(player1DTO, gameDTO.getPlayer1DTO());

    }

    @Test
    public void shouldGivePlayer2DTO() {
        TreeMap<Integer, Character> cells = new TreeMap<>();
        BoardDTO boardDTO = new BoardDTO(cells, 3);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);

        assertEquals(player2DTO, gameDTO.getPlayer2DTO());

    }

    @Test
    public void shouldGiveCurrentPlayerDTO() {
        TreeMap<Integer, Character> cells = new TreeMap<>();
        BoardDTO boardDTO = new BoardDTO(cells, 3);
        PlayerDTO player1DTO = new PlayerDTO("Ramesh", 'X');
        PlayerDTO player2DTO = new PlayerDTO("Suresh", 'O');
        GameDTO gameDTO = new GameDTO(boardDTO, player1DTO, player2DTO, player1DTO);

        assertEquals(player1DTO, gameDTO.getCurrentPlayerDTO());
    }
}