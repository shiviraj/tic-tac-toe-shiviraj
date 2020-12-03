package com.step.shivi_melodyni.ttt.main;

import com.step.shivi_melodyni.ttt.model.Game;
import com.step.shivi_melodyni.ttt.model.player.AIPlayer;
import com.step.shivi_melodyni.ttt.model.player.HumanPlayer;
import com.step.shivi_melodyni.ttt.model.player.Player;
import com.step.shivi_melodyni.ttt.presenter.ConsolePresenter;

import java.util.Scanner;

public class SinglePlayerGameRunner {
    public static void main(String[] args) {
        int boardSize = 3;

        String playerName = (args.length > 0) ? args[0] : "Human";
        Player player = new HumanPlayer(playerName, 'X');

        Player opponent = new AIPlayer();

        Game game = new Game(player, opponent, boardSize);

        ConsolePresenter consolePresenter = new ConsolePresenter(System.out::print, new Scanner(System.in)::nextLine);
        game.run(consolePresenter, limit -> (int) (Math.random() * limit));
    }
}
