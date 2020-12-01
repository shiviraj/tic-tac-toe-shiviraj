package com.step.shivi_melodyni.ttt;

import com.step.shivi_melodyni.ttt.ai.AIPlayer;
import com.step.shivi_melodyni.ttt.model.Game;
import com.step.shivi_melodyni.ttt.model.player.HumanPlayer;
import com.step.shivi_melodyni.ttt.presenter.ConsolePresenter;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int boardSize = 3;
        String player1Name = "Human";

        AIPlayer aiPlayer = new AIPlayer();
        if (args.length > 0) {
            player1Name = args[0];
        }
        HumanPlayer HumanPlayer = new HumanPlayer(player1Name, 'X');
        Game game = new Game(HumanPlayer, aiPlayer, boardSize);
        if (args.length > 1) {
            HumanPlayer opponent = new HumanPlayer(args[1], 'O');
            game = new Game(HumanPlayer, opponent, boardSize);
        }

        ConsolePresenter consolePresenter = new ConsolePresenter(System.out::print, new Scanner(System.in)::nextLine);
        game.run(consolePresenter);
    }
}
