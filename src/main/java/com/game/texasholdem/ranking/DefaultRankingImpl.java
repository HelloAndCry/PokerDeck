package com.game.texasholdem.ranking;

import com.game.texasholdem.Player;
import com.game.texasholdem.RankingEnum;

public class DefaultRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = new RankingResult();
        result.setRankingEnum(RankingEnum.HIGH_CARD);

        return result;
    }

}
