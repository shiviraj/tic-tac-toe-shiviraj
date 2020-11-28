package com.step.shivi_melodyni;

import com.step.shivi_melodyni.presenter.ConsolePresenter;
import com.step.shivi_melodyni.game.Game;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        String player1;
        String player2;
        try {
            player1 = args[0];
            player2 = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please Enter Both Player's Name!\nEg:- java -jar jarfile Ramesh Suresh");
            return;
        }
        int boardSize = 3;
        Game game = new Game(player1, player2, boardSize);
        ConsolePresenter consolePresenter = new ConsolePresenter(System.out::print, new Scanner(System.in)::nextLine);
        game.run(consolePresenter);
    }
}
