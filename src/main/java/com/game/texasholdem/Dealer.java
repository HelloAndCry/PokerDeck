package com.game.texasholdem;

import com.game.texasholdem.ranking.RankingFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Dealer {

    private Poker poker;
    private List<Player> playerList;

    public Dealer() {
        this.poker = new Poker();
        this.playerList = new ArrayList<Player>();
    }

    public Dealer(Player top, Player... players) {
        this();
        this.playerList.add(top);
        this.playerList.addAll(Arrays.asList(players));
    }


    public void join(Player player) {
        this.playerList.add(player);
    }


    public int getPlayerSize() {
        return this.playerList.size();
    }


    public void start() {
        for (int i = 0; i < this.playerList.size(); i++) {
            for (int j = 0; j < Constants.HAND_CARD_NUMERS; j++) {
                this.playerList.get(i).addCard(this.poker.dispatch());
            }
        }
    }


    public void showHand() {
        for (int i = 0; i < this.playerList.size(); i++) {
            RankingFacade.getInstance().resolve(this.playerList.get(i));
        }
    }

    public List<Player> getRankingPlayers() {
        Collections.sort(this.playerList);
        return this.playerList;
    }
}
