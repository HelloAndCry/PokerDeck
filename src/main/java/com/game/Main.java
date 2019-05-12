package com.game;

import com.game.texasholdem.Dealer;
import com.game.texasholdem.Player;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dealer d = new Dealer();

        Player black = new Player();
        Player white = new Player();

        d.join(black);
        d.join(white);

        d.start();
        d.showHand();

        List<Player> players = d.getRankingPlayers();

        String judge = null;
        if (players.get(0).compareTo(black) == 0)
            judge = "Black wins";
        if (players.get(0).compareTo(white) == 0)
            judge = "White wins";

        if (judge == null)
            System.out.println("Tie");

        if (judge == "Black wins")
            System.out.println("Black wins");

        if (judge == "White wins")
            System.out.println("White wins");

        System.out.println("牌面" + players.get(0).getCards());
        System.out.println("类型" + players.get(0).getRankingResult().getRankingEnum().getType());

    }

}
