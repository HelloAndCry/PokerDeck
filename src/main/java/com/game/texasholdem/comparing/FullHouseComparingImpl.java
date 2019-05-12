package com.game.texasholdem.comparing;

import com.game.texasholdem.Player;

import java.util.Map;

public class FullHouseComparingImpl extends AbstractComparing {

    public int compare(Player o1, Player o2) {
        Map<Integer, Integer> p1CardMap = o1.getCardsRankCountMap();
        Map<Integer, Integer> p2CardMap = o2.getCardsRankCountMap();

        return this.multiComparing(p1CardMap, p2CardMap, 3);
    }

}
