package com.game.texasholdem.ranking;

import com.game.texasholdem.Player;
import com.game.texasholdem.RankingEnum;

import java.util.Iterator;
import java.util.Map;

public class OnePairRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        boolean hasOne = false;

        if (rankCount.size() == 4) {
            Iterator<Map.Entry<Integer, Integer>> it = rankCount.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> next = it.next();
                if (next.getValue() == 2 || next.getValue() == 1) {
                    hasOne = true;
                    break;
                }
            }
        }

        if (hasOne) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.ONE_PAIR);
        }

        return result;
    }

}
