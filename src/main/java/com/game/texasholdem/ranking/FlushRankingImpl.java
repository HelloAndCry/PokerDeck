package com.game.texasholdem.ranking;

import com.game.texasholdem.Card;
import com.game.texasholdem.Player;
import com.game.texasholdem.RankingEnum;

import java.util.List;

public class FlushRankingImpl extends AbstractRanking {

    protected RankingResult doResolve(Player player) {

        RankingResult result = null;

        List<Card> cards = player.getCards();
        if (this.isSameSuit(cards)) { // 如果是同色
            result = new RankingResult();
            result.setRankingEnum(RankingEnum.FLUSH);
        }

        return result;
    }

}
