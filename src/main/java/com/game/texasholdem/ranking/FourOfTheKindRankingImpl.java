package com.game.texasholdem.ranking;

import com.game.texasholdem.Constants;
import com.game.texasholdem.Player;
import com.game.texasholdem.RankingEnum;

import java.util.Iterator;
import java.util.Map;

public class FourOfTheKindRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;
        Map<Integer, Integer> rankCount = player.getCardsRankCountMap();

        boolean hasFour = false;

        Iterator<Map.Entry<Integer, Integer>> it = rankCount.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == Constants.HAND_CARD_NUMERS - 1) {
                hasFour = true;
                break;
            }
        }

        if (hasFour) {
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.FOUR_OF_THE_KIND);
        }

        return result;
    }

}
