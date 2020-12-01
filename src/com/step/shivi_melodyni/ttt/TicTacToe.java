package com.step.shivi_melodyni.ttt;

import com.step.shivi_melodyni.ttt.ai.AIPlayer;
import com.step.shivi_melodyni.ttt.model.Player;
import com.step.shivi_melodyni.ttt.presenter.ConsolePresenter;
import com.step.shivi_melodyni.ttt.model.Game;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int boardSize = 3;
        String player1Name = "Human";

        AIPlayer aiPlayer = new AIPlayer('O');
        if (args.length > 0) {
            player1Name = args[0];
        }
        Player player = new Player(player1Name, 'X');
        Game game = new Game(player, aiPlayer, boardSize);
        if (args.length > 1) {
            Player opponent = new Player(args[1], 'O');
            game = new Game(player, opponent, boardSize);
        }

        ConsolePresenter consolePresenter = new ConsolePresenter(System.out::print, new Scanner(System.in)::nextLine);
        game.run(consolePresenter);
    }
}
