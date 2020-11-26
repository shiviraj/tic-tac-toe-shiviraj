package com.step.shivi_melodyni;

import com.step.shivi_melodyni.presenter.ConsolePresenter;
import com.step.shivi_melodyni.game.Game;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        String player1 = "Ramesh";
        String player2 = "Suresh";

        int boardSize = 3;
        Game game = new Game(player1, player2, boardSize);
        ConsolePresenter consolePresenter = new ConsolePresenter(System.out::print, new Scanner(System.in)::nextInt);
        game.run(consolePresenter);
    }
}
